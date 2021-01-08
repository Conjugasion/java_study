package Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Lucas
 * @date 2019/4/19 15:49
 */
public class AtomicStampedReferenceDemo {
    public static final AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    public static final AtomicInteger money1 = new AtomicInteger(19);

    public static void main(String[] args) {
        int stamp = money.getStamp();
        // 用三个线程去充值，但是需确保仅充值一次
        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        Integer m = money.getReference();
                        if(m<20){
                            if(money.compareAndSet(m, m+20, stamp, stamp+1)){
                                System.out.println("余额小于20，已充值，现在余额为 " + money.getReference() + "元");
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        // 消费
        new Thread(){
            @Override
            public void run() {
                while (true){
                    Integer m = money.getReference();
                    int stamp = money.getStamp();
                    if(m >= 10){
                        money.compareAndSet(m, m-10, stamp, stamp+1);
                        System.out.println("成功消费10元,余额为 " + money.getReference() + "元");
                    }else {
                        System.out.println("没有足够的钱");
                        break;
                    }
                }
            }
        }.start();

        // 如果不使用AtomicStampedReference
//        for (int i = 0; i < 3; i++) {
//            new Thread(){
//                @Override
//                public void run() {
//                    while (true){
//                        Integer m = money1.get();
//                        if(m<20){
//                            if(money1.compareAndSet(m, m+20)){
//                                System.out.println("余额小于20，已充值，现在余额为 " + money1.get() + "元");
//                                break;
//                            }else {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }.start();
//        }
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (true){
//                    Integer m = money1.get();
//                    if(m >= 10){
//                        money1.compareAndSet(m, m-10);
//                        System.out.println("成功消费10元,余额为 " + money1.get() + "元");
//                    }else {
//                        System.out.println("没有足够的钱");
//                        break;
//                    }
//                }
//            }
//        }.start();

    }
}

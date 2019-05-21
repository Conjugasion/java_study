package innerClass;

import innerClass.OuterClass;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Lucas
 * @date 2019/3/1 20:59
 */
public class tester{
    static OuterClass.InnerClass inner = new OuterClass().new InnerClass();
    {
        inner.func();
    }
    public static void asd(){
        System.out.println("asd");
        OuterClass.zxc();
    }

//    public static void qwe(){
//        this.qwe();
//    }

    public static void main(String[] args){


        Lock l = new ReentrantLock();
        Condition c1 = l.newCondition();
        List<String> list = new CopyOnWriteArrayList<>();


        Integer var1=new Integer(1);
        Integer var2=var1;
        doSomething(var2);
        System.out.print(var1.intValue());
        System.out.print(var1==var2);

        System.out.println(var1.getClass());
        System.out.println(var1.getClass().getName());
        System.out.println(var1.getClass().getSimpleName());
    }
    public static void doSomething(Integer integer){
        integer=new Integer(2);
    }
}

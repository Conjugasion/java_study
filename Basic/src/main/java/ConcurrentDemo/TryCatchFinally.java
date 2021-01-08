package ConcurrentDemo;

/**
 * @author Lucas
 * @date 2019/4/17 9:31
 */
public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println(TryCatchFinally.test1());   //try出错，会执行catch语句u，若catch内没有return，返回try-catch-finally之后的return
        System.out.println("************");
        System.out.println(TryCatchFinally.test2());   // try未出错且try中有return，try-catch-finally之后的return不执行
        System.out.println("************");
        System.out.println(TryCatchFinally.test3());   // try出错，会执行catch语句，若catch内有return，try-catch-finally之后不能存在return
        System.out.println("************");
        System.out.println(TryCatchFinally.test4());   // finally中的return会覆盖try中的return，try-catch-finally之后的return不执行
    }

    public static int test1() {
        try{
            int a = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错啦");
        }
        return -1;
    }

    public static int test2() {
        try{
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错啦");
        }
        return -1;
    }

    public static int test3() {
        try{
            return 1/0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错啦");
            return -2;
        }
        // return -1;
    }

    public static int test4() {
        try{
            return 1/0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错啦");
        }finally {
            if(0==0){
                return 0;
            }
        }
        return -1;
    }

}

package ExceptionDemo;

/**
 * @auther Lucas
 * @date 2019/1/6 15:27
 */
public class runtimeExceptionDemo {
    public static void main(String[] args) {
        function1();

        try {
            function2();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static void function1(){
        int i = 1/0;
    }
    public static void function2() throws Exception {
        throw new Exception();
    }
}

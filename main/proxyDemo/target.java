package proxyDemo;

/**
 * @auther Lucas
 * @date 2019/1/25 10:34
 */
public class target implements targetInterface{
    @Override
    public void method() {
        System.out.println("method run ...");
    }
    public void method1(){
        System.out.println("method1 run ...");
    }
    public String method2(){
        System.out.println("method2 run ...");
        return "method2";
    }
}

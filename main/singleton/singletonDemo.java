package singleton;

/**
 * @author Lucas
 * @date 2019/4/22 15:58
 * 普通单例
 */
public class singletonDemo {
    static String word = "I'm singleton";
    private singletonDemo(){
        System.out.println("singletonDemo is created!");
    }
    private static singletonDemo singletonDemo = new singletonDemo();
    public singletonDemo getInstance(){
        return singletonDemo;
    }


}

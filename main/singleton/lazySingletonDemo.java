package singleton;

/**
 * @author Lucas
 * @date 2019/4/22 16:05
 * 延迟加载,需要实例时才创建
 */
public class lazySingletonDemo {
    static String word = "I'm singleton";
    private lazySingletonDemo(){
        System.out.println("lazySingletonDemo is created !");
    }
    private static lazySingletonDemo lazySingletonDemo = null;
    public static synchronized lazySingletonDemo getInstance(){
        if (lazySingletonDemo == null){
            lazySingletonDemo =  new lazySingletonDemo();
        }
        return lazySingletonDemo;
    }
}

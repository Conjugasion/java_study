package DesignMode.SingletonMode;

/**
 * @author Lucas
 * @date 2019/4/22 16:05
 * 延迟加载,需要实例时才创建
 */
public class SynchronizedSingleton {
    static String word = "I'm singleton";
    private SynchronizedSingleton(){
        System.out.println("lazySingletonDemo is created !");
    }
    private static SynchronizedSingleton lazySingletonDemo = null;
    public static synchronized SynchronizedSingleton getInstance(){
        if (lazySingletonDemo == null){
            lazySingletonDemo =  new SynchronizedSingleton();
        }
        return lazySingletonDemo;
    }
}

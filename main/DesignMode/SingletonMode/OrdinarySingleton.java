package DesignMode.SingletonMode;

/**
 * @author Lucas
 * @date 2019/4/22 15:58
 * 普通单例
 */
public class OrdinarySingleton {
    static String word = "I'm singleton";
    private OrdinarySingleton(){
        System.out.println("singletonDemo is created!");
    }
    private static OrdinarySingleton singletonDemo = new OrdinarySingleton();
    public OrdinarySingleton getInstance(){
        return singletonDemo;
    }


}

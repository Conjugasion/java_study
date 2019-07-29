package DesignMode.SingletonMode;

/**
 * @author Lucas
 * @date 2019/7/29 14:16
 */
public class DoubleCheckSingleton {
    private DoubleCheckSingleton(){
        System.out.println("双重检查");
    }
    private static DoubleCheckSingleton singleton = null;
    DoubleCheckSingleton getInstance(){
        if (singleton==null){
            synchronized (DoubleCheckSingleton.class){
                if (singleton==null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}

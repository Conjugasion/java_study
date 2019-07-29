package DesignMode.SingletonMode;

/**
 * @author Lucas
 * @date 2019/7/29 14:20
 * 最完美的方法！
 * INSTANCE是EnumSingleton的一个实例，构造器默认私有
 */
public enum EnumSingleton {
    INSTANCE;
    void whatEverMethod(){
        System.out.println("我是EnumSingleton的一个方法");
    }
}

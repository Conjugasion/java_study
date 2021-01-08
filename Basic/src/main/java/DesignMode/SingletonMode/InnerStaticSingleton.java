package DesignMode.SingletonMode;

/**
 * @author Lucas
 * @date 2019/7/4 9:51
 * 内部类
 */
public class InnerStaticSingleton {
    private InnerStaticSingleton(){
        System.out.println("构造方法");
    }
    private static class Inner{
        private final static InnerStaticSingleton instance = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance(){
        return Inner.instance;
    }
}

package DesignMode.SingletonMode;

/**
 * @author Lucas
 * @date 2019/7/29 14:22
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.whatEverMethod();
    }
}

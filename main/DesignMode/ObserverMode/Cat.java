package DesignMode.ObserverMode;

/**
 * @author Lucas
 * @date 2019/7/29 15:35
 * 具体的被观察者
 */
public class Cat extends AbstractAim{
    @Override
    // 当条件触发时notice所有观察者
    void notice() {
        System.out.println("猫来了");
        for (Observer observer:observers) {
            observer.response();
        }
    }
}

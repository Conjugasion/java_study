package DesignMode.AdapterMode.ProxyClass;

/**
 * @author Lucas
 * @date 2019/7/29 15:02
 */
public class DogAdaptRobot extends Dog implements Robot {
    @Override
    public void cry() {
        shout();
    }

    @Override
    public void move() {
        run();
    }
}

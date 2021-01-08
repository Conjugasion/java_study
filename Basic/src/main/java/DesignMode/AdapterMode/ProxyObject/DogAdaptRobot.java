package DesignMode.AdapterMode.ProxyObject;


/**
 * @author Lucas
 * @date 2019/7/29 15:02
 */
public class DogAdaptRobot extends Robot {
    Dog dog = new Dog();
    @Override
    public void cry() {
        dog.shout();
    }

    @Override
    public void move() {
        dog.run();
    }
}

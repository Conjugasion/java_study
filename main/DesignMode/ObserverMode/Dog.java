package DesignMode.ObserverMode;

/**
 * @author Lucas
 * @date 2019/7/29 15:38
 */
public class Dog implements Observer {
    @Override
    public void response() {
        System.out.println("Dog: 揍猫");
    }
}

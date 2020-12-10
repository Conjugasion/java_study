package DesignMode.ObserverMode;

/**
 * @author Lucas
 * @date 2019/7/29 15:39
 */
public class Mouse implements Observer {
    @Override
    public void response() {
        System.out.println("Mouse: 猫来了，快跑");
    }
}

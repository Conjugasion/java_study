package DesignMode.FactoryMode.AbstractFactory;

/**
 * @author Lucas
 * @date 2019/7/29 14:00
 */
public class HairTV implements TV{
    @Override
    public void play() {
        System.out.println("海尔电视");
    }
}

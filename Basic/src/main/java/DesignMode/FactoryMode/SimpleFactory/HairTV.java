package DesignMode.FactoryMode.SimpleFactory;

/**
 * @author Lucas
 * @date 2019/7/29 13:43
 */
public class HairTV implements TV{
    @Override
    public void play() {
        System.out.println("海尔电视机");
    }
}

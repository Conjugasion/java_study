package DesignMode.FactoryMode.AbstractFactory;

/**
 * @author Lucas
 * @date 2019/7/29 14:03
 */
public class HairAirConditioner implements AirConditioner {
    @Override
    public void using() {
        System.out.println("海尔空调");
    }
}

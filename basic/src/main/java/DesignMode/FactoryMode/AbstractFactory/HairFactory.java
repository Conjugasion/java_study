package DesignMode.FactoryMode.AbstractFactory;

/**
 * @author Lucas
 * @date 2019/7/29 14:05
 */
public class HairFactory implements AbstractFactory {
    @Override
    public TV productTV() {
        return new HairTV();
    }

    @Override
    public AirConditioner productAirConditioner() {
        return new HairAirConditioner();
    }
}

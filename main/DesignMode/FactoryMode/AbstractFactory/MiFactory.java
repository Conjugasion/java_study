package DesignMode.FactoryMode.AbstractFactory;

/**
 * @author Lucas
 * @date 2019/7/29 14:05
 */
public class MiFactory implements AbstractFactory {
    @Override
    public TV productTV() {
        return new MiTV();
    }

    @Override
    public AirConditioner productAirConditioner() {
        return new MiAirConditioner();
    }
}

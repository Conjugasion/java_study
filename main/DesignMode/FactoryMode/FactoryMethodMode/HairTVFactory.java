package DesignMode.FactoryMode.FactoryMethodMode;

/**
 * @author Lucas
 * @date 2019/7/29 13:57
 */
public class HairTVFactory implements AbstractFactory {
    @Override
    public TV product() {
        return new HairTV();
    }
}

package DesignMode.FactoryMode.AbstractFactory;

/**
 * @author Lucas
 * @date 2019/7/29 13:59
 * 1）AbstractFactory（抽象工厂）：用于声明生成抽象产品的方法，可以定义一组方法。
 * （2）ConcreteFactory（具体工厂）：实现抽象工厂声明生成抽象产品的方法。
 * （3）AbstractProduct（抽象产品）：为每种产品声明接口。
 * （4）ConcreteFactory（具体产品）：实现抽象产品接口中的业务方法，定义具体工厂生产的具体产品对象。
 *
 * （1）优点：一个产品族中的多个对象被设计一起使用，能保证客户始终只使用同一个产品族的对象；增加新的具体工厂和产品族简单方便。
 * （2）缺点：具体工厂实现了抽象工厂接口，故增加新产品的特有功能不被允许。
 *
 * 抽象工厂模式：在工厂方法的基础上增加了产品族，抽象工厂可定义产品族的多个产品的方法，具体工厂创建产品族的所有产品。
 */
public interface AbstractFactory {
    TV productTV();
    AirConditioner productAirConditioner();
}

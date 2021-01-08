package DesignMode.FactoryMode.FactoryMethodMode;

/**
 * @author Lucas
 * @date 2019/7/29 13:49
 * （1）Factory（抽象工厂）：模式的核心类，声明了工厂方法，返回一个产品。
 * （2）ConcreteFactory（具体工厂）：实现抽象工厂中定义的方法，可由客户端调用，返回一个产品实例。
 * （3）Product（抽象产品）：所有具体产品类的父类，提供公共的接口。
 * （4）ConcreteProduct（具体产品）：继承抽象产品角色，实现其抽象方法。
 *
 * （1）优点：增加新产品类时无需修改现有系统，符合“开闭原则”；封装产品的创建细节 ，用户无需关注。
 * （2）缺点：增加新产品需要增加新的工厂类，增加了系统的复杂性。
 *
 * 工厂方法模式：在简单工厂的基础上将工厂分解为抽象工厂和具体工厂，添加新产品时需要创建生产该产品的具体工厂，该具体工厂必须继承或实现抽象工厂。
 */
public interface AbstractFactory {
    TV product();
}

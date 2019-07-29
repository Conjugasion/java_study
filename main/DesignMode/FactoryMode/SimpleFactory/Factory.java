package DesignMode.FactoryMode.SimpleFactory;

/**
 * @author Lucas
 * @date 2019/7/29 13:41
 * （1）Factory（工厂角色）：模式的核心类，提供静态工厂方法，用于创建产品对象。
 * （2）Product（抽象产品角色）：所有具体产品类的父类，提供公共的接口。
 * （3）ConcreteProduct（具体产品角色）：继承抽象产品角色，实现其抽象方法。
 *
 * （1）优点：对象的创建和对象的使用分离，对象的创建由专门的工厂类完成。
 * （2）缺点：工厂类包含了所有产品的创建逻辑，一旦出现问题，整个系统将不能工作；产品数量太多会导致工厂类过于复杂，
 *           不利于系统的扩展和维护；静态工厂方法使得工厂类不能很好地利用继承的特性。
 *
 *  简单工厂模式：提供一个工厂用于生产所有产品，添加新产品时必须将该产品的生产逻辑写入这个唯一的工厂。
 */
public class Factory {
    public TV product(String brand){
        if (brand.equals("HairTV")){
            return new HairTV();
        }else if (brand.equals("MiTV")){
            return new MiTV();
        }else return null;
    }
}

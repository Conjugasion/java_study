package DesignMode.BuilderMode;

/**
 * @author Lucas
 * @date 2019/7/29 16:40
 */
public abstract class AbstaractBuilder {
    abstract void buildIFrame();
    abstract void buildISeat();
    abstract void buildITire();
    abstract Bike createBike();
}

package DesignMode.BuilderMode;

/**
 * @author Lucas
 * @date 2019/7/29 16:49
 */
public class Director {
    private AbstaractBuilder builder;
    public Director(AbstaractBuilder builder){
        this.builder = builder;
    }

    public Bike product(){
        builder.buildIFrame();
        builder.buildISeat();
        builder.buildITire();
        return builder.createBike();
    }
}

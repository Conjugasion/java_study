package DesignMode.BuilderMode;

/**
 * @author Lucas
 * @date 2019/7/29 16:47
 */
public class OfoBikeBuilder extends AbstaractBuilder {
    Bike OBike = new Bike();
    @Override
    void buildIFrame() {
        OBike.setiFrame(new OfoFrame());
    }

    @Override
    void buildISeat() {
        OBike.setiSeat(new OfoSeat());
    }

    @Override
    void buildITire() {
        OBike.setiTire(new OfoTire());
    }

    Bike createBike(){
        return OBike;
    }
}

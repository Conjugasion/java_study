package DesignMode.BuilderMode;

/**
 * @author Lucas
 * @date 2019/7/29 16:42
 */
public class MoBikeBuilder extends AbstaractBuilder {
    private Bike mBike = new Bike();
    @Override
    void buildIFrame() {
        mBike.setiFrame(new MoFrame());
    }

    @Override
    void buildISeat() {
        mBike.setiSeat(new MoSeat());
    }

    @Override
    void buildITire() {
        mBike.setiTire(new MoTire());
    }

    Bike createBike(){
        return mBike;
    }
}

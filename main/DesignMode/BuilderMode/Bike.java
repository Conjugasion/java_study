package DesignMode.BuilderMode;

/**
 * @author Lucas
 * @date 2019/7/29 16:35
 * 产品类
 */
public class Bike {
    // 自行车由车架、坐凳和轮胎构成
    private IFrame iFrame;
    private ISeat iSeat;
    private ITire iTire;

    public IFrame getiFrame() {
        return iFrame;
    }

    public void setiFrame(IFrame iFrame) {
        this.iFrame = iFrame;
    }

    public ISeat getiSeat() {
        return iSeat;
    }

    public void setiSeat(ISeat iSeat) {
        this.iSeat = iSeat;
    }

    public ITire getiTire() {
        return iTire;
    }

    public void setiTire(ITire iTire) {
        this.iTire = iTire;
    }
}

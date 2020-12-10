package DesignMode.BuilderMode;

/**
 * @author Lucas
 * @date 2019/7/29 16:53
 */
public class Test {
    public static void main(String[] args) {
        Director ofo = new Director(new OfoBikeBuilder());
        Bike ofoBike = ofo.product();
        System.out.println(ofoBike.getClass());
    }
}

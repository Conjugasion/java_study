package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019/8/18 11:44
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(Power(2.0, 10));
    }

    static double Power(double base, int exponent) {
        if (exponent<0){
            exponent = -exponent;
            base = 1/base;
        }
        double[] assist = new double[exponent+1];
        for (int i = 1; i <= exponent; i++) {
            assist[i] = -1;
        }
        assist[0] = 1;
        return Power(base, exponent, assist);
    }

    static double Power(double base, int exponent, double[] assist){
        if (assist[exponent]!=-1){
            return assist[exponent];
        }
        assist[exponent] = base*Power(base, exponent-1, assist);
        return assist[exponent];
    }
}

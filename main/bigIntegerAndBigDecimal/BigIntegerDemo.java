package bigIntegerAndBigDecimal;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * @auther Lucas
 * @date 2018/12/28 10:38
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("123345678904567845678567567");
        System.out.println(a);
        BigInteger b = new BigInteger("1233456789045678456785675672345675678");
        System.out.println(a);

        long l = new Double(Math.pow(2,63)).longValue();
        System.out.println(l);

        double d = 756.2345566;

        //方法一：最简便的方法，调用DecimalFormat类
        DecimalFormat df = new DecimalFormat(".000");
        System.out.println(df.format(d));

        // 四舍五入取整
        System.out.println(Math.round(d));


    }
}

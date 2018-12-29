package bigIntegerAndBigDecimal;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

/**
 * @auther Lucas
 * @date 2018/12/28 13:41
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("0.09");
        BigDecimal b2 = new BigDecimal("0.01");

        System.out.println(0.09+0.01);
        System.out.println(1-0.32);
        System.out.println(b1.add(b2));
        System.out.println(b1.divide(b2,2,ROUND_UP));
    }
}

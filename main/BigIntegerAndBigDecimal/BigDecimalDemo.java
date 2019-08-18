package BigIntegerAndBigDecimal;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_DOWN;
import static java.math.BigDecimal.ROUND_UP;

/**
 * @auther Lucas
 * @date 2018/12/28 13:41
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("0.09");
        BigDecimal b2 = new BigDecimal("0.02");

        System.out.println(0.09+0.01);
        System.out.println(1-0.32);
        System.out.println(b1.add(b2));
        System.out.println(b1.divide(b2,0,ROUND_DOWN));  // 向下取整，保留零位小数
        // 1、ROUND_UP
        //
        //始终对非舍弃部分前面的数字加1。
        //
        //0.1203456789,当精度为3的时候，按照round_up模式，结果是0.121
        //
        //-0.1203456789,当精度为3的时候，按照round_up模式，结果是-0.121
        //
        //注意：0.1891，当精度为3的时候，按照round_up模式，结果是0.19，自动去掉了9后面的0
        //
        //而当0.91，当精度为1的时候，按照round_up模式，结果是1.0，保留了唯一一个小数点后面的0
        // ————————————————
        // 2、ROUND_DOWN
        //
        //从不对舍弃部分前面的数字加1，即截短。
        //
        //0.1203456789,当精度为3的时候，按照round_down模式，结果是0.12，自动去掉了2后面的0
        //
        //-0.1203456789,当精度为3的时候，按照round_up模式，结果是-0.12，自动去掉了2后面的0
        //
        //注意：0.1891，当精度为3的时候，按照round_up模式，结果是0.189，
        //
        //而当0.91，当精度为1的时候，按照round_up模式，结果是1.0，保留了唯一一个小数点后面的0
        //
        //3、ROUND_CEILING
        //
        //接近正无穷大的舍入模式。
        //
        //如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;
        //
        //如果为负，则舍入行为与 ROUND_DOWN 相同。
        //
        //注意，此舍入模式始终不会减少计算值。
        //
        //4、ROUND_FLOOR
        //
        //接近负无穷大的舍入模式。
        //
        //如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;
        //
        //如果为负，则舍入行为与 ROUND_UP 相同。
        //
        //注意，此舍入模式始终不会增加计算值。
        //
        //5、ROUND_HALF_UP
        //
        //向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
        //
        //如果舍弃部分 >= 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同。
        //
        //注意，这是我们大多数人在小学时就学过的舍入模式(四舍五入)。
        //
        //6、ROUND_HALF_DOWN
        //
        //向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。
        //
        //如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同(五舍六入)。
        // ————————————————
    }
}

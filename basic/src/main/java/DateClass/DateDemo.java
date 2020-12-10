package DateClass;

import java.util.Date;

/**
 * @auther Lucas
 * @date 2019/1/3 16:37
 * 不推荐使用date类，时间和日期类
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date(0L);
        System.out.println(date);

        System.out.println(date.getTime());
    }
}

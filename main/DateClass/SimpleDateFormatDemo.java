package DateClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther Lucas
 * @date 2019/1/3 16:46
 * 推荐使用
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");
        System.out.println(sdf1.format(new Date()));

        // 字符串转Date类
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = "2019/01/03";
        Date date = sdf2.parse(dateStr);
        System.out.println(date);
    }
}

package algorithm.offer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lucas
 * @date 2019/7/3 16:24
 * new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
 */
public class HowManyDayTo18 {
    public static void main(String[] args) throws ParseException {
        countDay("2001-07-03");
    }

    static void execise(String birthday) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date past = dateFormat.parse(birthday);

        Calendar calendar = Calendar.getInstance();
        //calendar.set(1994, 10, 15, 9, 27, 50);
        //System.out.println(calendar.getTime());  // Tue Nov 15 09:27:50 CST 1994
        //System.out.println(calendar.get(Calendar.MONTH));
        calendar.setTime(past);
        calendar.add(Calendar.YEAR,18);
        Date years18 = calendar.getTime();
        String format = dateFormat.format(years18);
        System.out.println("18岁生日: " + format);  // 18岁生日: 2012-10-15
        //calendar.clear();
        //System.out.println(calendar.getTime());  // Mon Oct 15 00:00:00 CST 2012
    }

    static void countDay(String birthday) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = dateFormat.parse(birthday);
        //System.out.println(birth);              // Sun Jul 15 00:00:00 CST 2001
        Calendar cal1 = Calendar.getInstance();   // 生日
        cal1.setTime(birth);
        Calendar cal2 = Calendar.getInstance();   // 18年后
        cal2.setTime(birth);
        cal2.add(Calendar.YEAR, 18);

        Calendar cal3 = Calendar.getInstance();   // 现在时间

        if (cal2.getTimeInMillis() > cal3.getTimeInMillis()){
            System.out.println("还没到18岁");
        }
        else {
            long days = (cal2.getTimeInMillis() - cal1.getTimeInMillis())/(3600*1000*24);
            System.out.println("到十八岁有" + days + "天");
        }
    }
}

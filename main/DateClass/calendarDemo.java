package DateClass;

import java.util.Calendar;

/**
 * @auther Lucas
 * @date 2019/1/3 19:18
 */
public class calendarDemo {
    public static void main(String[] args) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        // System.out.println(cal);

        System.out.println("今年："+cal1.get(Calendar.YEAR));

        cal2.set(1994,10,15);
        long days = (cal1.getTimeInMillis()-cal2.getTimeInMillis())/(3600*24*1000);
        System.out.println(days);

    }
}

/**
 * Copyright (C), 2011-2017
 * File Name: DateUtils.java
 * Encoding: UTF-8
 * Date: 17-9-5 下午6:32
 * History:
 */
package Util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @FileName  DateUtils.java
 * @author colley
 * @version 1.0  Date: 17-9-5 下午6:32
 */
public class DateTimeUtils {

    public static Calendar string2Calendar(String strtime) {
        Date d = string2Date(strtime);

        if (d != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(d);

            return c;
        }

        return null;
    }

    public static Date string2Date(String strtime) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DFormatEnum.DATA_FORMAT_DEFAULT);

            return dateFormat.parse(strtime, new ParsePosition(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date string2Date(String strtime, String datepattern) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);

            return dateFormat.parse(strtime, new ParsePosition(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Timestamp string2Timestamp(String strtime, String datepattern) {
        Date date = string2Date(strtime, datepattern);

        if (date != null) {
            return new Timestamp(date.getTime());
        }

        return null;
    }

    public static Timestamp string2Timestamp(String strtime, DFormatEnum datepattern) {
        Date date = string2Date(strtime, datepattern.pattern);

        if (date != null) {
            return new Timestamp(date.getTime());
        }

        return null;
    }

    public static String calendar2String(Calendar time) {
        return date2String(time.getTime());
    }

    public static String date2String(Date time, String datepattern) {
        if (StringUtils.isEmpty(datepattern)) {
            datepattern = DFormatEnum.DATA_FORMAT_DEFAULT;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);

        try {
            return dateFormat.format(time);
        } catch (Exception e) {
            return null;
        }
    }

    public static String date2String(Timestamp time, String datepattern) {
        if (StringUtils.isEmpty(datepattern)) {
            datepattern = DFormatEnum.DATA_FORMAT_DEFAULT;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);

        try {
            return dateFormat.format(time);
        } catch (Exception e) {
            return null;
        }
    }

    public static String date2String(Date time) {
        return date2String(time, null);
    }

    public static String date2String(Timestamp time) {
        return date2String(time, null);
    }

    public static String getSystemTime(String format) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(format);

        return df.format(date);
    }

    /**
     * 将String类型日期转换为Date类型的日期
     *
     * @param strDate
     * @param formatter
     * @return
     */
    public static Date parseDateByStr(String strDate, String formatter) {
        if ((formatter == null) || formatter.trim().equals("")) {
            formatter = DFormatEnum.YYYY_MM_DD.pattern;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatter);

        // 必须捕获异常
        try {
            Date date = simpleDateFormat.parse(strDate);

            return date;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String formateDateShort(Date date) {
        return date2String(date, DFormatEnum.YYYY_MM_DD.pattern);
    }

    public static String getStringDateShort() {
        return date2String(new Date(), DFormatEnum.YYYY_MM_DD.pattern);
    }

    public static String getStringDateForCahce() {
        return date2String(new Date(), DFormatEnum.YYYYMMDD.pattern);
    }

    public static String formateDateFull(Date date) {
        return date2String(date, DFormatEnum.YYYY_MM_DDHH_MM_SS.pattern);
    }

    public static String formateDateFull() {
        return formateDateFull(new Date());
    }

    public static Date fomateStringDate(String str) {
        try {
            int index = str.indexOf(":");
            SimpleDateFormat df = null;

            if (index != -1) {
                df = new SimpleDateFormat(DFormatEnum.YYYY_MM_DDHH_MM_SS.pattern);
            } else {
                df = new SimpleDateFormat(DFormatEnum.YYYY_MM_DD.pattern);
            }

            Date date = df.parse(str);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date getLastTimeDay(Date date) {
        String dateTemp = formateDateShort(date);
        Date date1 = fomateStringDate(dateTemp + " 23:59:59");

        return date1;
    }

    /**
     * 获取在给定日期的基础上往前/后的第几周
     *
     * @param date 给定日期
     * @param gap 移动的周数
     * @return 年+周 例如 201532,2015年的第32周
     */
    public static int weekOfYear(Date date, Integer gap) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, gap);

        return Integer.valueOf(String.valueOf(calendar.get(Calendar.YEAR)) + String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)));
    }

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 计算Date2 - Date1相差分钟数
     * @param date1
     * @param date2
     * @return
     */
    public static int getDiffMins(Date date1, Date date2) {
        return (int)(date2.getTime() - date1.getTime()) / (1000 * 60);
    }

    public static int getDiffMins(long timestamp1, long timestamp2) {
        return (int)(timestamp2 - timestamp1) / (1000 * 60);
    }

    /**
     * 获取下一天同时间日期
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        long nextDay = date.getTime() + (24 * 60 * 60 * 1000);
        return new Date(nextDay);
    }

    /**
     * 获取下一天同时间日期
     * @param dateStr
     * @return yyyy-MM-dd
     */
    public static String getNextDayStr(String dateStr) {
        long nextDay = string2Date(dateStr, "yyyy-MM-dd").getTime() + (24 * 60 * 60 * 1000);
        Date nextDate = new Date(nextDay);
        return date2String(nextDate, "yyyy-MM-dd");
    }

    /**
     * 比较前者和后者时间前后.前者时间小返回-1，相等返回0，前者时间大返回1
     * @param date1
     * @param date2
     * @return
     */
    public static int compare(Date date1, Date date2) {
        if(date1.getTime() > date2.getTime()) {
            return 1;
        } else if(date1.getTime() ==  date2.getTime()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static Date getCurrentDayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getCurrentDayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

}

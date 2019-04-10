package com.yiwei.ywt.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/1/15 23:40
 */
public abstract class DateUtils {

    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";


    /**
     * 时间差（d2-d1)
     *
     * @param d1    开始时间
     * @param d2    结束时间
     * @return
     */
    public static long timeDifference(Date d1, Date d2){
        if(null == d1 || null == d2){
            return 0L;
        }
        return (d2.getTime() - d1.getTime())/1000;
    }

    /**
     * 一天前的日期
     * @param date
     * @return
     */
    public static Date lastDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 时间格式化,返回字符串（yyyy-MM-dd）
     * @param value
     * @return
     */
    public static String dateToShortString(Date value){
        DateFormat formatter = new SimpleDateFormat(SHORT_DATE_FORMAT);
        String shortDate = formatter.format(value);
        return shortDate;
    }

    /**
     * 时间格式化,返回字符串（yyyyMMdd）
     * @param value
     * @return
     */
    public static String getYyyymmdd(Date value){
        DateFormat formatter = new SimpleDateFormat(YYYYMMDD);
        String shortDate = formatter.format(value);
        return shortDate;
    }

    /**
     * 时间格式化，返回日期类型（yyyy-MM-dd）
     * @param value
     * @return
     */
    public static Date stringToShortDate(String value){
        DateFormat formatter = new SimpleDateFormat(SHORT_DATE_FORMAT);
        Date date = null;
        try {
            date = formatter.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间格式化,返回字符串（YYYYMMDDHHMMSS）
     * @param value
     * @return
     */
    public static String getYyyymmddhhmmss(Date value){
        DateFormat formatter = new SimpleDateFormat(YYYYMMDDHHMMSS);
        String dateStr = formatter.format(value);
        return dateStr;
    }

    /**
     * 时间格式化,返回字符串（yyyy-MM）
     * @param value
     * @return
     */
    public static String formatToYearAndMonth(Date value){
        DateFormat formatter = new SimpleDateFormat(YEAR_MONTH_FORMAT);
        String date = formatter.format(value);
        return date;
    }

    /**
     * 时间格式化，返回日期类型（yyyy-MM）
     * @param value
     * @return
     */
    public static Date stringToYearMonth(String value){
        DateFormat formatter = new SimpleDateFormat(YEAR_MONTH_FORMAT);
        Date date = null;
        try {
            date = formatter.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间加减天数
     * @param oldDate
     * @param i
     * @return
     */
    public static Date addDay(final Date oldDate, final int i){
        Calendar g = Calendar.getInstance();
        g.setTime(oldDate);
        g.add(Calendar.DAY_OF_MONTH, i);
        return g.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate){
        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
        try {
            smdate=sdf.parse(sdf.format(smdate));
            bdate=sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期相差月份
     * @param date1 <Date>
     * @param date2 <Date>
     * @return int
     */
    public static int getMonthSpace(Date date1, Date date2){
        int result = 0;
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(date1);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);
        result = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12 + cal1.get(Calendar.MONTH)
                - cal2.get(Calendar.MONTH);
        return Math.abs(result);
    }

    /**
     * 加减月份
     * @param oldDate
     * @param i
     * @return
     */
    public static Date addMonth(final Date oldDate, final int i) {
        Calendar g = Calendar.getInstance();
        g.setTime(oldDate);
        g.add(Calendar.MONTH, i);
        return g.getTime();
    }

    /**
     * 加减年份
     * @param oldDate
     * @param i
     * @return
     */
    public static Date addYear(final Date oldDate, final int i) {
        Calendar g = Calendar.getInstance();
        g.setTime(oldDate);
        g.add(Calendar.YEAR, i);
        return g.getTime();
    }

}

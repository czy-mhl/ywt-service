package com.yiwei.ywt.framework.utils;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 时间工具类</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/1/15 23:40
 */
public abstract class DateUtils {
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DETAULR_TIME_ZONE = "+08:00";
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_YYYYMMDD_LINE = "yyyy-MM-dd";
    public static final String PATTERN_YYYYMMDDhhmmss_LINE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 设置默认时区为亚洲上海
     */
//    public static final String DETAULR_TIME_ZONE = "Asia/Shanghai";

    /**
     * 根据指定的pattern格式化输出给定的时间
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String parse(Date date, String pattern) {
        if (date == null) return null;
        return getDateTime(date).toString(pattern);
    }

    /**
     * 使用默认的pattern格式化指定的时间
     *
     * @param date
     * @return
     */
    public static String parseDefault(Date date) {
        return getDateTime(date).toString(PATTERN_YYYYMMDD);
    }

    /**
     * 使用默认的pattern格式化指定的时间
     *
     * @param date
     * @return
     */
    public static String parseDateLine(Date date) {
        return getDateTime(date).toString(PATTERN_YYYYMMDD_LINE);
    }


    /**
     * 使用当前时间并使用指定的pattern格式化数据
     *
     * @return
     */
    public static String parseNowWithDefault() {
        return getDateTime().toString(PATTERN_YYYYMMDD);
    }

    /**
     * 根据指定的pattern格式化输出给定的时间
     *
     * @param pattern
     * @param pattern
     * @return
     */
    public static String parseNowWithPattern(String pattern) {
        return getDateTime().toString(pattern);
    }

    /**
     * 获取时间操作句柄
     *
     * @return
     */
    public static DateTime getDateTime() {
        return new DateTime(DateTimeZone.forID(DETAULR_TIME_ZONE));
    }

    /**
     * 根据给定的时间 获取时间操作句柄
     *
     * @return
     */
    public static DateTime getDateTime(Date date) {
        return new DateTime(date, DateTimeZone.forID(DETAULR_TIME_ZONE));
    }

    /**
     * 根据给定的时间字符串 获取时间操作句柄
     *
     * @return
     */
    public static DateTime getDateTime(String dateString) {
        return new DateTime(dateString, DateTimeZone.forID(DETAULR_TIME_ZONE));
    }

    /**
     * 功能描述: 格式化字符串时间
     *
     * @param: [dateString, pattern]
     * @return: org.joda.time.DateTime
     * @auther: pengw
     * @date: 2018/12/8 17:23
     */
    public static DateTime getDateTime(String dateString, String pattern) {
        if (Strings.isNullOrEmpty(pattern)) {
            pattern = PATTERN_YYYYMMDD_LINE;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.forID(DETAULR_TIME_ZONE));
        return dateTimeFormatter.parseDateTime(dateString);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNow() {
        return getDateTime().toDate();
    }

    /**
     * 格式化当前时间
     *
     * @param pattern
     * @return
     */
    public static DateTime getNowWithPattern(String pattern) {
        String dateStr = getDateTime().toString(pattern);
        return getDateTime(dateStr);
    }

    /**
     * 将指定的时间格式化后返回
     *
     * @param date
     * @param pattern
     * @return
     */
    public static DateTime getDate(Date date, String pattern) {
        String dateStr = getDateTime(date).toString(pattern);
        return getDateTime(dateStr);
    }

    /**
     * 在当前时间向前或者向后推移offset月
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date offsetDateByMoney(Date date, int offset) {
        return getDateTime(date).plusMonths(offset).toDate();
    }

    /**
     * 在当前时间向前或者向后推移offset天
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date offsetDateByDay(Date date, int offset) {
        return getDateTime(date).plusDays(offset).toDate();
    }

    /**
     * 在当前时间向前或者向后推移offset分钟
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date offsetDateByMillis(Date date, int offset) {
        return getDateTime(date).plusMillis(offset).toDate();
    }

    /**
     * 获取两个时间之间有多少天，决对天数
     *
     * @param start
     * @param end
     * @return
     */
    public static int getStepBetweenDays(Date start, Date end) {
        start = getDate(start, PATTERN_YYYYMMDD_LINE).toDate();
        end = getDate(end, PATTERN_YYYYMMDD_LINE).toDate();
        Period duration = new Period(getDateTime(start), getDateTime(end), PeriodType.days());
        return Math.abs(duration.getDays());
    }

    /**
     * 获取两个时间相差多少秒
     *
     * @param start
     * @param end
     * @return
     */
    public static int getStepBetweenSeconds(Date start, Date end) {
        Period duration = new Period(getDateTime(start), getDateTime(end), PeriodType.days());
        return Math.abs(duration.getSeconds());
    }

    /**
     * 返回一个时间区间，开始时间为startTime结束时间为endTime,offset为时间跨度，
     * 如果传入起始时间为null，则默认为当前时间为起始时间
     *
     * @param startTime
     * @param offset
     * @return
     */
    public static Map<String, Object> rangeTime(Date startTime, int offset) {
        Map<String, Object> range = Maps.newHashMap();
        if (startTime == null) {
            startTime = getNow();
        }
        if (offset >= 0) {
            range.put("startTime", startTime);
            range.put("endTime", offsetDateByDay(startTime, offset));
        } else {
            range.put("startTime", offsetDateByDay(startTime, offset));
            range.put("endTime", startTime);
        }

        return range;
    }


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
/***********************************************************************************************************/

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
        DateFormat formatter = new SimpleDateFormat(PATTERN_YYYYMMDD_LINE);
        String shortDate = formatter.format(value);
        return shortDate;
    }

    /**
     * 时间格式化,返回字符串（yyyyMMdd）
     * @param value
     * @return
     */
    public static String getYyyymmdd(Date value){
        DateFormat formatter = new SimpleDateFormat(PATTERN_YYYYMMDD);
        String shortDate = formatter.format(value);
        return shortDate;
    }

    /**
     * 时间格式化，返回日期类型（yyyy-MM-dd）
     * @param value
     * @return
     */
    public static Date stringToShortDate(String value){
        DateFormat formatter = new SimpleDateFormat(PATTERN_YYYYMMDD_LINE);
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
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDD_LINE);
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

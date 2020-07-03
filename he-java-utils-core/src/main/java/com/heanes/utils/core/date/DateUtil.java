package com.heanes.utils.core.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 时间相关工具类
 *
 * @author Heanes
 * @time 2019-11-19 16:21:09 周二
 */
public class DateUtil {

    public static final String YMD = "yyyy-MM-dd";
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_HMS_MS = "yyyy-MM-dd HH:mm:ss SSS";

    /**
     * 获取当前时间的时间戳
     *
     * @return int值
     * @author Heanes
     * @time 2019-11-19 16:22:32 周二
     */
    public static int getCurrentTimeIntValue() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当前日期的凌晨时间的描述时间戳
     *
     * @return 秒数时间戳
     * @author Heanes
     * @time 2019-11-19 19:23:42 周二
     */
    public static int getMorningTimestamp() {
        return DateUtil.getMorningTimestamp(null);
    }

    /**
     * 获取日期的凌晨时间的描述时间戳
     *
     * @param localDate 日期对象
     * @return 秒数时间戳
     * @author Heanes
     * @time 2019-11-19 19:23:42 周二
     */
    public static int getMorningTimestamp(LocalDate localDate) {
        if (localDate == null) {
            localDate = LocalDate.now();
        }
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0);

        // 一行代码写法
        return (int) LocalDate.now()
                .atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();

        // return (int) localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 根据时间戳获取格式化日期时间字符
     *
     * @param timestamp 时间戳
     * @param formatStr 格式化风格字符串
     * @return 格式化后的时间字符串
     */
    public static String getFormatByTimestamp(Integer timestamp, String formatStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatStr);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());

        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 根据时间戳获取格式化日期时间字符
     *
     * @param millSeconds 时间戳
     * @param formatStr 格式化风格字符串
     * @return 格式化后的时间字符串
     */
    public static String getFormatByMillSeconds(Long millSeconds, String formatStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatStr);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(millSeconds), ZoneId.systemDefault());

        return dateTimeFormatter.format(localDateTime);
    }

    public static void main(String[] args) {
        int currentTimeIntValue = DateUtil.getCurrentTimeIntValue();
        System.out.println(currentTimeIntValue);
        System.out.println(DateUtil.getMorningTimestamp());

        System.out.println(DateUtil.getFormatByTimestamp(currentTimeIntValue, DateUtil.YMD));
        System.out.println(DateUtil.getFormatByTimestamp(currentTimeIntValue, DateUtil.YMD_HMS));
        System.out.println(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
    }
}

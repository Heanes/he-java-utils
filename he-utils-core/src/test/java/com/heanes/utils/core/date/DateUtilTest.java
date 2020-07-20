package com.heanes.utils.core.date;

import org.junit.jupiter.api.Test;

/**
 * 日期工具类测试
 *
 * @author Heanes
 * @time 2019-12-29 15:51:59 周日
 */
public class DateUtilTest {

    /**
     * 测试根据毫秒数获取格式化日期
     * @author Heanes
     * @time 2019-12-29 15:55:45 周日
     */
    @Test
    public void testGetFormatByMillSeconds(){
        long currentMillSeconds = System.currentTimeMillis();
        System.out.println(DateUtil.getFormatByMillSeconds(currentMillSeconds, DateUtil.YMD_HMS));
        System.out.println(DateUtil.getFormatByMillSeconds(currentMillSeconds, DateUtil.YMD_HMS_MS));
    }
}

package com.heanes.utils.java.core.validate;

import com.heanes.utils.java.core.date.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * DateUtil 测试类
 *
 * @author Heanes
 * @time 2019-12-23 15:13:19 周一
 */
public class DateUtilTest {

    @Test
    public void testGetCurrentTimeIntValue(){
        int currentTimeIntValue = DateUtil.getCurrentTimeIntValue();
        System.out.println("currentTimeIntValue: " + currentTimeIntValue);
    }
}

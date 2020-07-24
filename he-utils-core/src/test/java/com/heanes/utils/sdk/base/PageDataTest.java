package com.heanes.utils.sdk.base;

import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * 分页数据测试类
 *
 * @author Heanes
 * @time 2020-07-21 09:11:14 周二
 */
public class PageDataTest {

    @Data
    private class TestA{
        private String startTime;
    }

    @Test
    public void PageDataGetTest(){
        PageData<TestA> pageData = new PageData<>();
    }
}

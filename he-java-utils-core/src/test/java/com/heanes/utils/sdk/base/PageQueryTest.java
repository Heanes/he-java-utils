package com.heanes.utils.sdk.base;

import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * 分页查询类测试
 *
 * @author Heanes
 * @time 2020-07-06 10:44:24 周一
 */
public class PageQueryTest {

    @Data
    private class TestA{
        private String startTime;
    }

    @Test
    public void PageGetTest(){
        PageQuery<TestA> pageQuery = new PageQuery<>();
        TestA testA = new TestA();
        testA.setStartTime("2020-07-06 10:47:41");
        pageQuery.setSearchPo(testA);
        TestA searchPo = pageQuery.getSearchPo();
        System.out.println(pageQuery);
        System.out.println(searchPo);
    }
}

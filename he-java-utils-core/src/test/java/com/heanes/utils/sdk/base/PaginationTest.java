package com.heanes.utils.sdk.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

/**
 * 分页参数测试
 *
 * @author Heanes
 * @time 2020-07-06 10:56:37 周一
 */
public class PaginationTest {

    @EqualsAndHashCode(callSuper = true)
    @Data
    private class TestAQuery extends Pagination{
        private String startTime;
    }

    @Test
    public void PaginationUseTest() {
        TestAQuery testAQuery = new TestAQuery();
        testAQuery.setStartTime("2020-07-06 10:59:52 ");
        testAQuery.setPageNumber(1);
        testAQuery.setPageSize(20);
    }
}

package com.heanes.utils.sdk.base;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 公共查询请求参数
 * @author Heanes
 * @time 2019-11-13 16:10:05 周三
 */
@Data
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = -4008629857822640094L;

    private Pagination pagination;

    /**
     * 要查询的字段列表，只查需要的字段，可以提高MySQL性能
     */
    private List<String> selectFieldList;

    /**
     * 排序方式，key为字段，值为排序方式[asc|desc]，如 "id": "desc"
     */
    private LinkedHashMap<String, String> sortFieldMap;

    /**
     * 查询条件，key为字段，value为参数值
     */
    private LinkedHashMap<String, List<Object>> columnValueMap;

}

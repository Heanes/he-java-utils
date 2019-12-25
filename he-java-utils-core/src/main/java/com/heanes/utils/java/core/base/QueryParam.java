package com.heanes.utils.java.core.base;

import lombok.Data;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * 公共查询请求参数
 * @author Heanes
 * @time 2019-11-13 16:10:05 周三
 */
@Data
public class QueryParam implements Serializable {
    private static final long serialVersionUID = -4008629857822640094L;

    /**
     * 页码
     */
    private int pageNumber;

    /**
     * 分页大小
     */
    private int pageSize;

    /**
     * 分页起始值
     */
    private int limitStart;

    /**
     * 记录起始
     */
    private int startRecord;

    /**
     * 排序方式，key为字段，值为排序方式[asc|desc]，如 "id": "desc"
     */
    private TreeMap<String, String> sortFieldMap;

    public void setStartRecord(int startRecord) {
        this.startRecord = startRecord;
    }

    /**
     * 设置分页起始值，手动设置
     */
    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }

    /**
     * 设置分页起始值，自动设置
     */
    public void setLimitStart() {
        this.limitStart = this.pageSize * (this.pageNumber - 1);
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        this.setLimitStart();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.setLimitStart();
    }
}

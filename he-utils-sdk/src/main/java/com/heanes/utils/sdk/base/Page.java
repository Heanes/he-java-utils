package com.heanes.utils.sdk.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据分页类。查询参数类继承此类，来组成分页查询参数
 *
 * @author Heanes
 * @time 2020-01-03 19:21:07 周五
 */
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = -5806596257379103172L;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 页码
     */
    private int pageNumber;

    /**
     * 分页大小
     */
    private int pageSize;

    /**
     * 分页起始值，用于分页limit
     */
    private int limitStart;

    /**
     * 记录起始值，用于分页时，数据变化较频繁时，切换分页查到的数据不连贯或者重复问题，带入到where条件
     */
    private int startRecord;

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        this.setLimitStart();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.setLimitStart();
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
}

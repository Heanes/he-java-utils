package com.heanes.utils.java.core.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据对象
 * @author Heanes
 * @time 2019-11-13 15:33:03 周三
 */
@Data
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 909989756440820203L;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据项列表
     */
    private List<T> items;

    public PageData() {
    }

    public PageData(Integer pageNumber, Integer pageSize, Long total, List<T> items) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.items = items;
    }

    public PageData(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}

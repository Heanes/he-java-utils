package com.heanes.utils.sdk.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
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
     * 数据项列表，可考虑的名称叫records、rows、items
     */
    private List<T> records;

    public PageData() {
    }

    public PageData(Integer pageNumber, Integer pageSize, Long total, List<T> records) {
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.setTotal(total);
        this.records = records;
    }

    public PageData(Integer pageNumber, Integer pageSize) {
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.records = new ArrayList<>();
    }
}

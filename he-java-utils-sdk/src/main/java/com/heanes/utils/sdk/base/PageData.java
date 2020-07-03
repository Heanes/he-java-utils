package com.heanes.utils.sdk.base;

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
     * 分页信息
     */
    private Pagination page;

    /**
     * 数据项列表
     */
    private List<T> items;

    public PageData() {
    }

    public PageData(Integer pageNumber, Integer pageSize, Long total, List<T> items) {
        if(this.page == null){
            this.page = new Pagination();
        }
        this.page.setPageNumber(pageNumber);
        this.page.setPageSize(pageSize);
        this.page.setTotal(total);
        this.items = items;
    }

    public PageData(Integer pageNumber, Integer pageSize) {
        if(this.page == null){
            this.page = new Pagination();
        }
        this.page.setPageNumber(pageNumber);
        this.page.setPageSize(pageSize);
    }
}

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

    /**
     * 分页数据构造方法
     * @param pageNumber 页码值
     * @param pageSize 分页大小
     * @param total 总条数
     * @param records 数据列表
     * @author Heanes
     * @time 2020-07-30 19:12:08 周四
     */
    public PageData(Integer pageNumber, Integer pageSize, Long total, List<T> records) {
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.total = total;
        this.records = records;
    }

    /**
     * 空分页数据构造方法
     * @param pageNumber 页码值
     * @param pageSize 分页大小
     * @author Heanes
     * @time 2020-07-30 19:11:32 周四
     */
    public PageData(Integer pageNumber, Integer pageSize) {
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.total = 0L;
        this.records = new ArrayList<>();
    }

    /**
     * 空分页数据
     * @param pageNumber 页码值
     * @param pageSize 分页大小
     * @param <T> 返回对象泛型类
     * @return 分页数据
     * @author Heanes
     * @time 2020-07-30 19:11:00 周四
     */
    public static <T> PageData<T> emptyPage(Integer pageNumber, Integer pageSize){
        return new PageData<T>(pageNumber, pageNumber);
    }

}

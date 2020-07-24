package com.heanes.utils.sdk.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询。分页类为主类，嵌入查询参数类，来组成分页查询参数
 *
 * @author Heanes
 * @time 2020-07-06 10:42:55 周一
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageQuery<T> extends BaseQuery {

    private static final long serialVersionUID = -5674756365396504516L;

    /**
     * 查询参数类
     * @time 2020-07-06 10:50:26 周一
     */
    private T searchParam;
}

package com.heanes.utils.java.scaffolding.base.manager;

import java.util.List;

/**
 * 基础事务处理层公共方法
 *
 * @param <T>
 * @param <Q>
 * @author Heanes
 * @time 2019-12-22 18:42:18 周日
 */
public interface BaseManager<T, Q> {

    /**
     * 新增数据
     * @param t 要增加的对象
     * @return T 插入后的对象
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    T insert(T t);

    /**
     * 插入新纪录，部分字段可为空
     * @param t 要增加的对象
     * @return 插入影响条数，1-成功插入一条，0-未能成功插入
     * @author Heanes
     * @time 2019-12-20 19:36:06 周五
     */
    T insertSelective(T t);

    /**
     * 批量增加
     * @param list 要增加的对象集合
     * @return 成功增加的行数
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    long batchInsert(List<T> list);

    /**
     * 批量增加，返回插入后的对象
     * @param list 要增加的对象集合
     * @return 成功增加的行数
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    List<T> batchInsertList(List<T> list);

    /**
     * 更新
     * @param t 要更新的对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    long update(T t);

    /**
     * 根据主键更新
     * @param t 主键参数对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    int updateByPrimaryKey(T t);

    /**
     * 根据主键选择性更新
     * @param t 主键参数对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * 批量更新
     * @param list 要新的对象集合
     * @return 更新的影响条数，>=1 更新成功，=0 更新失败
     * @author Heanes
     * @time 2019-12-20 18:44:56 周五
     */
    long batchUpdate(List<T> list);

    /**
     * 按主键查询
     * @param primaryKey 主键
     * @return 查得记录对象|null
     * @author Heanes
     * @time 2019-12-20 18:36:52 周五
     */
    T selectByPrimaryKey(long primaryKey);

    /**
     * 按表指定字段列及值列表查询集合
     * @param q 参数内必需字段：columnName(数据库表的列名);list(要查询的数据数组 )
     * @return 查得结果list
     * @author Heanes
     * @time 2019-12-20 18:46:50 周五
     */
    List<T> selectByColumn(Q q);

    /**
     * 按条件统计查询条数
     * @param q 查询参数
     * @return 结果总条数
     * @author Heanes
     * @time 2019-12-20 18:41:01 周五
     */
    long count(Q q);

    /**
     * 查询集合
     * @param q 查询时的过虑条件
     * @return 查询结果集合
     * @author Heanes
     * @time 2019-12-20 19:21:37 周五
     */
    List<T> queryList(Q q);

    /**
     * 删除
     * @param t 要删除的对象
     * @return 删除影响条数，>=1-成功删除，0-未能成功删除
     * @author Heanes
     * @time 2019-12-20 18:29:00 周五
     */
    long delete(T t);

    /**
     * 批量删除
     * @param q 参数内必需：要删除的对象主键的集合
     * @return 删除影响条数 >= 1 删除成功，= 0 删除失败
     * @author Heanes
     * @time 2019-12-20 18:47:26 周五
     */
    long batchDelete(Q q);

    /**
     * 同步数据，有则更新，无则插入
     * @param dataList 要同步的数据列表
     * @return long 影响行数
     * @author Heanes
     * @time 2019-12-23 09:57:40 周一
     */
    long sync(List<T> dataList);
}

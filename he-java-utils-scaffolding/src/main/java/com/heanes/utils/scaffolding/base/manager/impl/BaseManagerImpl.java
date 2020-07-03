package com.heanes.utils.scaffolding.base.manager.impl;

import com.heanes.utils.scaffolding.base.manager.BaseManager;
import com.heanes.utils.scaffolding.base.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础事务处理层公共方法
 *
 * @param <T>
 * @param <Q>
 * @author Heanes
 * @time 2019-12-22 18:42:18 周日
 */
@Component
public abstract class BaseManagerImpl<T, Q> implements BaseManager<T, Q> {

    /**
     * 得到mapper
     * @return BaseMapper
     */
    public abstract BaseMapper<T, Q> getMapper();

    /**
     * 新增数据
     * @param t 要增加的对象
     * @return T 插入后的对象
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public T insert(T t) {
        int row = this.getMapper().insert(t);
        return row > 0 ? t : null;
    }

    /**
     * 新增数据
     * @param t 要增加的对象
     * @return T 插入后的对象
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public T insertSelective(T t) {
        int row = this.getMapper().insertSelective(t);
        return row > 0 ? t : null;
    }

    /**
     * 批量增加
     * @param list 要增加的对象集合
     * @return 成功增加的行数
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public long batchInsert(List<T> list) {
        return this.getMapper().batchInsert(list);
    }

    /**
     * 批量增加，返回插入后的对象
     * @param list 要增加的对象集合
     * @return 成功增加的行数
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public List<T> batchInsertList(List<T> list){
        return this.getMapper().batchInsertList(list);
    }

    /**
     * 更新
     * @param t 要更新的对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public long update(T t) {
        return this.getMapper().update(t);
    }

    /**
     * 根据主键更新
     * @param t 主键参数对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateByPrimaryKey(T t) {
        return this.getMapper().updateByPrimaryKey(t);
    }

    /**
     * 根据主键选择性更新
     * @param t 主键参数对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateByPrimaryKeySelective(T t){
        return this.getMapper().updateByPrimaryKeySelective(t);
    }

    /**
     * 批量更新
     * @param list 要新的对象集合
     * @return 更新的影响条数，>=1 更新成功，=0 更新失败
     * @author Heanes
     * @time 2019-12-20 18:44:56 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public long batchUpdate(List<T> list) {
        int op = 0;
        for (T t : list) {
            op += this.getMapper().update(t);
        }
        return op;
    }

    /**
     * 按主键查询
     * @param primaryKey 主键
     * @return 查得记录对象|null
     * @author Heanes
     * @time 2019-12-20 18:36:52 周五
     */
    @Override
    public T selectByPrimaryKey(long primaryKey) {
        return this.getMapper().selectByPrimaryKey(primaryKey);
    }

    /**
     * 按表指定字段列及值列表查询集合
     * @param q 参数内必需字段：columnName(数据库表的列名);list(要查询的数据数组 )
     * @return 查得结果list
     * @author Heanes
     * @time 2019-12-20 18:46:50 周五
     */
    @Override
    public List<T> selectByColumn(Q q) {
        return this.getMapper().selectByColumn(q);
    }

    /**
     * 按表指定字段列及值列表查询出一个来
     * @param q 参数内必需字段：columnName(数据库表的列名);list(要查询的数据数组 )
     * @return 查得结果对象
     * @author Heanes
     * @time 2019-12-20 18:46:50 周五
     */
    @Override
    public T selectOne(Q q) {
        return this.getMapper().selectOne(q);
    }

    /**
     * 按条件统计查询条数
     * @param q 查询参数
     * @return 结果总条数
     * @author Heanes
     * @time 2019-12-20 18:41:01 周五
     */
    @Override
    public long count(Q q) {
        return this.getMapper().count(q);
    }

    /**
     * 查询集合
     * @param q 查询时的过虑条件
     * @return 查询结果集合
     * @author Heanes
     * @time 2019-12-20 19:21:37 周五
     */
    @Override
    public List<T> queryList(Q q) {
        return this.getMapper().queryList(q);
    }

    /**
     * 删除
     * @param t 要删除的对象
     * @return 删除影响条数，>=1-成功删除，0-未能成功删除
     * @author Heanes
     * @time 2019-12-20 18:29:00 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public long delete(T t) {
        return this.getMapper().delete(t);
    }

    /**
     * 批量删除
     * @param q 参数内必需：要删除的对象主键的集合
     * @return 删除影响条数 >= 1 删除成功，= 0 删除失败
     * @author Heanes
     * @time 2019-12-20 18:47:26 周五
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public long batchDelete(Q q) {
        return this.getMapper().batchDelete(q);
    }

    /**
     * 同步数据，有则更新，无则插入
     * @param dataList 要同步的数据列表
     * @return long 影响行数
     * @author Heanes
     * @time 2019-12-23 09:57:40 周一
     */
    @Override
    public long sync(List<T> dataList) {
        // 判断要同步的集合是否有数据
        if (dataList == null || dataList.size() == 0) {
            return 0;
        }
        // 定义null对象，方便使用
        T c;
        // 定义：收集要增加的数据
        List<T> insertList = new ArrayList<>();
        // 定义：收集要更新的数据
        List<T> updateList = new ArrayList<>();
        // 遍历要同步的数据
        for (T t : dataList) {
            // 查询T数据是否存在
            c = getMapper().selectBean(t);
            // 判断数据是要增加还是更新
            if (c == null) {
                insertList.add(t);
            } else {
                updateList.add(t);
            }
        }
        // 增加成功的数量
        long insertNum = 0;
        // 更新成功的数量
        long updateNum = 0;
        // 判断是否有要更新的数据
        if (insertList.size() > 0) {
            // 批量增加，获取增加行数
            insertNum = getMapper().batchInsert(insertList);
        }
        // 判断是否有要更新的数据
        if (updateList.size() > 0) {
            // 批量更新，获取更新行数
            updateNum = getMapper().batchUpdate(updateList);
        }
        // 返回操作数据数量
        // 相对于增加，会返回增加的行数。相对于更新，刚无论更新多少条数据皆返回1否刚0
        return (insertNum + updateNum);
    }
}

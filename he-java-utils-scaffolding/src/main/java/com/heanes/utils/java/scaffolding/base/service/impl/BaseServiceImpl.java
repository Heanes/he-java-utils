package com.heanes.utils.java.scaffolding.base.service.impl;

import com.heanes.utils.java.core.base.Result;
import com.heanes.utils.java.scaffolding.base.manager.BaseManager;
import com.heanes.utils.java.scaffolding.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础服务接口
 * @param <T>
 * @param <Q>
 * @author Heanes
 * @time 2019-12-13 17:42:32 周五
 */
@Slf4j
@Service
public abstract class BaseServiceImpl<T, Q> implements BaseService<T, Q> {

    /**
     * 得到manager
     * @return BaseManager
     */
    public abstract BaseManager<T, Q> getManager();

    /**
     * 新增数据
     * @param t 要增加的对象
     * @return T 插入后的对象
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    @Override
    public Result<T> insert(T t) {
        try {
            return new Result<>(this.getManager().insert(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 插入新纪录，部分字段可为空
     * @param t 要增加的对象
     * @return 插入影响条数，1-成功插入一条，0-未能成功插入
     * @author Heanes
     * @time 2019-12-20 19:36:06 周五
     */
    @Override
    public Result<T> insertSelective(T t){
        try {
            return new Result<>(this.getManager().insertSelective(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 批量增加
     * @param list 要增加的对象集合
     * @return 成功增加的行数
     * @author Heanes
     * @time 2019-12-20 19:21:56 周五
     */
    @Override
    public Result<Long> batchInsert(List<T> list) {
        try {
            return new Result<>(this.getManager().batchInsert(list));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 更新
     * @param t 要更新的对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    @Override
    public Result<Long> update(T t) {
        try {
            return new Result<>(this.getManager().update(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 根据主键更新
     * @param t 主键参数对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    @Override
    public Result<Integer> updateByPrimaryKey(T t){
        try {
            return new Result<>(this.getManager().updateByPrimaryKey(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 根据主键选择性更新
     * @param t 主键参数对象
     * @return 更新影响条数，>=1-成功更新，0-未能成功更新
     * @author Heanes
     * @time 2019-12-20 18:30:11 周五
     */
    @Override
    public Result<Integer> updateByPrimaryKeySelective(T t){
        try {
            return new Result<>(this.getManager().updateByPrimaryKey(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 批量更新
     * @param list 要新的对象集合
     * @return 更新的影响条数，>=1 更新成功，=0 更新失败
     * @author Heanes
     * @time 2019-12-20 18:44:56 周五
     */
    @Override
    public Result<Long> batchUpdate(List<T> list) {
        try {
            return new Result<>(this.getManager().batchUpdate(list));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 按主键查询
     * @param primaryKey 主键
     * @return 查得记录对象|null
     * @author Heanes
     * @time 2019-12-20 18:36:52 周五
     */
    @Override
    public Result<T> selectByPrimaryKey(long primaryKey) {
        try {
            return new Result<>(this.getManager().selectByPrimaryKey(primaryKey));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 按表指定字段列及值列表查询集合
     * @param q 参数内必需字段：columnName(数据库表的列名);list(要查询的数据数组 )
     * @return 查得结果list
     * @author Heanes
     * @time 2019-12-20 18:46:50 周五
     */
    @Override
    public Result<List<T>> selectByColumn(Q q) {
        try {
            return new Result<>(this.getManager().selectByColumn(q));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 按条件统计查询条数
     * @param q 查询参数
     * @return 结果总条数
     * @author Heanes
     * @time 2019-12-20 18:41:01 周五
     */
    @Override
    public Result<Long> count(Q q) {
        try {
            return new Result<>(this.getManager().count(q));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 查询集合
     * @param q 查询时的过虑条件
     * @return 查询结果集合
     * @author Heanes
     * @time 2019-12-20 19:21:37 周五
     */
    @Override
    public Result<List<T>> queryList(Q q) {
        try {
            return new Result<>(this.getManager().queryList(q));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 删除
     * @param t 要删除的对象
     * @return 删除影响条数，>=1-成功删除，0-未能成功删除
     * @author Heanes
     * @time 2019-12-20 18:29:00 周五
     */
    @Override
    public Result<Long> delete(T t) {
        try {
            return new Result<>(this.getManager().delete(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 批量删除
     * @param q 参数内必需：要删除的对象主键的集合
     * @return 删除影响条数 >= 1 删除成功，= 0 删除失败
     * @author Heanes
     * @time 2019-12-20 18:47:26 周五
     */
    @Override
    public Result<Long> batchDelete(Q q) {
        try {
            return new Result<>(this.getManager().batchDelete(q));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 同步数据，有则更新，无则插入
     * @param dataList 要同步的数据列表
     * @return long 影响行数
     * @author Heanes
     * @time 2019-12-23 09:57:40 周一
     */
    @Override
    public Result<Long> sync(List<T> dataList) {
        try {
            Long data = this.getManager().sync(dataList);
            return new Result<>(data);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result<>(Result.ReturnCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
        }
    }

}

package com.heanes.utils.sdk.base;

import com.heanes.utils.sdk.constants.ReturnCodeConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * 公共接口返回封装
 *
 * @author Heanes
 * @time 2019-11-13 15:29:30 周三
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -5851805740711267609L;

    /**
     * 泛型数据
     */
    private T data;

    /**
     * 返回码
     */
    private int code = ReturnCodeConstant.SUCCESS;

    /**
     * 消息
     */
    private String message = "";

    /**
     * 响应时间毫秒级时间戳
     */
    private Long responseTimeMillSeconds;

    /**
     * 响应时间格式化字符串
     */
    private String responseTimeFormative;

    /**
     * 无参构造方法
     */
    public Result() {
        super();
    }

    /**
     * 构造方法
     * @param data 数据
     * @param code 返回码
     * @param message 消息
     */
    public Result(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * 构造方法
     * @param data 数据
     */
    public Result(T data) {
        this.data = data;
    }

    /**
     * 构造方法
     * @param code 返回码
     * @param message 消息
     */
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回成功结果，静态方法
     *
     * @param <T>  返回结果泛型
     * @return Result对象
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setMessage("ok");
        return result;
    }

    /**
     * 返回成功结果，静态方法
     *
     * @param data 数据
     * @param <T>  返回结果泛型
     * @return Result对象
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setMessage("ok");
        return result;
    }

    /**
     * 返回成功结果，静态方法
     *
     * @param data    数据
     * @param message 消息
     * @param <T>     返回结果泛型
     * @return Result对象
     */
    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    /**
     * 返回成功结果，静态方法
     *
     * @param message 消息
     * @param <T>     返回结果泛型
     * @return Result对象
     */
    public static <T> Result<T> success(String message) {
        Result<T> result = new Result<>();
        result.setMessage(message);
        return result;
    }

    /**
     * 返回成功结果，静态方法
     *
     * @param code    返回码
     * @param message 消息
     * @param <T>     返回结果泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message);
    }

    /**
     * 返回成功结果，静态方法
     *
     * @param message 消息
     * @param <T>     返回结果泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(ReturnCodeConstant.FAIL, message);
    }

    /**
     * 置为成功
     */
    public Result<T> toSuccess(){
        this.code = ReturnCodeConstant.SUCCESS;
        this.message = "ok";
        return this;
    }

    /**
     * 置为成功
     */
    public Result<T> toSuccess(String message){
        this.code = ReturnCodeConstant.SUCCESS;
        this.message = message;
        return this;
    }

    /**
     * 置为失败
     */
    public Result<T> toFail(){
        this.code = ReturnCodeConstant.FAIL;
        this.message = "fail";
        return this;
    }

    /**
     * 置为失败
     */
    public Result<T> toFail(String message){
        this.code = ReturnCodeConstant.FAIL;
        this.message = message;
        return this;
    }

    /**
     * 是否成功
     * @return boolean 成功标志
     */
    private boolean isSuccess(){
        return this.code == ReturnCodeConstant.SUCCESS;
    }

    /**
     * 是否失败
     * @return boolean 失败标志
     */
    private boolean isFail(){
        return !this.isSuccess();
    }

    /**
     * 是否空数据
     * @return boolean 空数据标志，true：空，false：不为空
     */
    private boolean isEmptyData(){
        if(this.data == null){
            return true;
        }
        if(this.data instanceof Collections){
            return ((Collection<?>) this.data).size() == 0;
        }
        if(this.data instanceof Map){
            return ((Map<?, ?>) this.data).size() == 0;
        }
        return false;
    }

}

package com.heanes.utils.java.core.base;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
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

    private T data;

    private int code = ReturnCodeEnum.SUCCESS.getCode();

    private String message = "";

    public Result() {
        super();
    }

    public Result(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
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
        return new Result<>(ReturnCodeEnum.FAIL.getCode(), message);
    }

    /**
     * 返回码常量
     * @author Heanes
     * @time 2019-11-20 19:23:13 周三
     */
    public static class ReturnCodeConstant {
        public static final int SUCCESS = 0;
        public static final int FAIL = -1;

        public static final int NULL_ARGUMENT = 1001;
        public static final int ILLEGAL_ARGUMENT = 1002;
        public static final int STATUS_INVALID = 0;
        public static final int MISMATCH_CONDITION = 0;

        public static final int BUSINESS_EXCEPTION = 0;
        public static final int CONCURRENT_CONFLICT = 0;

        public static final int CALL_ERROR = 0;
        public static final int CALL_TIMEOUT = 0;
        public static final int CALL_REMOTE_ERROR = 0;
        public static final int CALL_REMOTE_TIMEOUT = 0;
        public static final int RESOURCE_NOT_EXIST = 0;
        public static final int RESOURCE_EXIST = 0;

        public static final int NOT_LOGIN = 0;
        public static final int NO_PERMISSION = 0;
        public static final int FORBIDDEN = 0;
        public static final int NOT_FOUND = 0;
        public static final int NOT_FOUND_ALL = 0;

        public static final int SYSTEM_EXCEPTION = 0;
        public static final int CAST_EXCEPTION = 0;
        public static final int PARSE_EXCEPTION = 0;

        public static final int IO_EXCEPTION = 0;
    }

    /**
     * 返回码枚举类
     *
     * @author Heanes
     * @time 2019-11-20 19:11:38 周三
     */
    public enum ReturnCodeEnum {
        /**
         * 成功
         */
        SUCCESS(0, "成功"),
        /**
         * 失败
         */
        FAIL(-1, "失败"),

        NULL_ARGUMENT(1001, "参数为空"),
        ILLEGAL_ARGUMENT(1002, "参数错误"),
        STATUS_INVALID(1003, "数据状态不对"),
        MISMATCH_CONDITION(1004, "参数不符合条件"),

        BUSINESS_EXCEPTION(1201, "业务处理异常"),
        CONCURRENT_CONFLICT(1202, "业务并发冲突"),

        CALL_ERROR(1301, "调用异常"),
        CALL_TIMEOUT(1302, "调用超时"),
        CALL_REMOTE_ERROR(1303, "调用外部服务异常"),
        CALL_REMOTE_TIMEOUT(1304, "调用外部服务超时"),
        RESOURCE_NOT_EXIST(1305, "资源不存在"),
        RESOURCE_EXIST(1306, "资源存在"),

        NOT_LOGIN(1401, "未登录"),
        NO_PERMISSION(1402, "无权限访问"),
        FORBIDDEN(1403, "禁止访问"),
        NOT_FOUND(1404, "未找到资源"),
        NOT_FOUND_ALL(1405, "未找到全部资源"),

        SYSTEM_EXCEPTION(1501, "系统异常"),
        CAST_EXCEPTION(1502, "转换异常"),
        PARSE_EXCEPTION(1503, "解析异常"),

        IO_EXCEPTION(1901, "IO错误");

        private int code;
        private String msg;

        private static Map<Integer, ReturnCodeEnum> codeEnumMap;
        private static Map<String, Integer> nameCodeMap;
        private static Map<Integer, String> codeMsgMap;
        private static Map<Integer, String> codeNameMap;
        private static Map<String, String> nameMsgMap;

        private ReturnCodeEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        public static Map<String, Integer> getNameCodeMap() {
            return nameCodeMap;
        }

        public static Map<Integer, String> getCodeMsgMap() {
            return codeMsgMap;
        }

        public static Map<Integer, String> getCodeNameMap() {
            return codeNameMap;
        }

        public static Map<String, String> getNameMsgMap() {
            return nameMsgMap;
        }

        public static Map<Integer, ReturnCodeEnum> getCodeEnumMap() {
            return codeEnumMap;
        }

        static {
            codeMsgMap = new HashMap<>();
            codeNameMap = new HashMap<>();
            nameCodeMap = new HashMap<>();
            nameMsgMap = new HashMap<>();
            codeEnumMap = new HashMap<>();

            ReturnCodeEnum[] codeList = ReturnCodeEnum.values();
            for (ReturnCodeEnum codeEnum : codeList) {
                codeMsgMap.put(codeEnum.getCode(), codeEnum.getMsg());
                codeNameMap.put(codeEnum.getCode(), codeEnum.toString());
                nameCodeMap.put(codeEnum.toString(), codeEnum.getCode());
                nameMsgMap.put(codeEnum.toString(), codeEnum.getMsg());
                codeEnumMap.put(codeEnum.getCode(), codeEnum);
            }

        }

        public static void main(String[] args) {
            ReturnCodeEnum byCode = ReturnCodeEnum.getByCode((short) 1002);
            ReturnCodeEnum byName = ReturnCodeEnum.getByMsg("资源存在");
            System.out.println(byCode);
            System.out.println(byName);
            System.out.println(ReturnCodeEnum.getCodeMsgMap());
            System.out.println(ReturnCodeEnum.getCodeNameMap());
            System.out.println(ReturnCodeEnum.getNameCodeMap());
            System.out.println(ReturnCodeEnum.getNameMsgMap());
            System.out.println(ReturnCodeEnum.getCodeEnumMap());
            System.out.println(ReturnCodeEnum.SYSTEM_EXCEPTION);
            System.out.println(ReturnCodeEnum.SYSTEM_EXCEPTION.getCode());
            System.out.println(ReturnCodeEnum.SYSTEM_EXCEPTION.getMsg());
        }

        public static ReturnCodeEnum getByCode(int code) {
            ReturnCodeEnum[] codeEnums = ReturnCodeEnum.values();
            for (ReturnCodeEnum codeEnum : codeEnums) {
                if (codeEnum.getCode() == code) {
                    return codeEnum;
                }
            }
            return null;
        }

        public static ReturnCodeEnum getByMsg(String msg) {
            ReturnCodeEnum[] codeEnums = ReturnCodeEnum.values();
            for (ReturnCodeEnum codeEnum : codeEnums) {
                if (codeEnum.getMsg().equals(msg)) {
                    return codeEnum;
                }
            }
            return null;
        }
    }
}

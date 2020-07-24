package com.heanes.utils.sdk.enums;

import com.heanes.utils.sdk.constants.ReturnCodeConstant;

import java.util.HashMap;
import java.util.Map;

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
    SUCCESS(ReturnCodeConstant.SUCCESS, "成功"),
    /**
     * 失败
     */
    FAIL(ReturnCodeConstant.FAIL, "失败"),

    NULL_ARGUMENT(ReturnCodeConstant.NULL_ARGUMENT, "参数为空"),
    ILLEGAL_ARGUMENT(ReturnCodeConstant.ILLEGAL_ARGUMENT, "参数错误"),
    STATUS_INVALID(ReturnCodeConstant.STATUS_INVALID, "数据状态不对"),
    MISMATCH_CONDITION(ReturnCodeConstant.MISMATCH_CONDITION, "参数不符合条件"),

    BUSINESS_EXCEPTION(ReturnCodeConstant.BUSINESS_EXCEPTION, "业务处理异常"),
    CONCURRENT_CONFLICT(ReturnCodeConstant.CONCURRENT_CONFLICT, "业务并发冲突"),

    CALL_ERROR(ReturnCodeConstant.CALL_ERROR, "调用异常"),
    CALL_TIMEOUT(ReturnCodeConstant.CALL_TIMEOUT, "调用超时"),
    CALL_REMOTE_ERROR(ReturnCodeConstant.CALL_REMOTE_ERROR, "调用外部服务异常"),
    CALL_REMOTE_TIMEOUT(ReturnCodeConstant.CALL_REMOTE_TIMEOUT, "调用外部服务超时"),
    RESOURCE_NOT_EXIST(ReturnCodeConstant.RESOURCE_NOT_EXIST, "资源不存在"),
    RESOURCE_EXIST(ReturnCodeConstant.RESOURCE_EXIST, "资源存在"),

    NOT_LOGIN(ReturnCodeConstant.NOT_LOGIN, "未登录"),
    NO_PERMISSION(ReturnCodeConstant.NO_PERMISSION, "无权限访问"),
    FORBIDDEN(ReturnCodeConstant.FORBIDDEN, "禁止访问"),
    NOT_FOUND(ReturnCodeConstant.NOT_FOUND, "未找到资源"),
    NOT_FOUND_ALL(ReturnCodeConstant.NOT_FOUND_ALL, "未找到全部资源"),

    SYSTEM_EXCEPTION(ReturnCodeConstant.SYSTEM_EXCEPTION, "系统异常"),
    CAST_EXCEPTION(ReturnCodeConstant.CAST_EXCEPTION, "转换异常"),
    PARSE_EXCEPTION(ReturnCodeConstant.PARSE_EXCEPTION, "解析异常"),

    IO_EXCEPTION(ReturnCodeConstant.IO_EXCEPTION, "IO错误");

    private final int code;
    private final String msg;

    private static final Map<Integer, ReturnCodeEnum> codeEnumMap;
    private static final Map<String, Integer> nameCodeMap;
    private static final Map<Integer, String> codeMsgMap;
    private static final Map<Integer, String> codeNameMap;
    private static final Map<String, String> nameMsgMap;

    ReturnCodeEnum(Integer code, String msg) {
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

    public static ReturnCodeEnum getByCode(int code) {
        ReturnCodeEnum[] codeEnums = ReturnCodeEnum.values();
        for (ReturnCodeEnum codeEnum : codeEnums) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
        }
        return null;
    }

}

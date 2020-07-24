package com.heanes.utils.sdk.base;

import com.heanes.utils.sdk.enums.ReturnCodeEnum;
import org.junit.Test;

/**
 * 结果返回码测试类
 *
 * @author Heanes
 * @time 2020-07-22 20:11:03 周三
 */
public class ReturnCodeEnumTest {

    @Test
    public void testResult() {
        ReturnCodeEnum byCode = ReturnCodeEnum.getByCode((short) 1002);
        System.out.println(byCode);
        System.out.println(ReturnCodeEnum.getCodeMsgMap());
        System.out.println(ReturnCodeEnum.getCodeNameMap());
        System.out.println(ReturnCodeEnum.getNameCodeMap());
        System.out.println(ReturnCodeEnum.getNameMsgMap());
        System.out.println(ReturnCodeEnum.getCodeEnumMap());
        System.out.println(ReturnCodeEnum.SYSTEM_EXCEPTION);
        System.out.println(ReturnCodeEnum.SYSTEM_EXCEPTION.getCode());
        System.out.println(ReturnCodeEnum.SYSTEM_EXCEPTION.getMsg());
    }
}

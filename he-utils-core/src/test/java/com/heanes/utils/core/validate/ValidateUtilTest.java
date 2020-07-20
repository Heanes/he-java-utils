package com.heanes.utils.core.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 验证工具类测试
 *
 * @author Heanes
 * @time 2019-12-23 11:45:31 周一
 */
public class ValidateUtilTest {

    @Test
    public void isNullTest() {
        String a = "null";
        Assertions.assertFalse(ValidateUtil.isNull(a), "is not a null object");
    }
    @Test
    public void isNotNullTest() {
        String a = "null";
        Assertions.assertTrue(ValidateUtil.isNotNull(a), "is not a null object");
    }

    @Test
    public void isAllNullTest() {
        String a = null;
        Assertions.assertTrue(ValidateUtil.isAllNull(null, a), "all null object");
        Assertions.assertFalse(ValidateUtil.isAllNull(null, "aaa"), "not all null object");
    }

    @Test
    public void isEmptyObjectTest(){
        Object obj1 = null;
        Object obj2 = new Object();
        Object obj3 = new String("obj3");
        Object obj4 = new String("");
        Assertions.assertTrue(ValidateUtil.isEmpty(obj1));
        Assertions.assertFalse(ValidateUtil.isEmpty(obj2));
        Assertions.assertFalse(ValidateUtil.isEmpty(obj3));
        Assertions.assertTrue(ValidateUtil.isEmpty(obj4));
    }

    @Test
    public void isEmptyStringTest(){
        String str1 = "";
        boolean isEmpty = ValidateUtil.isEmpty(str1);
        Assertions.assertTrue(isEmpty, "is not empty string");
    }

    @Test
    public void isEmptyTest(){
        String str1 = null;
        String str2 = null;
        String str3 = "null";
        boolean isEmpty = ValidateUtil.isEmpty(str1, str2, str3);
        boolean isEmpty2 = ValidateUtil.isEmpty("1");
        System.out.println(isEmpty2);

        System.out.println(Integer.parseInt("1"));
        Assertions.assertFalse(isEmpty, "not all empty object");
    }

    @Test
    public void isAllEmptyTest(){
        String str1 = null;
        String str2 = null;
        String str3 = "null";
        boolean allEmpty = ValidateUtil.isAllEmpty(str1, str2, str3);
        Assertions.assertFalse(allEmpty, "not all empty object");
    }

}

package com.heanes.utils.core.validate;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * 常用验证工具类
 *
 * @author Heanes
 * @time 2019-11-19 16:16:57 周二
 */
public class ValidateUtil {

    /**
     * 验证对象是否为空
     *
     * @return boolean
     * @author Heanes
     * @time 2019-04-18 18:35:08 周四
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 验证对象是否为空
     *
     * @return boolean
     * @author Heanes
     * @time 2019-04-18 18:35:08 周四
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * 传入的所有字符串都为空
     *
     * @param str String
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isAllNull(Object str, Object... args) {
        boolean allIsNull = true;
        for (Object temp : args) {
            if (!isNull(temp)) {
                allIsNull = false;
                break;
            }
        }
        return allIsNull && isNull(str);
    }

    /**
     * 判断对象是否为空
     *
     * @param obj String
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isEmpty(Object obj) {
        if (isNull(obj)) {
            return true;
        }

        if (obj instanceof String) {
            return ((String) obj).length() == 0;
        }

        if (obj instanceof Byte) {
            return (Byte) obj == 0;
        }

        if (obj instanceof Short) {
            return (Short) obj == 0;
        }

        if (obj instanceof Integer) {
            return (Integer) obj == 0;
        }

        if (obj instanceof Long) {
            return (Long) obj == 0;
        }

        if (obj instanceof Float) {
            return (Float) obj == 0;
        }

        if (obj instanceof Double) {
            return (Double) obj == 0;
        }

        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).compareTo(BigDecimal.ZERO) == 0;
        }

        if (obj instanceof Collection) {
            return ((Collection<?>) obj).size() == 0;
        }

        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).size() == 0;
        }
        return false;
    }

    /**
     * 判断对象是否为空
     *
     * @param obj String
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 字符串是否为空
     *
     * @param str String
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || str.length() == 0;
    }

    /**
     * 集合是否为空
     *
     * @param collection Collection
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isEmpty(Collection<?> collection) {
        return isNull(collection) || collection.size() == 0;
    }

    /**
     * 字符串是否为空
     *
     * @param str String
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isEmpty(String str, String... strs) {
        boolean allIsEmpty = true;
        for (String temp : strs) {
            if (!isEmpty(temp)) {
                allIsEmpty = false;
            }
        }
        return allIsEmpty && isEmpty(str);
    }

    /**
     * 传入的所有字符串都为空
     *
     * @param str  String
     * @param strs 动态个数的参数
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isAllEmpty(String str, String... strs) {
        boolean allIsEmpty = true;
        for (String temp : strs) {
            if (!isEmpty(temp)) {
                allIsEmpty = false;
            }
        }
        return allIsEmpty && isEmpty(str);
    }

    /**
     * 对象不能为空
     *
     * @param obj Object
     * @param str String 提示
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static void notNull(Object obj, String str) {
        if (isNull(obj)) {
            throw new IllegalArgumentException(str);
        }
    }

    /**
     * 集合不能为空
     *
     * @param obj Object
     * @param str String 提示
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static void notEmpty(Object obj, String str) {
        if (isEmpty(obj)) {
            throw new IllegalArgumentException(str);
        }
    }

    /**
     * 传入的所有字符串不是都为空
     *
     * @param str  String
     * @param strs 动态个数的参数
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isNotAllEmpty(String str, String... strs) {
        return !isAllEmpty(str, strs);
    }

    /**
     * 传入的所有字符串都不为空
     *
     * @param str  String
     * @param strs 动态个数的参数
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isAllNotEmpty(String str, String... strs) {
        boolean allIsNotEmpty = false;
        for (String temp : strs) {
            if (!isEmpty(temp)) {
                allIsNotEmpty = true;
            }
        }
        return allIsNotEmpty && isNotEmpty(str);
    }

    /**
     * 集合是否不为空
     *
     * @param collection Collection
     * @author Heanes
     * @time 2019-04-19 10:32:10 周五
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static void main(String[] args) {
        String str1 = null;
        String str2 = null;
        String str3 = "null";
        boolean allEmpty = ValidateUtil.isAllEmpty(str1, str2, str3);
        boolean isEmpty = ValidateUtil.isEmpty(str1, str2, str3);
        System.out.println(allEmpty);
        System.out.println(isEmpty);
    }
}

package com.heanes.utils.java.core.common;

/**
 * 打印相关工具类
 *
 * @author Heanes
 * @time 2019-12-25 12:09:57 周三
 */
public class PrintUtil {

    /**
     * 变参数打印工具
     * @param objs 可变参数
     * @return String
     * @author Heanes
     * @time 2019-12-13 00:12:51 周五
     */
    public static String println(Object... objs) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : objs) {
            stringBuffer.append(obj);
        }
        return stringBuffer.toString();
    }
}

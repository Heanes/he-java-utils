package com.heanes.utils.core.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author Heanes
 * @time 2020-01-10 13:08:46 周五
 */
public class StringUtil {

    /**
     * 将单词首字母转为大写
     * @param word String
     * @return String
     * @author Heanes
     * @time 2017-07-07 19:06:39 周五
     */
    public String toUpperFirstLetter(String word) {
        /* word = word.substring(0, 1).toUpperCase() + word.substring(1);
        return word; */
        if (word == null || word.length() == 0) {
            return null;
        }
        char[] cs = word.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 将字符串转换为驼峰格式
     * @param str String
     * @return String
     * @author Heanes
     * @time 2017-07-07 20:06:23 周五
     */
    public synchronized String convertToCamelStyle(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strArray = str.split("_");
        List<String> wordList = new ArrayList<>();
        for (int i = 0, length = strArray.length; i < length; i++) {
            if (i == 0) {
                wordList.add(strArray[i]);
            } else {
                wordList.add(toUpperFirstLetter(strArray[i]));
            }
        }
        StringBuffer wordsBuffer = new StringBuffer();
        for (String word : wordList) {
            wordsBuffer.append(word);
        }
        return wordsBuffer.toString();
    }
}

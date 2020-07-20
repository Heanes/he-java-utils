package com.heanes.utils.core.common;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Map test
 *
 * @author Heanes
 * @time 2019-12-26 22:02:38 周四
 */
public class MapTest {

    @Test
    public void mapTest(){
        Map<String, Object> columnValueMap = new TreeMap<>();
        columnValueMap.put("aaa", Arrays.asList("11", "22"));

        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("cc", "value1");
        columnValueMap.put("bbb", valueMap);

        for (String key : columnValueMap.keySet()){

        }

        Set<Map.Entry<String, Object>> entries = columnValueMap.entrySet();
        for (Map.Entry<String, Object> entry : entries){

        }

        TreeMap<String, List<Object>> columnValueMap2 = new TreeMap<>();
        columnValueMap2.put("id", Arrays.asList(1L));
        System.out.println(columnValueMap2.get("id").get(0));

        System.out.println(columnValueMap);
    }
}

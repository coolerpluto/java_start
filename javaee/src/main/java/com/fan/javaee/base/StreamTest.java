package com.fan.javaee.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/23
 */
public class StreamTest {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        for (Map.Entry<Object, Object> objectObjectEntry : objectObjectHashMap.entrySet()) {
            objectObjectEntry.getKey();
            objectObjectEntry.getValue();            
        }
    }
}

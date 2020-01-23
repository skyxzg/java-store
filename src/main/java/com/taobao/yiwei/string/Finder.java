package com.taobao.yiwei.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhigang.xzg
 * @date 2020/1/18
 */
public class Finder {
    public static void main(String[] args) {
        System.out.println("====================");
        String locality = "F{1},R@zone1,FULL{1},L@zone2,LOGONLY@zone3";
        buildReplicaTypeMap(locality);

        System.out.println("====================");
        locality = "F{1},R@zone1";
        buildReplicaTypeMap(locality);

        System.out.println("====================");
        locality = "F{1}@zone1";
        buildReplicaTypeMap(locality);
    }


    private static Map<String, String> buildReplicaTypeMap(String locality) {
        String targetStr = locality;
        Map<String, String> typeMap = new HashMap<>();
        while (targetStr != null && targetStr.contains("@")) {
            int atIndex = targetStr.indexOf("@");
            String replicaStr = targetStr.substring(0, atIndex);
            String lastStr = targetStr.substring(atIndex + 1);
            String key;
            int commaIndex = lastStr.indexOf(",");
            if (commaIndex == -1) {
                key = lastStr;
                targetStr = null;
            } else {
                key = lastStr.substring(0, commaIndex);
                targetStr = lastStr.substring(commaIndex + 1);
            }
            String replicaType = extractReplicaType(replicaStr);
            typeMap.put(key, replicaType);
        }
        typeMap.forEach((k, v) -> System.out.println(k + ":" + v));
        return typeMap;
    }

    private static String extractReplicaType(String replicaStr) {
        String targetStr = replicaStr;
        int indexLeft = targetStr.indexOf("{");
        int indexRight = targetStr.indexOf("}");
        while (indexLeft != -1 && indexRight != -1) {
            targetStr = targetStr.substring(0, indexLeft) + targetStr.substring(indexRight + 1);
            indexLeft = targetStr.indexOf("{");
            indexRight = targetStr.indexOf("}");
        }
        return targetStr;
    }

}

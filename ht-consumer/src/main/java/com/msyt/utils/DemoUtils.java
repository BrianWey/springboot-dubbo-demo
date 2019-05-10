package com.msyt.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian
 * @description: 工具类
 * @date 2019/4/23
 */

public class DemoUtils {

    /**
     * 字符串转list
     *
     * @param string
     * @return list
     */
    public static List<String> stringToList(String string) {
        String[] vendorIdsArr = string.split(",");
        List<String> list = new ArrayList<>();
        for (int j = 0; j < vendorIdsArr.length; j++) {
            list.add(vendorIdsArr[j]);
        }
        return list;
    }

}

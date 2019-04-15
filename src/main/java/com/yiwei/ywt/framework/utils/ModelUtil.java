package com.yiwei.ywt.framework.utils;


import com.alibaba.fastjson.JSON;

import java.util.Map;

public class ModelUtil {

    public static <T> T map2Model(Map<String, String> map, Class<T> clazz) {
        if (null == map) {
            return null;
        }
        String params = JSON.toJSONString(map);
        return JSON.parseObject(params, clazz);
    }


}

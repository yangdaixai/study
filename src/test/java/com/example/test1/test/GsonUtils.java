package com.example.test1.test;

import com.google.gson.Gson;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-02-28-4:13 PM
 */
public class GsonUtils {
    private static final Gson GSON = new Gson();

    public static String toJson(Object source) {
        return GSON.toJson(source);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }
}

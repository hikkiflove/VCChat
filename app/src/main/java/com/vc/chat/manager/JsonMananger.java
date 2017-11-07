package com.vc.chat.manager;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

import java.util.List;

import retrofit2.adapter.rxjava.HttpException;

/**
 * @author Hikki
 *         json管理器(fastjson)
 */
public class JsonMananger {

    private static final String tag = JsonMananger.class.getSimpleName();

    static {
        TypeUtils.compatibleWithJavaBean = true;
    }

    /**
     * 将json字符串转换成java对象
     *
     * @param json
     * @param cls
     * @return
     * @throws HttpException
     */
    public static <T> T jsonToBean(String json, Class<T> cls) throws HttpException {
        return JSON.parseObject(json, cls);
    }

    /**
     * 将json字符串转换成java List对象
     *
     * @param json
     * @param cls
     * @return
     * @throws HttpException
     */
    public static <T> List<T> jsonToList(String json, Class<T> cls) throws HttpException {
        return JSON.parseArray(json, cls);
    }

    /**
     * 将bean对象转化成json字符串
     *
     * @param obj
     * @return
     * @throws HttpException
     */
    public static String beanToJson(Object obj) throws HttpException {
        String result = JSON.toJSONString(obj);
        Log.e(tag, "beanToJson: " + result);
        return result;
    }

}

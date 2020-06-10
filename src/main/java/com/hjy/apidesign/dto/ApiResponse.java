package com.hjy.apidesign.dto;

import com.hjy.apidesign.enums.ApiCodeEnum;
import com.hjy.apidesign.utils.ApiUtil;
import com.hjy.apidesign.utils.MD5Util;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: hjy
 * @Date: 2020/6/9 16:54
 * @Description:
 */
@Data
@Slf4j
public class ApiResponse<T> {

    /** 结果*/
    private ApiResult result;

    /** 数据*/
    private T data;

    /** 签名*/
    private String sign;

    public static <T>ApiResponse success(T data){
        return response(ApiCodeEnum.SUCCESS.getCode(),ApiCodeEnum.SUCCESS.getMsg(),data);
    }

    public static ApiResponse error(String code,String msg){
        return response(code,msg,null);
    }


    public static <T>ApiResponse response(String code,String msg,T data){
        ApiResult result = new ApiResult(code,msg);
        ApiResponse response = new ApiResponse();
        response.setResult(result);
        response.setData(data);


        return response;
    }

    private static <T> String signData(T data){
        //todo 查询key
        String key = "12345678984724";
        Map<String,String> responseMap = null;
        try {
            responseMap = getFields(data);
        }catch (IllegalAccessException e){
            return null;
        }

        String urlComponent = ApiUtil.concatSignString(responseMap);
        String signature = urlComponent + "key=" + key;
        String sign = MD5Util.encode(signature);

        return sign;

    }


    /**
     * @param data 反射的对象，获取对象的字段名和值
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     *
     * */
    public static Map<String,String> getFields(Object data)throws IllegalAccessException,IllegalArgumentException{
        if (data == null )return null;
        Map<String,String> map = new HashMap<>();
        Field[] fields = data.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            String name = field.getName();
            Object value = field.get(data);
            if (field.get(data)!=null){
                map.put(name,value.toString());
            }
        }

        return map;
    }

}

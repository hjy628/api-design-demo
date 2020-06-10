package com.hjy.apidesign.dto;

import lombok.Data;

/**
 * @auther: hjy
 * @Date: 2020/6/9 16:50
 * @Description:
 */
@Data
public class TokenInfo {

    /** token类型: api:0、 user:1*/
    private Integer tokenType;

    /** App信息*/
    private AppInfo appInfo;

    /** 用户其他数据*/
    private UserInfo userInfo;

}

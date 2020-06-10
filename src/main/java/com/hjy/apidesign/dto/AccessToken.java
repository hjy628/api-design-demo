package com.hjy.apidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @auther: hjy
 * @Date: 2020/6/9 16:46
 * @Description:
 */
@Data
@AllArgsConstructor
public class AccessToken {

    /** token*/
    private String token;

    /** 失效时间*/
    private Date expireTime;
}

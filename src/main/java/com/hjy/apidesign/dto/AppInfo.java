package com.hjy.apidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther: hjy
 * @Date: 2020/6/9 16:47
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppInfo {

    /** App id*/
    private String appId;

    /** API 密钥*/
    private String key;
}

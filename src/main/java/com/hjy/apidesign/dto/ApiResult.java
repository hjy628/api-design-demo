package com.hjy.apidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther: hjy
 * @Date: 2020/6/9 16:25
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    /** 代码*/
    private String code;

    /** 结果*/
    private String msg;
}

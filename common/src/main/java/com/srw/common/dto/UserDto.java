package com.srw.common.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/22 20:48
 */
@Data
@AllArgsConstructor
public class UserDto {

    @ExcelProperty("账号")
    private String name;

    @ExcelProperty("密码")
    private String password;

}

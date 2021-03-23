package com.srw.common.dto;

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

    private String name;

    private String password;

}

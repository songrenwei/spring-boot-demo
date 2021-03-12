package com.srw.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/10/13
 */
@Data
@NoArgsConstructor
@TableName("t_user")
@Accessors(chain = true)
public class User extends BaseEntity{

    @TableField(value = "name", exist = true)
    private String name;

    @TableField(value = "password", exist = true)
    private String password;

}

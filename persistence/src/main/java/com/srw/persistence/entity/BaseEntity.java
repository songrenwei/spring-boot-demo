package com.srw.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/12/11/16:44
 */
@Data
public class BaseEntity {

    //TableId为主键注解，value为字段值，type主键ID策略类型
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //使用@TableLogic注解实现逻辑删除
    @TableLogic
    @TableField(value = "is_deleted")
    protected Integer deleted = 0;

    //@TableField为字段注解，value为字段值，exist是否为数据库表字段（默认true存在，false不存在）
    @TableField(value = "create_time")
    protected Date createTime;

    @TableField(value = "update_time")
    protected Date updateTime;

}

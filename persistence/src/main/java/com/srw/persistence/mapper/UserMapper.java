package com.srw.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.srw.persistence.entity.User;

import java.util.List;

/**
 * @Description: TODO
 * @Author: songrenwei
 * @Date: 2020/11/4/16:17
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> findList();
}

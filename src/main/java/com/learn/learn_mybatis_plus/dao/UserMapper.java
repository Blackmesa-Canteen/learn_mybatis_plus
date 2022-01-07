package com.learn.learn_mybatis_plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.learn_mybatis_plus.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author shaotienlee
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}

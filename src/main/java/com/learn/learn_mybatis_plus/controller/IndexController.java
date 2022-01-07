package com.learn.learn_mybatis_plus.controller;

import com.learn.learn_mybatis_plus.dao.UserMapper;
import com.learn.learn_mybatis_plus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author 996Worker
 * @program learn_mybatis_plus
 * @description
 * @create 2022-01-07 12:39
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Resource
    UserMapper userMapper;

    @GetMapping(value = {"/","index"})
    public List<User> index() {
        return userMapper.selectList(null);
    }

    @GetMapping(value = "/insert")
    public String insert() {
        User user = new User();
        user.setId(Math.abs(UUID.randomUUID().getLeastSignificantBits() % 1000));
        user.setName(UUID.randomUUID().toString().substring(0,5));
        user.setEmail(UUID.randomUUID().toString().substring(0,5) + "@demo.com");
        user.setAge(Math.abs(new Random().nextInt() % 100));

        userMapper.insert(user);
        return "ok";
    }

    @GetMapping(value = "/update/{id}")
    public String updateById(@PathVariable("id") Long id) {

        User user = new User();
        user.setId(id);
        user.setName(UUID.randomUUID().toString().substring(0,5));

        userMapper.updateById(user);
        return "ok";
    }

    @GetMapping(value = "/select/{id}")
    public User selectById(@PathVariable("id") Long id) {

        return userMapper.selectById(id);
    }

    @GetMapping(value = "/selectByName/{name}")
    public List<User> selectByName(@PathVariable("name") String name) {
        HashMap<String, Object> map = new HashMap<>(10);
        map.put("name", name);

        return userMapper.selectByMap(map);
    }
}
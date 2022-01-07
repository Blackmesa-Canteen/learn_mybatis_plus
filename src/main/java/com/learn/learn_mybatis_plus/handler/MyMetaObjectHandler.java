package com.learn.learn_mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 996Worker
 * @program learn_mybatis_plus
 * @description
 * @create 2022-01-07 15:02
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill");

        this.setFieldValByName(
                "createTime",
                new Date(),
                metaObject
                );

        this.setFieldValByName(
                "updateTime",
                new Date(),
                metaObject
        );
    }

    // 更新时自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill");

        this.setFieldValByName(
                "updateTime",
                new Date(),
                metaObject
        );
    }
}
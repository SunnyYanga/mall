package com.yang.mall.service.impl;

import com.yang.mall.MallApplicationTests;
import com.yang.mall.enums.ResponseEnum;
import com.yang.mall.enums.RoleEnum;
import com.yang.mall.pojo.User;
import com.yang.mall.service.IUserService;
import com.yang.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @author yg
 * @date 2020/6/16 16:58
 */
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    @Autowired
    private IUserService userService;

    @Test
    public void register() {
        User user = new User("Jack", "123456", "Jack@qq.com", RoleEnum.CUSTOMER.getCode(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}
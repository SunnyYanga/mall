package com.yang.mall.service;

import com.yang.mall.pojo.User;
import com.yang.mall.vo.ResponseVo;

/**
 * @author yg
 * @date 2020/6/16 16:31
 */
public interface IUserService {

    /**
     * 用户注册
     * @param user
     */
    ResponseVo<User> register(User user);


    ResponseVo<User> login(String username, String password);
}

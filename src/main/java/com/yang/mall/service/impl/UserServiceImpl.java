package com.yang.mall.service.impl;

import com.yang.mall.dao.UserMapper;
import com.yang.mall.enums.ResponseEnum;
import com.yang.mall.enums.RoleEnum;
import com.yang.mall.pojo.User;
import com.yang.mall.service.IUserService;
import com.yang.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

/**
 * @author yg
 * @date 2020/6/16 16:39
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo<User> register(User user) {

        //校验
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {

            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
//            throw new RuntimeException("邮箱已存在");
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }

        user.setRole(RoleEnum.CUSTOMER.getCode());

        // MD5摘要算法
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
//            throw new RuntimeException("注册失败");
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return ResponseVo.error(ResponseEnum.USERNAME_ERROR_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            return ResponseVo.error(ResponseEnum.USERNAME_ERROR_OR_PASSWORD_ERROR);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }
}

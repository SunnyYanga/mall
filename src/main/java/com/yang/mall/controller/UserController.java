package com.yang.mall.controller;

import com.yang.mall.form.UserRegisterForm;
import com.yang.mall.form.UserLoginForm;
import com.yang.mall.pojo.User;
import com.yang.mall.service.IUserService;
import com.yang.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Objects;

import static com.yang.mall.consts.MallConst.CURRENT_USER;
import static com.yang.mall.enums.ResponseEnum.NEED_LOGIN;
import static com.yang.mall.enums.ResponseEnum.PARAM_ERROR;

/**
 * @author yg
 * @date 2020/6/16 17:39
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm) {
//        if (bindingResult.hasErrors()) {
//            log.error("注册提交的参数有误,{}{}", Objects.requireNonNull(bindingResult.getFieldError()).getField(), bindingResult.getFieldError().getDefaultMessage());
//            return ResponseVo.error(PARAM_ERROR, bindingResult);
//        }
        User user = new User();
        // 对象之间拷贝
        BeanUtils.copyProperties(userRegisterForm, user);
        //dto
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, HttpSession session) {
//        if (bindingResult.hasErrors()) {
//            return ResponseVo.error(PARAM_ERROR, bindingResult);
//        }

        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
//      设置session session保存在内存里 改进版本token + redis
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
//        if (user == null) {
//            return ResponseVo.error(NEED_LOGIN);
//        }

        return ResponseVo.success(user);
    }

    // 判断登录状态, 拦截器
    /**
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory}
     * getSessionTimeoutInMinutes
     * @param session
     * @return
     */
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session) {
//        User user = (User) session.getAttribute(CURRENT_USER);
//        if (user == null) {
//            return ResponseVo.error(NEED_LOGIN);
//        }

        session.removeAttribute(CURRENT_USER);
        return ResponseVo.success();
    }

}

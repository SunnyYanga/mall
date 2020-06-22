package com.yang.mall.interceptors;

import com.yang.mall.exception.UserLoginException;
import com.yang.mall.pojo.User;
import com.yang.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.yang.mall.consts.MallConst.CURRENT_USER;
import static com.yang.mall.enums.ResponseEnum.NEED_LOGIN;

/**
 * @author yg
 * @date 2020/6/17 14:49
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");

        User user = (User) request.getSession().getAttribute(CURRENT_USER);
        if (user == null) {
            log.info("user=null");
//            response.getWriter().print("error");
            throw new UserLoginException();
//            return false;
//            return ResponseVo.error(NEED_LOGIN);
        }
        return true;
    }
}

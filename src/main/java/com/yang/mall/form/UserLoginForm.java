package com.yang.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yg
 * @date 2020/6/17 8:45
 */
@Data
public class UserLoginForm {

//    @NotEmpty 用于集合
    @NotBlank  // 用于String 判断空格
    private String username;

    @NotBlank
    private String password;

}

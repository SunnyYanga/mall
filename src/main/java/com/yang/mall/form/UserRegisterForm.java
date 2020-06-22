package com.yang.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author yg
 * @date 2020/6/17 8:45
 */
@Data
public class UserRegisterForm {

//    @NotEmpty 用于集合
    @NotBlank  // 用于String 判断空格
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}

package com.yang.mall.enums;

import lombok.Getter;

/**
 * 0管理员 1普通用户
 * @author yg
 * @date 2020/6/16 17:10
 */
@Getter
public enum RoleEnum {
    ADMIN(0),

    CUSTOMER(1),

    ;

    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}


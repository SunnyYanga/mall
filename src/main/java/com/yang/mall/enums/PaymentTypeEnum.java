package com.yang.mall.enums;

import lombok.Getter;

/**
 * @author yg
 * @date 2020/6/20 16:43
 */
@Getter
public enum PaymentTypeEnum {

    PAY_ONLINE(1),

    ;

    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}

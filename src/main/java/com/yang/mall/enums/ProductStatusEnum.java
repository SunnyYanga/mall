package com.yang.mall.enums;

import lombok.Getter;

/**
 * @author yg
 * @date 2020/6/18 17:30
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),

    ;

    Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}

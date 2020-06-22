package com.yang.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yg
 * @date 2020/6/21 15:28
 */
@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;
}

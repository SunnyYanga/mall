package com.yang.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 添加商品
 * @author yg
 * @date 2020/6/19 11:26
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected = true;
}

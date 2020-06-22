package com.yang.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yg
 * @date 2020/6/18 15:57
 */
@Data
public class ProductVo {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private Integer status;

    private BigDecimal price;
}

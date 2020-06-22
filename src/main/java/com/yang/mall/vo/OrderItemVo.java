package com.yang.mall.vo;

import com.yang.mall.pojo.Shipping;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yg
 * @date 2020/6/20 13:55
 */
@Data
public class OrderItemVo {

    private Long orderNo;

    private Integer productId;

    private String productName;

    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;

}

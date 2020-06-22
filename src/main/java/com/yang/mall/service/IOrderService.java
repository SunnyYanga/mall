package com.yang.mall.service;

import com.github.pagehelper.PageInfo;
import com.yang.mall.vo.OrderVo;
import com.yang.mall.vo.ResponseVo;

/**
 * @author yg
 * @date 2020/6/20 13:58
 */
public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);
}

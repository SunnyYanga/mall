package com.yang.mall.service;

import com.github.pagehelper.PageInfo;
import com.yang.mall.form.ShippingForm;
import com.yang.mall.vo.ResponseVo;

import java.util.Map;

/**
 * @author yg
 * @date 2020/6/20 9:07
 */
public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}

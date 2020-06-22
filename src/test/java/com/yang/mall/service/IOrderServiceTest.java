package com.yang.mall.service;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yang.mall.MallApplicationTests;
import com.yang.mall.enums.ResponseEnum;
import com.yang.mall.form.CartAddForm;
import com.yang.mall.vo.CartVo;
import com.yang.mall.vo.OrderVo;
import com.yang.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author yg
 * @date 2020/6/20 15:13
 */
@Slf4j
@Transactional
public class IOrderServiceTest extends MallApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartService cartService;

    private Integer uid = 1;

    private Integer shippingId = 7;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void before() {
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(27);
        ResponseVo<CartVo> responseVo = cartService.add(1, cartAddForm);
        log.info("responseVo={}", gson.toJson(responseVo));
    }

    private ResponseVo<OrderVo> createTest() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
        return  responseVo;
    }

    @Test
    public void create() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 10);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<OrderVo> vo =createTest();
        ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderNo());
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void cancel() {
        ResponseVo<OrderVo> vo =createTest();
        ResponseVo<OrderVo> responseVo = orderService.cancel(uid, vo.getData().getOrderNo());
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}
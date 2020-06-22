package com.yang.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yang.mall.MallApplicationTests;
import com.yang.mall.form.CartAddForm;
import com.yang.mall.form.CartUpdateForm;
import com.yang.mall.pojo.Cart;
import com.yang.mall.vo.CartVo;
import com.yang.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author yg
 * @date 2020/6/19 14:50
 */
@Slf4j
public class ICartServiceTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void add() {
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(29);
        ResponseVo<CartVo> responseVo = cartService.add(1, cartAddForm);
        log.info("responseVo={}", gson.toJson(responseVo));
    }

    @Test
    public void list() {
        ResponseVo<CartVo> list = cartService.list(1);
        log.info("list={}", gson.toJson(list));
    }

    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(2);
        ResponseVo<CartVo> responseVo = cartService.update(1, 26, form);
        log.info("responseVo={}", gson.toJson(responseVo));
    }

    @Test
    public void delete() {
        ResponseVo<CartVo> responseVo = cartService.delete(1, 26);
        log.info("responseVo={}", gson.toJson(responseVo));
    }

    @Test
    public void selectAll() {
        ResponseVo<CartVo> responseVo = cartService.selectAll(1);
        log.info("responseVo={}", gson.toJson(responseVo));
    }

    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(1);
        log.info("responseVo={}", gson.toJson(responseVo));
    }

    @Test
    public void sum() {
        ResponseVo<Integer> responseVo = cartService.sum(1);
        log.info("responseVo={}", gson.toJson(responseVo));
    }
}
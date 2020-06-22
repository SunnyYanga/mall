package com.yang.mall.service;

import com.yang.mall.form.CartAddForm;
import com.yang.mall.form.CartUpdateForm;
import com.yang.mall.pojo.Cart;
import com.yang.mall.vo.CartVo;
import com.yang.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author yg
 * @date 2020/6/19 14:10
 */
public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);

}

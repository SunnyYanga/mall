package com.yang.mall.service;

import com.github.pagehelper.PageInfo;
import com.yang.mall.MallApplicationTests;
import com.yang.mall.enums.ResponseEnum;
import com.yang.mall.vo.ProductDetailVo;
import com.yang.mall.vo.ProductVo;
import com.yang.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yg
 * @date 2020/6/18 16:24
 */
public class IProductServiceTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> listResponseVo = productService.list(null, 1, 1);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), listResponseVo.getStatus());
    }

    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> detail = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), detail.getStatus());

    }
}
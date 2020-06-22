package com.yang.mall.service;

import com.github.pagehelper.PageInfo;
import com.yang.mall.vo.ProductDetailVo;
import com.yang.mall.vo.ProductVo;
import com.yang.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author yg
 * @date 2020/6/18 16:08
 */
public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}

package com.yang.mall.controller;

import com.github.pagehelper.PageInfo;
import com.yang.mall.service.IProductService;
import com.yang.mall.vo.ProductDetailVo;
import com.yang.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yg
 * @date 2020/6/18 17:08
 */
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products") //get请求后面带? 不能用json 取不到
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return productService.list(categoryId, pageNum, pageSize);
    }

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId) {
        return productService.detail(productId);
    }
}

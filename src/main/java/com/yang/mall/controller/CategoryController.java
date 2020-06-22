package com.yang.mall.controller;

import com.yang.mall.service.ICategoryService;
import com.yang.mall.vo.CategoryVo;
import com.yang.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yg
 * @date 2020/6/17 16:35
 */
@RestController
public class CategoryController {
    
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll(){
        return categoryService.selectAll();
    }
}

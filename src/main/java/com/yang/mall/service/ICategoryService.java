package com.yang.mall.service;

import com.yang.mall.vo.CategoryVo;
import com.yang.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * @author yg
 * @date 2020/6/17 16:12
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}

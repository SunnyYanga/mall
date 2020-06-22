package com.yang.mall.vo;

import com.yang.mall.pojo.Category;
import lombok.Data;

import java.util.List;

/**
 * @author yg
 * @date 2020/6/17 16:04
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}

package com.liuurick.dianping.service;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.model.CategoryModel;

import java.util.List;

/**
 * 种类管理
 */
public interface CategoryService {

    /**
     * 种类创建
     * @param categoryModel
     * @return
     * @throws BusinessException
     */
    CategoryModel create(CategoryModel categoryModel) throws BusinessException;

    /**
     * 通过id获取分类
     * @param id
     * @return
     */
    CategoryModel get(Integer id);

    /**
     * 查询所有的分类
     * @return
     */
    List<CategoryModel> selectAll();

    /**
     * 统计种类数量
     * @return
     */
    Integer countAllCategory();
}

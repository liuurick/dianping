package com.liuurick.dianping.service;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();

    Integer countAllCategory();
}

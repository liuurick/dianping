package com.liuurick.dianping.dal;

import com.liuurick.dianping.model.SellerModel;

import java.util.List;

public interface SellerModelMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SellerModel record);

    List<SellerModel> selectAll();

    int insertSelective(SellerModel record);

    SellerModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellerModel record);

    int updateByPrimaryKey(SellerModel record);

    Integer countAllSeller();
}
package com.liuurick.dianping.dal;

import com.liuurick.dianping.recommend.RecommendModel;

public interface RecommendModelMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RecommendModel record);

    int insertSelective(RecommendModel record);

    RecommendModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendModel record);

    int updateByPrimaryKey(RecommendModel record);
}
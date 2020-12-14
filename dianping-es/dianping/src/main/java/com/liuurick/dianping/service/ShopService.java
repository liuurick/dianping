package com.liuurick.dianping.service;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.model.ShopModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 商品服务
 */
public interface ShopService {

    /**
     * 创建商品
     * @param shopModel
     * @return ShopModel
     * @throws BusinessException
     */
    ShopModel create(ShopModel shopModel) throws BusinessException;

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    ShopModel get(Integer id);

    /**
     * 查询所有商品
     * @return
     */
    List<ShopModel> selectAll();

    /**
     * 商品数量统计
     * @return
     */
    Integer countAllShop();

    /**
     * 推荐商品V1.0
     * @param longitude
     * @param latitdue
     * @return
     */
    List<ShopModel> recommend(BigDecimal longitude,BigDecimal latitdue);

    /**
     * 根据种类推荐
     * @param categoryId
     * @param longitude
     * @param latitude
     * @return
     */
    List<ShopModel> recommendByCategoryId(Integer categoryId, BigDecimal longitude, BigDecimal latitude);

    /**
     * 搜索V1.0
     * @param longitude
     * @param latitude
     * @param keyword
     * @param orderby
     * @param categoryId
     * @param tags
     * @return
     */
    List<ShopModel> search(BigDecimal longitude,BigDecimal latitude,String keyword,Integer orderby,Integer categoryId,String tags);

    /**
     * 搜索V2.0
     * @param longitude
     * @param latitude
     * @param keyword
     * @param orderby
     * @param categoryId
     * @param tags
     * @return
     * @throws IOException
     */
    Map<String,Object> searchES(BigDecimal longitude,BigDecimal latitude,String keyword,Integer orderby,Integer categoryId,String tags) throws IOException;

    /**
     * 根据标签搜索
     * @param keyword
     * @param categoryId
     * @param tags
     * @return
     */
    List<Map<String,Object>> searchGroupByTags(String keyword,Integer categoryId,String tags);
}

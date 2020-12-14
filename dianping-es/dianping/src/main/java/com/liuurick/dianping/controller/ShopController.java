package com.liuurick.dianping.controller;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.common.CommonRes;
import com.liuurick.dianping.common.EmBusinessError;
import com.liuurick.dianping.model.CategoryModel;
import com.liuurick.dianping.model.ShopModel;
import com.liuurick.dianping.service.CategoryService;
import com.liuurick.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    //推荐服务V1.0
    @RequestMapping("/recommend")
    @ResponseBody
    public CommonRes recommend(@RequestParam(name="longitude")BigDecimal longitude,
                               @RequestParam(name="latitude")BigDecimal latitude) throws BusinessException {
        if(longitude == null || latitude == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude,latitude);
        return CommonRes.create(shopModelList);
    }


    /**
     * 推荐服务加上category
     * @param longitude
     * @param latitude
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/recommendByCategoryId")
    @ResponseBody
    public CommonRes recommendByCategoryId(@RequestParam(name = "categoryId")Integer categoryId,@RequestParam(name="longitude")BigDecimal longitude,
                               @RequestParam(name="latitude")BigDecimal latitude) throws BusinessException {
        if(longitude == null || latitude == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommendByCategoryId(categoryId,longitude,latitude);
        return CommonRes.create(shopModelList);
    }

    /**
     * 搜索服务V1.0
     * @param longitude
     * @param latitude
     * @param keyword
     * @param orderby
     * @param categoryId
     * @param tags
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/search")
    @ResponseBody
    public CommonRes search(@RequestParam(name="longitude")BigDecimal longitude,
                            @RequestParam(name="latitude")BigDecimal latitude,
                            @RequestParam(name="keyword")String keyword,
                            @RequestParam(name="orderby",required = false)Integer orderby,
                            @RequestParam(name="categoryId",required = false)Integer categoryId,
                            @RequestParam(name="tags",required = false)String tags) throws BusinessException {
        if(StringUtils.isEmpty(keyword) || longitude == null || latitude == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.search(longitude,latitude,keyword,orderby,categoryId,tags);
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        List<Map<String,Object>> tagsAggregation = shopService.searchGroupByTags(keyword,categoryId,tags);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("shop",shopModelList);
        resMap.put("category",categoryModelList);
        resMap.put("tags",tagsAggregation);
        return CommonRes.create(resMap);

    }

    /**
     * 基于ElasticSearch的搜索服务
     * @param longitude
     * @param latitude
     * @param keyword
     * @param orderby
     * @param categoryId
     * @param tags
     * @return
     * @throws BusinessException
     * @throws IOException
     */
    @RequestMapping("/searches")
    @ResponseBody
    public CommonRes searchES(@RequestParam(name = "longitude")BigDecimal longitude,
                              @RequestParam(name = "latitude")BigDecimal latitude,
                              @RequestParam(name = "keyword")String keyword,
                              @RequestParam(name = "orderby", required = false)Integer orderby,
                              @RequestParam(name = "categoryId", required = false)Integer categoryId,
                              @RequestParam(name = "tags", required = false)String tags) throws BusinessException, IOException {
        if (StringUtils.isEmpty(keyword) || longitude == null || latitude == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        Map<String,Object> result = shopService.searchES(longitude,latitude,keyword,orderby,categoryId,tags);
        List<ShopModel> shopModelList = (List<ShopModel>) result.get("shop");
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        List<Map<String, Object>> tagsAggregation = (List<Map<String, Object>>) result.get("tags");

        //为了以后扩展筛选条件，故不和推荐一样直接返回list的model
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("shop",shopModelList);
        resMap.put("category",categoryModelList);
        resMap.put("tags",tagsAggregation);
        return CommonRes.create(resMap);
    }




}

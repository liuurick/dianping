package com.liuurick.dianping.service.impl;

import com.liuurick.DianpingApplicationTests;
import com.liuurick.dianping.dal.ShopModelMapper;
import com.liuurick.dianping.model.ShopModel;
import org.junit.Test;
import com.liuurick.DianpingApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by liubin on 2020/12/11
 */
public class ShopServiceImplTest extends DianpingApplicationTests {

    @Autowired
    private ShopModelMapper shopModelMapper;

    @Test
    public void recommendByCategoryId() {
        //public List<ShopModel> recommendByCategoryId(Integer categoryId, BigDecimal longitude, BigDecimal latitude) {
        List<ShopModel> models = shopModelMapper.recommendByCategoryId(1,BigDecimal.valueOf(31.195341),BigDecimal.valueOf(12.195341));

    }
}
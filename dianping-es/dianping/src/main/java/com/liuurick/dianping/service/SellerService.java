package com.liuurick.dianping.service;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.model.SellerModel;

import java.util.List;

/**
 * 商家服务
 * @author liubin
 */
public interface SellerService {

    /**
     * 商家创建功能
     * @param sellerModel
     * @return
     */
    SellerModel create(SellerModel sellerModel);

    /**
     * 商家查询功能
     * @param id
     * @return
     */
    SellerModel get(Integer id);

    /**
     * 批量查询
     * @return
     */
    List<SellerModel> selectAll();

    /**
     * 设置商家状态
     * @param id
     * @param disabledFlag
     * @return
     * @throws BusinessException
     */
    SellerModel changeStatus(Integer id,Integer disabledFlag) throws BusinessException;


    /**
     * 统计商家数量
     * @return
     */
    Integer countAllSeller();
}


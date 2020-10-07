package com.liuurick.dianping.service;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.model.SellerModel;

import java.util.List;

public interface SellerService {

    SellerModel create(SellerModel sellerModel);
    SellerModel get(Integer id);
    List<SellerModel> selectAll();
    SellerModel changeStatus(Integer id,Integer disabledFlag) throws BusinessException;

    Integer countAllSeller();
}

package com.liuurick.dianping.service;

import com.liuurick.dianping.common.BusinessException;
import com.liuurick.dianping.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户服务
 * @author liubin
 */
public interface UserService {

    /**
     * 通过di查询用户
     * @param id
     * @return
     */
    UserModel getUser(Integer id);

    /**
     * 注册、添加
     * @param registerUser
     * @return
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 登录
     * @param telphone
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws BusinessException
     */
    UserModel login(String telphone,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;

    /**
     * 商家的注册数量
     * @return
     */
    Integer countAllUser();
}


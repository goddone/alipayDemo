/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alipay.api.AlipayResponse;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayTargetResponse;
import com.alipay.demo.response.converter.to.ToAlipayAddAccountResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayDefaultResponseConverter;
import com.alipay.demo.response.converter.to.ToAlipayResponseConverter;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 请求支付宝业务模型工厂
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayModelResponseFactory.java, v 0.1 2014-1-10 下午4:06:11 jie.hua Exp $
 */
public class ToAlipayModelResponseFactory {

    /**
     * 日志管理
     */
    private static final Logger                                                    logger       = Logger
                                                                                                    .getLogger(ToAlipayModelResponseFactory.class);

    /**
     * 转换器
     */
    private static Map<Class<? extends AlipayResponse>, ToAlipayResponseConverter> converterMap = new HashMap<Class<? extends AlipayResponse>, ToAlipayResponseConverter>();

    /**
     * 初始化转换器
     */
    static {

        registerConverter(new ToAlipayAddAccountResponseConverter());
        registerConverter(new ToAlipayDefaultResponseConverter());

    }

    /**
     * 注册转换器
     * 
     * @param toAlipayResponseConverter
     */
    private static void registerConverter(ToAlipayResponseConverter toAlipayResponseConverter) {

        converterMap.put(toAlipayResponseConverter.getSrcClass(), toAlipayResponseConverter);
    }

    /**
     * 获取转换器
     * <pre>
     *  根据结果类型，换取对应转换器。若不存在，则返回ToAlipayDefaultResponseConverter
     * </pre>
     * 
     * @param claz
     * @return
     */
    private static ToAlipayResponseConverter getConverter(Class<? extends AlipayResponse> clz) {

        ToAlipayResponseConverter converter = converterMap.get(clz);

        // 不存在则返回默认转换器
        if (converter == null) {

            converter = converterMap.get(AlipayResponse.class);
        }

        // 都不存在则跑出异常
        if (converter == null) {

            LoggerUtil.error(logger, "响应类[" + clz + "]不存在对应转换器!");

            throw new AlipayDemoException(ResultEnum.NO_SUCH_CONVERTER.getResultCode(),
                String.format(ResultEnum.NO_SUCH_CONVERTER.getResultMsg(), clz.toString()));
        }

        return converter;
    }

    /**
     * 构建业务响应
     * 
     * @param toAlipayTargetResponse
     * @return
     */
    public static ToAlipayModelResponse buildModelRespFromTarget(ToAlipayTargetResponse toAlipayTargetResponse) {

        if (toAlipayTargetResponse == null || toAlipayTargetResponse.getAlipayResponse() == null) {

            return buildFailResponse(ResultEnum.SYSTEM_ERROR.getResultCode(),
                ResultEnum.SYSTEM_ERROR.getResultMsg());

        } else {

            AlipayResponse alipayResponse = toAlipayTargetResponse.getAlipayResponse();

            // 根据不同的API Name 转换成不同的model response
            ToAlipayResponseConverter converter = getConverter(alipayResponse.getClass());

            return converter.convert(alipayResponse);

        }

    }

    /**
     * 构建一个失败的结果
     * 
     * @param resultCode
     * @param resultMsg
     * @return
     */
    public static ToAlipayModelResponse buildFailResponse(String resultCode, String resultMsg) {

        ToAlipayModelResponse alipayModelReponseParam = new ToAlipayModelResponse(resultCode,
            resultMsg);
        alipayModelReponseParam.setSuccess(false);

        return alipayModelReponseParam;

    }

}

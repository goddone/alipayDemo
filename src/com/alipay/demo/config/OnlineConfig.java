/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import com.alipay.demo.bean.ToStringBase;

/**
 * 在线配置
 * 
 * @author jie.hua@alipay.com
 * @version $Id: OnlineConfig.java, v 0.1 2014-1-16 上午9:13:26 jie.hua Exp $
 */
public class OnlineConfig extends ToStringBase implements Config {

    /** 序列号 */
    private static final long serialVersionUID = 8372115145760188675L;

    /** 
     * @see com.alipay.demo.config.Config#getGateWay()
     */
    @Override
    public String getGateWay() {
        return "https://openapi.alipay.com/gateway.do";
    }

	@Override
	public String getPublicId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMerchantPublicKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMerchantPrivateKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlipayPublicKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCheckSign() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDecrypt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSign() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEncrypt() {
		// TODO Auto-generated method stub
		return false;
	}

  

}

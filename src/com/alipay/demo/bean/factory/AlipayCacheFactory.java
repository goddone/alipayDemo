/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.demo.cache.AlipayMemoryCache;
import com.alipay.demo.cache.Cache;
import com.alipay.demo.cache.CacheLoggerWapper;

/**
 * 缓存工厂类
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayCacheFactory.java, v 0.1 2014-1-8 下午10:26:32 jie.hua Exp $
 */
public class AlipayCacheFactory {

    /**
     * 获取缓存实例
     * <pre>
     *  目前只实现了内存缓存实例,商户可以自行扩展
     * </pre>
     * 
     * @return
     */
    public static Cache getCacheInstance() {

        return new CacheLoggerWapper(AlipayMemoryCache.getInstance());
    }

}

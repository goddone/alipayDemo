/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alipay.demo.process.ServiceExecutor;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InServiceExecutorFactory.java, v 0.1 2014-1-6 下午9:46:12 jie.hua Exp $
 */
public class InServiceExecutorFactory {

    /**
     * 服务映射
     */
    private Map<String, ServiceExecutor> executorMaps = new HashMap<String, ServiceExecutor>();

    /**
     * 根据name查询服务执行器
     * 
     * @param name
     * @return
     */
    public ServiceExecutor getExecutorByName(String name) {

        return executorMaps.get(name);

    }

    /**
     *  设置服务执行器
     * 
     * @param executors
     */
    public void setExecutorList(List<InServiceExecutor> executors) {

        if (executors == null || executors.isEmpty()) {

            return;
        }

        for (InServiceExecutor executor : executors) {

            executorMaps.put(executor.getExecutorName(), executor);
        }

    }

}

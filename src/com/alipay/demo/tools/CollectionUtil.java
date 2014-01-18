/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import java.util.Collection;
import java.util.Map;

/**
 * ÈÝÆ÷¹¤¾ß
 * 
 * @author jie.hua@alipay.com
 * @version $Id: CollectionUtil.java, v 0.1 2014-1-8 ÏÂÎç11:08:05 jie.hua Exp $
 */
public class CollectionUtil {

    /**
     * ÅÐ¶ÏÈÝÆ÷Îª¿Õ
     * 
     * @param c
     * @return
     */
    public static boolean isEmpty(Map<?, ?> c) {

        return c == null || c.isEmpty();
    }

    /**
     * ÅÐ¶ÏÈÝÆ÷²»Îª¿Õ
     * 
     * @param c
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> c) {

        return !isEmpty(c);
    }

    /**
     * ÅÐ¶ÏÈÝÆ÷Îª¿Õ
     * 
     * @param c
     * @return
     */
    public static boolean isEmpty(Collection<?> c) {

        return c == null || c.isEmpty();
    }

    /**
     * ÅÐ¶ÏÈÝÆ÷²»Îª¿Õ
     * 
     * @param c
     * @return
     */
    public static boolean isNotEmpty(Collection<?> c) {

        return !isEmpty(c);
    }

}

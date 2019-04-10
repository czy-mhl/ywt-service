/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework.dao;

/**
 * 通用的带增删改查功能的Mapper. <p />
 *
 * @author czy
 * @version 1.0.0
 * @date 2017/11/16 下午4:31
 * @since JDK1.8
 */
public interface CRUDMapper<T> extends CreateMapper<T>, RetrieveMapper<T>, UpdateMapper<T>, DeleteMapper<T> {

}

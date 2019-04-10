/*
 * Copyright (c) 2016, Seer Tech co. tld. All rights reserved.
 * SEER TECH PROJECT: cherry. Use is subject to license terms.
 *
 *
 *
 *
 *
 */
package com.yiwei.ywt.framework;

/**
 * 框架类. <p /
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/10 下午4:09
 * @since JDK1.8
 */
public final class Cherry {

    private static final int MAJOR_VERSION = 0;

    private static final int MINOR_VERSION = 1;

    private static final int REVISION_VERSION = 0;

    /**
     * 获取版本号.
     *
     * @return  版本号
     */
    public static String getVersion() {
        return MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION;
    }
}

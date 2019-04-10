package com.yiwei.ywt.framework.web.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Cherry上下文加载类，这个类继承了Spring的方法. <p />
 *
 * Created by czy on 2015/2/8.
 */
public class CherryContextLoadListener extends ContextLoaderListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(CherryContextLoadListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
    }

}

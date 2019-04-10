package com.yiwei.ywt.framework.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 本地配置文件加载类. <p />
 *
 * Created by czy on 2017/2/10.
 */
public class LocalPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        // 将Hadoop集群，Hive的配置抽离出来
        super.processProperties(beanFactoryToProcess, props);
    }
}

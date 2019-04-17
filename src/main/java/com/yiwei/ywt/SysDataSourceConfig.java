package com.yiwei.ywt;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.yiwei.ywt.sys.*.mapper", sqlSessionFactoryRef = "sysSqlSessionFactory")
public class SysDataSourceConfig {
    @Bean(name = "sysDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sys")
    public DataSource sysDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sysSqlSessionFactory")
    @Primary
    public SqlSessionFactory sysSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/sys/**/*.xml"));
        return bean.getObject();
    }

    @Bean("sysSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sysSqlSessionTemplate(@Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

    /******配置事务管理(多数据源配置多个)********/

    @Bean
    public PlatformTransactionManager bfTransactionManager(@Qualifier("sysDataSource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }


}


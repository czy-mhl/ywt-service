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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.yiwei.ywt.businessProcess.*.mapper", sqlSessionFactoryRef = "businessProcessSqlSessionFactory")
public class BusinessProcessDataSourceConfig {
    @Bean(name = "businessProcessDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.businessprocess")
    public DataSource businessProcessDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "businessProcessSqlSessionFactory")
    public SqlSessionFactory businessProcessSqlSessionFactory(@Qualifier("businessProcessDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/businessProcess/**/*.xml"));
        return bean.getObject();
    }

    @Bean("businessProcessSqlSessionTemplate")
    public SqlSessionTemplate businessProcessSqlSessionTemplate(@Qualifier("businessProcessSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
}


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
@MapperScan(basePackages = "com.shenhuaweiye.repository.thirdly.*.mapper", sqlSessionFactoryRef = "thirdlySqlSessionFactory")
public class thirdlyDataSourceConfig {
    @Bean(name = "thirdlyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.thirdly")
    public DataSource thirdlyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "thirdlySqlSessionFactory")
    public SqlSessionFactory thirdlySqlSessionFactory(@Qualifier("thirdlyDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:lhZhengZuanJing/**/*.xml"));
        return bean.getObject();
    }

    @Bean("thirdlySqlSessionTemplate")
    public SqlSessionTemplate thirdlySqlSessionTemplate(@Qualifier("thirdlySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
}


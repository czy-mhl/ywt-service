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
@MapperScan(basePackages = "com.yiwei.ywt.waterCost.*.mapper", sqlSessionFactoryRef = "waterCostSqlSessionFactory")
public class WaterCostDataSourceConfig {
    @Bean(name = "waterCostDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.watercost")
    public DataSource waterCostDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "waterCostSqlSessionFactory")
    public SqlSessionFactory waterCostSqlSessionFactory(@Qualifier("waterCostDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/waterCost/**/*.xml"));
        return bean.getObject();
    }

    @Bean("waterCostSqlSessionTemplate")
    public SqlSessionTemplate waterCostSqlSessionTemplate(@Qualifier("waterCostSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
}


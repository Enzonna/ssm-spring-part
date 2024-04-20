package com.enzo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * ClassName: JavaConfig
 * Package: com.enzo.config
 * Description:
 *
 * @Author ENZO
 * @Create 2024/3/19 15:11
 * @Version 1.0
 */

@Configuration
@ComponentScan(basePackages = "com.enzo")
@PropertySource(value = "classpath:jdbc.properties")
public class JavaConfig {

    @Bean
    public DataSource dataSource(@Value("${enzo.driver}") String driver, @Value("${enzo.url}") String url,
                                 @Value("${enzo.username}") String username, @Value("${enzo.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }


}

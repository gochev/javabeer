package org.gochev;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariCPConfig {

	@Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(dataSourceUrl);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }

}
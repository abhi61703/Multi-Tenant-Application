package com.example.Multi_Tenant.Tenant;

import com.example.Multi_Tenant.Tenant.TenantAwareDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        TenantAwareDataSource dataSource = new TenantAwareDataSource();

        // Configure the default datasource
        DriverManagerDataSource defaultDataSource = new DriverManagerDataSource();
        defaultDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        defaultDataSource.setUrl("jdbc:mysql://localhost:3306/multi_tenant_db");
        defaultDataSource.setUsername("root");
        defaultDataSource.setPassword("pass@word1");

        // Set default datasource
        dataSource.setDefaultTargetDataSource(defaultDataSource);

        // Configure tenant-specific data sources (if needed)
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("tenant1", defaultDataSource); // Add configurations for different tenants here

        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }
}

package org.wzx.cloud.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.maxWait}")
    private Long maxWait;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.filters}")
    private String filters;

    @Primary
    @Bean(destroyMethod = "close",initMethod = "init")
    public DataSource druidDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(initialSize);
        ds.setMinIdle(minIdle);
        ds.setMaxActive(maxActive);
        ds.setMaxWait(maxWait);
        ds.setValidationQuery(validationQuery);
        try {
            ds.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new StatViewServlet());
        bean.addUrlMappings("/druid/*");
        return bean;
    }

    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        filter.addUrlPatterns("/*");
        filter.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filter.addInitParameter("profileEnable", "true");
        filter.addInitParameter("DruidWebStatFilter","/*");
        return filter;
    }
}

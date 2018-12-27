package org.wzx.cloud.fictionprovider.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.filters}")
    private String filters;

    @Primary
    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxWait);
        try {
            dataSource.setFilters(filters);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        filter.addUrlPatterns("/*");
        filter.addInitParameter("exclusions", ".js,*.gif,*.jpg,*.png,*.css,*.ico,/admin/druid/*");
        filter.addInitParameter("profileEnable", "true");
        filter.addInitParameter("principalCookieName", "USER_COOKIE");
        filter.addInitParameter("principalSessionName", "USER_SESSION");
        filter.addInitParameter("DruidWebStatFilter", "/*");
        return filter;
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServletRegister() {
        ServletRegistrationBean<StatViewServlet> servlet = new ServletRegistrationBean<StatViewServlet>();
        servlet.setServlet(new StatViewServlet());
        servlet.addUrlMappings("/druid/*");
        servlet.addInitParameter("allow", "");
        return servlet;
    }
}

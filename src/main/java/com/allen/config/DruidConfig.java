package com.allen.config;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Allen
 * @date 2021/3/13 10:16
 */

@Configuration
public class DruidConfig {
    //将application.yml中的spring.datasource属性与DruidDataSource绑定
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控  web.xml, ServletRegistrationBean
    //因为SpringBoot内置了Servlet容器，所以没有 web.xml, 替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //后台登录，账号密码配置
        HashMap<String,String> hashMap = new HashMap<>();
        //增加配置
        hashMap.put("loginUsername","admin");   //登录的 key 是固定的：loginUsername  loginPassword
        hashMap.put("loginPassword","123");
        //允许谁可以访问
        //hashMap.put("allow","");
        //禁止谁访问
        //hashMap.put("allen","192.168.11.123");
        bean.setInitParameters(hashMap);    //设置初始化参数
        return bean;
    }

    //filter
    //配置 Druid 监控 之  web 监控的 filter
    //WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //设置过滤哪些请求
        HashMap<String,String> hashMap = new HashMap<>();
        //这些东西不过滤, "/*" 表示所有请求
        hashMap.put("exclusions","*.js,*.css,/druid/*");
        bean.setFilter(new WebStatFilter());
        return bean;
    }
}

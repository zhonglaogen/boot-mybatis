package com.zlx.bootmybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** druid
 * 要导入数据源
 * 配置自定义的连接池，boot的连接池都是通过invoke创建，
 * 我们的用new创建
 */
@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    /**ServletRegistrationBean，自定义servlet
     * 配置druid监控,请求/druid会出现连接池的图形化界面
     * //1配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean
                = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> map=new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");//默认允许所有


        bean.setInitParameters(map);
        return bean;
    }
    /**
     * 2配置一个web监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());

        Map<String,String> map=new HashMap<>();
        //配置哪些请求不拦截
        //drud/本身请求不用拦截
        map.put("exclusions","*.js,*.css,/druid/*");
        filter.setInitParameters(map);

        //设置拦截的请求
        filter.setUrlPatterns(Arrays.asList("/*"));
        return filter;

    }

}

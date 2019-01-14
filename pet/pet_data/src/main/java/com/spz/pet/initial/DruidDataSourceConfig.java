/**
 * @文件名称： DruidDataSourceConfig.java
 * @文件路径： com.example.demo.config
 * @功能描述： TODO
 * @作者： shipengzhen
 * @创建时间：2018年9月15日 下午9:54:29
 */
package com.spz.pet.initial;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;

/**
 * @功能描述：
 * @创建人： shipengzhen
 * @创建时间： 2018年9月15日 下午9:54:29
 */
@Configuration
@PropertySource(value="classpath:datasource/mysql.properties")
public class DruidDataSourceConfig {

    //配置数据源,使用阿里 druid 数据库连接池
    //    @ConfigurationProperties(prefix = "spring.datasource")
    //    @Bean(name = "dataSourceBean", destroyMethod = "close", initMethod = "init") //声明其为Bean实例  
    //    @Primary //在同样的DataSource中，首先使用被标注的DataSource  
    //    public DataSource dataSource() {
    //        DruidDataSource datasource = new MyDruidDataSource();
    //        //解密的类
    //        //PasswordCallback passwordCallback = new MyPassWordCallBack();
    //        //datasource.setPasswordCallback(passwordCallback);
    //        return datasource;
    //    }

    @SuppressWarnings("unchecked")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    public DataSource dataSource() throws ClassNotFoundException, IOException {

        Resource resource = new ClassPathResource("datasource/mysql.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        Class<? extends DataSource> dataSourceType = (Class<? extends DataSource>) Class
                .forName(props.getProperty("spring.datasource.mysql.type"));

        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    //配置mybatis的sqlSessionFactory
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        //sqlSessionFactory.setTypeAliasesPackage("com.example.demo.mapper");
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        //添加插件
        Interceptor interceptor = new PageInterceptor();
        interceptor.setProperties(properties);
        sqlSessionFactory.setPlugins(new Interceptor[] { interceptor });

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-configuration.xml"));
        try {
            //sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:com/spz/pet/mapper/*.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.getObject();
    }

    //配置mybatis的sqlSessionTemplate
    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.spz.pet.business.*.mapper");
        //transactionManager.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        return mapperScannerConfigurer;
    }

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");

        //添加初始化参数：initParams
        //白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");

        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}

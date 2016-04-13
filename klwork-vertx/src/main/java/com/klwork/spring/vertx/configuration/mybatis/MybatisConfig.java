package com.klwork.spring.vertx.configuration.mybatis;

import com.klwork.common.dao.BaseMybaitsDao;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;

/**
 *
 */
@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class MybatisConfig {

    private static Logger log = LoggerFactory.getLogger(MybatisConfig.class);

    /*@Autowired
    private JdbcConnectionSettings jdbcConnectionSettings;*/

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.addDataSourceProperty("cachePrepStmts", "true");
        dataSource.addDataSourceProperty("prepStmtCacheSize", "250");
        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource.addDataSourceProperty("useServerPrepStmts", "true");
        return dataSource;
    }


    public Resource[] getResource(String basePackage, String pattern) throws IOException {
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                + ClassUtils.convertClassNameToResourcePath(new StandardEnvironment()
                .resolveRequiredPlaceholders(basePackage)) + "/" + pattern;
        System.out.println("packageSearchPath : " + packageSearchPath);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
        return resources;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        log.debug("> sqlSessionFactory");
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactory.setFailFast(true);
        sqlSessionFactory.setMapperLocations(getResource("mapper", "**/*.xml"));

        //sqlSessionFactory.setTypeHandlersPackage("demo.springboot.configuration.mybatis.typehandler");
        return sqlSessionFactory.getObject();
    }


    @Bean
    public DataSourceTransactionManager transactionManager() {
        log.debug("> transactionManager");
        return new DataSourceTransactionManager(dataSource());
    }


    @Bean
    public BaseMybaitsDao baseMybaitsDao() throws Exception{
        log.debug("> baseMybaitsDao");
        BaseMybaitsDao dao = new BaseMybaitsDao();
        dao.setSqlSessionFactory(sqlSessionFactory());
        return dao;
    }

    @PostConstruct
    public void postConstruct() {
        //log.info("jdbc.settings={}", jdbcConnectionSettings);
    }
}

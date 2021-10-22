package com.medclinic.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

    private Properties properties = new Properties();

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.medclinic.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(hibernateProperties().getProperty("hibernate.connection.driver_class"));
        dataSource.setUrl(hibernateProperties().getProperty("hibernate.connection.url"));
        dataSource.setUsername(hibernateProperties().getProperty("hibernate.connection.username"));
        dataSource.setPassword(hibernateProperties().getProperty("hibernate.connection.password"));
        return dataSource;
    }

    public final Properties hibernateProperties(){
        properties.setProperty("hibernate.connection.autocommit", "false");
        properties.setProperty("hibernate.hbm2ddl.create_namespaces", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/med_clinic");
        properties.setProperty("hibernate.connection.username", "admin");
        properties.setProperty("hibernate.connection.password", "admin");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }

}

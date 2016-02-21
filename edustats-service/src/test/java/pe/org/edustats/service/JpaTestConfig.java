package pe.org.edustats.service;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("pe.org.edustats.data.repository")
@EnableTransactionManagement
public class JpaTestConfig {
  @Value("${data.driver}")
  private String databaseDriver;
  @Value("${data.url}")
  private String databaseUrl;
  @Value("${data.username}")
  private String databaseUsername;
  @Value("${data.password}")
  private String databasePassword;
  @Value("${data.dialect}")
  private String databaseDialect;

  private Properties hibernateProperties () {
      Properties properties = new Properties();
      properties.put("hibernate.dialect", databaseDialect);
      properties.put("hibernate.show_sql", false);
      return properties;
  }
  
  @Bean
  public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();

      dataSource.setDriverClassName(databaseDriver);
      dataSource.setUrl(databaseUrl);
      dataSource.setUsername(databaseUsername);
      dataSource.setPassword(databasePassword);

      return dataSource;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager() {
      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(entityManagerFactory());
      return txManager;
  }

  @Bean
  public EntityManagerFactory entityManagerFactory () {
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setJpaVendorAdapter(vendorAdapter);
      factory.setPackagesToScan("pe.org.edustats.data.model");
      factory.setDataSource(dataSource());
      factory.setJpaProperties(hibernateProperties());
      factory.afterPropertiesSet();

      return factory.getObject();
  }

}

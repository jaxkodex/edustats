package pe.org.edustats.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"pe.org.edustats.service"})
@PropertySource("classpath:/test.properties")
@Import({JpaTestConfig.class})
public class TestConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}

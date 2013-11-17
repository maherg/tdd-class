package tdd.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceContext {

  @Bean
  public DataSource dataSource() {
    //Load these properties from a properties file, or get the datasource from JNDI
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost/test");
    dataSource.setUsername("root");
    return dataSource;
  }

}

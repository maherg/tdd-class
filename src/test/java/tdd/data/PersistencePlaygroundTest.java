package tdd.data;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class PersistencePlaygroundTest {

  @Autowired
  DataSource dataSource;

  @Test
  public void shouldFetch() throws Exception {
    JdbcTemplate template = new JdbcTemplate(dataSource);
    //play here
  }
}

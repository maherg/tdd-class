package tdd.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class PersistencePlaygroundTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void shouldFetch() throws Exception {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        RowMapper<Person> rowMapper = new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getInt("id"), rs.getString("name"));
            }
        };
        template.batchUpdate(new String[] { "CREATE TABLE people(ID INT PRIMARY KEY, NAME VARCHAR(255))",
                "INSERT INTO people VALUES (1, 'maher')" });
        
        Person user = template.queryForObject("SELECT * FROM people WHERE id = 1", rowMapper);
        
        assertThat(user, is(notNullValue()));
        assertThat(user.getName(), is(equalTo("maher")));
    }
}

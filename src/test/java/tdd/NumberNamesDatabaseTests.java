package tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tdd.data.PersistenceContext;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class NumberNamesDatabaseTests {

    @Autowired
    private NumberNameRepository repository;

    @Test
    public void shouldFetchSuccessfully() {
        String name = repository.nameOf(3);
        assertThat(name, is(equalTo("three")));
    }
}

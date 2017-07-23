package com.orange.flywaytest;

import com.orange.repository.UserRepository;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertTrue;

/**
 * Created by Karim on 7/19/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class FlywayTestApplicationTest {

    @Autowired
    UserRepository userRepository;

    @FlywayTest(invokeCleanDB = true)
    @Test
    public void cleanDBFlywayTest() throws Exception {
        assertTrue(userRepository.findAll() == null || userRepository.findAll().size() == 0);
    }

    @FlywayTest(invokeCleanDB = true,locationsForMigrate = {"/db/migration"})
    @Test
    public void flywayTest() throws Exception {
        assertTrue(userRepository.getByName("flyway test unit") != null);
    }
}

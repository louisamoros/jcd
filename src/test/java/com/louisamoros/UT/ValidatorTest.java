package com.louisamoros.UT;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Louis Amoros on 03/03/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValidatorTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  @Ignore
  public void validationEmptyFirstName() {
    expectedException.expect(IllegalArgumentException.class);
  }

  @Test
  @Ignore
  public void validationEmptyLastName() {
    expectedException.expect(IllegalArgumentException.class);
  }

}
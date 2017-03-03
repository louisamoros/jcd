package com.louisamoros.IT;

import com.jayway.restassured.RestAssured;
import com.louisamoros.TestApplicationContext;
import com.louisamoros.model.Developper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {TestApplicationContext.class})
public class DevelopperWSIT {

  @Value("${local.server.port}")
  private int port;

  /**
   * Setup.
   */
  @Before
  public void setUp() throws IOException {
    RestAssured.port = port;
    DevelopperWSClient client = new DevelopperWSClient("/developper", Developper.class);
  }

  @Test
  public void dumbTest() {
    Assert.assertTrue(Boolean.TRUE);
  }
}
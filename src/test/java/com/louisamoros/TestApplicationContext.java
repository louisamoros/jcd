package com.louisamoros;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author Louis Amoros on 03/03/17.
 */
@Import(ApiWebConfig.class)
public class TestApplicationContext extends SpringBootServletInitializer {
}
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description xml Configuration
 */
//Configuration class
@Configuration
@ImportResource(locations = {"bean.xml"})
public class ConfigClass {
}

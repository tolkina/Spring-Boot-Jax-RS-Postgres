package com.example.rest.config;

import com.example.rest.GenericExceptionMapper;
import com.example.rest.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserController.class);
        register(GenericExceptionMapper.class);
    }
}

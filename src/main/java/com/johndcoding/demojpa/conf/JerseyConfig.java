package com.johndcoding.demojpa.conf;

import com.johndcoding.demojpa.rest.TaskResource;
import com.johndcoding.demojpa.rest.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig  extends ResourceConfig {

    public JerseyConfig(){
        register(TaskResource.class);
        register(UserResource.class);
    }

}

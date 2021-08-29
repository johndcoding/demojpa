package com.johndcoding.demojpa.rest;

import com.johndcoding.demojpa.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(DemojpaApplication.class)
//@WebIntegrationTest(randomPort = true)

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void givenGelAllUsers_whenCorrectRequest_thenResponseOk(){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:"+this.port);


        Response response = target.path("/api/users").request().get();

        Assertions.assertEquals(200, response.getStatus());

        String strUsers = response.readEntity(String.class);

        System.out.println(strUsers);


        List<User> users = response.readEntity(new GenericType< List < User >>(){});

    }


}

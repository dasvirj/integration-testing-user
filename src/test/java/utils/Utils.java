package utils;

import fixtures.RequestInformations;
import fixtures.UserDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Utils {
    public static RequestSpecification getRequestSpecAPI() {
        return new RequestSpecBuilder()
                .setBaseUri(RequestInformations.url)
                .build();
    }
    public static UserDTO newUser(){
        UserDTO newUser = new UserDTO();
        newUser.setName("João");
        newUser.setUserName("Joaozinho");
        newUser.setEmail("joaozinho@example.com");
        return newUser;
    }
}
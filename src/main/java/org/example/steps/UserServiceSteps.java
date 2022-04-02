package org.example.steps;

import io.restassured.response.Response;
import org.example.entities.User;
import org.example.service.UserService;

import static org.example.service.uritemplate.UserServiceUri.*;

public class UserServiceSteps {
    private static final UserService USER_SERVICE = UserService.getInstance();

    public static User getUsersByUserName(String username) {
        return USER_SERVICE.getRequest(USER_BY_NAME, username).as(User.class);
    }

    public static Response login(String name, String password)
    {
        return USER_SERVICE.getRequest(USER_LOGIN);
    }

    public static Response logout()
    {
        return USER_SERVICE.getRequest(USER_LOGOUT);
    }

    public static Response createUser(User user) {
        return USER_SERVICE.postRequest(USER, user);
    }

    public static void deleteUserByName(String name) {
        USER_SERVICE.deleteRequest(USER_BY_NAME, name);
    }
}

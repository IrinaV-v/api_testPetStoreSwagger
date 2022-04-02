package org.example.userstest;

import io.restassured.response.Response;
import org.example.entities.User;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class UserServiceTest {

    User createdUser = createUser();

    @Test
    public void createUserTest() {
        Response createdUserResponse = UserServiceSteps.createUser(createdUser);
        Assert.assertEquals(createdUserResponse.getStatusCode(), 200,
                "Expected user doesn't have correct name");
    }


    @Test
    public void loginTest() {
        createUserTest();
        Response response = UserServiceSteps.login(createdUser.getUsername(), createdUser.getPassword());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void logoutTest() {
        loginTest();
        Response response = UserServiceSteps.logout();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getUsersByUserNameTest() {
        createUserTest();
        User user = UserServiceSteps.getUsersByUserName(createdUser.getUsername());
        Assert.assertEquals(user.getId(), createdUser.getId(),
                "users id is not correct");
        Assert.assertEquals(user.getFirstName(), createdUser.getFirstName(),
                "users name is not correct");
        Assert.assertEquals(user.getPassword(), createdUser.getPassword(),
                "users password is not correct");
    }

    @Test
    public void deleteUsersTest() {
        createUserTest();
        UserServiceSteps.deleteUserByName(createdUser.getUsername());
    }


    private User createUser() {
        Random random = new Random();
        User newUser = new User()
                .setId((int) Math.floor(Math.random() * (100 - 1 + 1) + 1))
                .setUsername("Ragnarok" + random.nextInt())
                .setFirstName("Ilya" + random.nextInt())
                .setLastName("Vasiliev" + random.nextInt())
                .setEmail("testEmail" + random.nextInt() + "@gmail.com")
                .setPassword("1234")
                .setPhone("123")
                .setUserStatus(1);
        return newUser;
    }
}
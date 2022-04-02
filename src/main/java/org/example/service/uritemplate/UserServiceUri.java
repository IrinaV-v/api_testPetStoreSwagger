package org.example.service.uritemplate;

public class UserServiceUri {
    public static final UriTemplate USER = new UriTemplate("user");
    public static final UriTemplate USER_BY_NAME = new UriTemplate("user/%s");
    public static final UriTemplate USER_LOGIN = new UriTemplate("user/login");
    public static final UriTemplate USER_LOGOUT = new UriTemplate("user/logout");
}

package com.marspc.goeaturself.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 86_400_000;// 24 hours in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String GO_EAT_URSELF = "GoEatUrself";
    public static final String GO_EAT_URSELF_ADMINISTRATION = "GoEatUrself Portal";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this resource";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    //public static final String[] PUBLIC_URLS = {"/auth/login", "auth/register", "/auth/reset-password/**"};
    public static final String[] PUBLIC_URLS = {"**"};
}

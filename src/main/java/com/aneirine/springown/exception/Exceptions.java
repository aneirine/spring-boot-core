package com.aneirine.springown.exception;

public class Exceptions {

   public class User {
        public static final String USER_NOT_FOUND = "{\r\n"
                + "  \"status\": 404,\r\n"
                + "  \"message\": \"USER_NOT_FOUND\"\r\n" + "}";

        public static final String LOGIN_ALREADY_EXISTS = "{\r\n"
                + "  \"status\": 409,\r\n"
                + "  \"message\": \"LOGIN_ALREADY_EXISTS\"\r\n" + "}";
    }
}

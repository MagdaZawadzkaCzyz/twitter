package com.sda.twitter.utils;

public class EnvironmentVariableUtil {
    // hibernate.connection.username
    // hibernate_connection_username
    public static String getVariable(String key) {
        return System.getenv(key.replace('.', '_'));
    }
}

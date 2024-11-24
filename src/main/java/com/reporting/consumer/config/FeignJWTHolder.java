package com.reporting.consumer.config;

// Stores value globally. ThreadLocal can be used if it is required to store values for each thread
public class FeignJWTHolder {
    private static String JWT_HOLDER = null;

    public static void setToken(String token) {
        JWT_HOLDER = token;
    }

    public static String getToken() {
        return JWT_HOLDER;
    }

    public static void clear() {
        JWT_HOLDER = null;
    }

}

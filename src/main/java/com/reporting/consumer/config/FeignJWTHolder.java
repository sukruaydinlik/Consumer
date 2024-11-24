package com.reporting.consumer.config;

public class FeignJWTHolder {
    private static final InheritableThreadLocal<String> JWT_HOLDER = new InheritableThreadLocal<>();

    public static void setToken(String token) {
        JWT_HOLDER.set(token);
    }

    public static String getToken() {
        return JWT_HOLDER.get();
    }

    public static void clear() {
        JWT_HOLDER.remove();
    }

}

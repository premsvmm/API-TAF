package com.premsvmm.services;

import com.google.gson.Gson;
import io.restassured.response.Response;

import java.lang.reflect.Type;

public class APIUtilities {
    private static Gson gson = new Gson();

    public static Object convertResponseToDto(Response response, Class className) {
        return gson.fromJson(response.getBody().asString(), className);
    }

    public static Object convertResponseToDto(Response response, Type type) {
        return gson.fromJson(response.getBody().asString(), type);
    }

    public static String convertDtoToJson(Object object) {
        return gson.toJson(object);
    }
}

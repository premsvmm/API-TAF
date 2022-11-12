package com.premsvmm.services;

import com.google.gson.Gson;
import io.restassured.response.Response;

public class APIUtilities {
    private static Gson gson = new Gson();

    public static Object convertResponseToDto(Response response, Class className) {
        return gson.fromJson(response.getBody().asString(), className);
    }

    public static String convertDtoToJson(Object object) {
        return gson.toJson(object);
    }
}

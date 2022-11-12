package com.premsvmm.exceptions;

import io.restassured.response.Response;

public class APIException extends Exception {
    private Response response;

    public APIException(String message) {
        super(message);
    }

    public APIException(Response response, String message) {
        super(message);
        this.response = response;
    }

}

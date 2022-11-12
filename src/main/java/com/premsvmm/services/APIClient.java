package com.premsvmm.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIClient {

    public Response executeRequest(HttpMethod httpMethod, APIRequestSpecification apiRequestSpecification) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        if (apiRequestSpecification.getBody() != null) {
            requestSpecBuilder.setBody(apiRequestSpecification.getBody());
        }

        if (apiRequestSpecification.getContentType() != null) {
            requestSpecBuilder.setContentType(apiRequestSpecification.getContentType());
        }
        return execute(apiRequestSpecification.getBaseUrl(), httpMethod, requestSpecBuilder.build());
    }

    private Response execute(String baseUrl, HttpMethod httpMethod, RequestSpecification requestSpecification) {
        Response response = null;
        switch (httpMethod) {
            case POST -> response = RestAssured.given().spec(requestSpecification).baseUri(baseUrl).when().post();
            case GET -> response = RestAssured.given().spec(requestSpecification).baseUri(baseUrl).when().get();
            default -> new Exception("Method not implemented");
        }
        return response;
    }
}

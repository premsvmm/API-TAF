package com.premsvmm.services;

import com.premsvmm.controllers.Authorization;
import io.restassured.http.ContentType;
import lombok.Data;

import java.util.Map;

@Data
public class APIRequestSpecification {
    private String baseUrl;
    private Map<String, Object> queryParams;
    private Map<String, String> formParams;
    private Authorization authorization;
    private Object body;
    private ContentType contentType;
}

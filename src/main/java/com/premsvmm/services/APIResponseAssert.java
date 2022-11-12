package com.premsvmm.services;

import com.premsvmm.exceptions.APIException;
import io.restassured.response.Response;

public class APIResponseAssert {

    public static void assertApiResponse(Response response, int expectedStatus) throws APIException {
        assertApiResponse(response, expectedStatus, null);
    }

    public static void assertApiResponse(Response response, int expectedStatus, String failureMsg) throws APIException {
        if (response.getStatusCode() != expectedStatus) {
            String errMsg = "API Response Failed, Status_Code: " + response.getStatusCode() + "\n" + response.getBody().prettyPrint();
            if (failureMsg != null)
                errMsg = errMsg + " ,Error: " + failureMsg;
            throw new APIException(response, errMsg);
        }
    }
}

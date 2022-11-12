package com.premsvmm.impls;

import com.premsvmm.controllers.Routes;
import com.premsvmm.dtos.users.UserRequestDto;
import com.premsvmm.dtos.users.UserResponseDto;
import com.premsvmm.services.APIClient;
import com.premsvmm.services.APIRequestSpecification;
import com.premsvmm.services.APIUtilities;
import com.premsvmm.services.HttpMethod;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;

public class UserImpl extends APIClient {

    public UserResponseDto createUser(ArrayList<UserRequestDto> userRequestDtos) {
        APIRequestSpecification.APIRequestSpecificationBuilder apiRequestSpecificationBuilder = APIRequestSpecification.builder();
        apiRequestSpecificationBuilder.body(APIUtilities.convertDtoToJson(userRequestDtos))
                .contentType(ContentType.JSON)
                .baseUrl(Routes.v2_POST_CREATE_WITH_ARRAY.PETSTORE());
        Response response = executeRequest(HttpMethod.POST, apiRequestSpecificationBuilder.build());
        return (UserResponseDto) APIUtilities.convertResponseToDto(response, UserResponseDto.class);
    }

    public UserResponseDto getUser(String userName) {
        APIRequestSpecification.APIRequestSpecificationBuilder apiRequestSpecificationBuilder = APIRequestSpecification.builder();
        apiRequestSpecificationBuilder
                .contentType(ContentType.JSON)
                .baseUrl(Routes.v2_GET_USER.PETSTORE(userName));
        Response response = executeRequest(HttpMethod.GET, apiRequestSpecificationBuilder.build());
        return (UserResponseDto) APIUtilities.convertResponseToDto(response, UserResponseDto.class);
    }
}

package com.premsvmm.impls;

import com.google.gson.reflect.TypeToken;
import com.premsvmm.controllers.Routes;
import com.premsvmm.dtos.pets.PetsRequestDTO;
import com.premsvmm.dtos.pets.PetsResponseDTO;
import com.premsvmm.enums.PetStatus;
import com.premsvmm.exceptions.APIException;
import com.premsvmm.services.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetsImpl extends APIClient {

    public PetsResponseDTO createPet(PetsRequestDTO requestDTO) throws APIException {
        APIRequestSpecification.APIRequestSpecificationBuilder apiRequestSpecificationBuilder = APIRequestSpecification.builder();
        apiRequestSpecificationBuilder.body(APIUtilities.convertDtoToJson(requestDTO))
                .contentType(ContentType.JSON)
                .baseUrl(Routes.v2_POST_PET.PETSTORE());
        Response response = executeRequest(HttpMethod.POST, apiRequestSpecificationBuilder.build());
        APIResponseAssert.assertApiResponse(response, 200);
        return (PetsResponseDTO) APIUtilities.convertResponseToDto(response, PetsResponseDTO.class);
    }

    public PetsResponseDTO updatePet(PetsRequestDTO requestDTO) throws APIException {
        APIRequestSpecification.APIRequestSpecificationBuilder apiRequestSpecificationBuilder = APIRequestSpecification.builder();
        apiRequestSpecificationBuilder.body(APIUtilities.convertDtoToJson(requestDTO))
                .contentType(ContentType.JSON)
                .baseUrl(Routes.v2_PUT_PET.PETSTORE());
        Response response = executeRequest(HttpMethod.PUT, apiRequestSpecificationBuilder.build());
        APIResponseAssert.assertApiResponse(response, 200);
        return (PetsResponseDTO) APIUtilities.convertResponseToDto(response, PetsResponseDTO.class);
    }

    public ArrayList<PetsResponseDTO> getPet(PetStatus petStatus) throws APIException {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("status", petStatus.name());
        APIRequestSpecification.APIRequestSpecificationBuilder apiRequestSpecificationBuilder = APIRequestSpecification.builder();
        apiRequestSpecificationBuilder
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .baseUrl(Routes.v2_GET_PET.PETSTORE());
        Response response = executeRequest(HttpMethod.GET, apiRequestSpecificationBuilder.build());
        APIResponseAssert.assertApiResponse(response, 200);
        Type type = new TypeToken<ArrayList<PetsResponseDTO>>() {
        }.getType();
        return (ArrayList<PetsResponseDTO>) APIUtilities.convertResponseToDto(response, type);
    }
}

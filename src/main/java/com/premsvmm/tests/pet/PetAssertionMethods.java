package com.premsvmm.tests.pet;

import com.premsvmm.dtos.pets.PetsRequestDTO;
import com.premsvmm.dtos.pets.PetsResponseDTO;
import com.premsvmm.enums.PetStatus;
import org.testng.asserts.SoftAssert;

public class PetAssertionMethods {

    public static void assertPet(PetsRequestDTO requestDTO, PetsResponseDTO responseDTO) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(requestDTO.getId(), responseDTO.getId());
        softAssert.assertEquals(requestDTO.getCategory(), responseDTO.getCategory());
        softAssert.assertEquals(requestDTO.getName(), responseDTO.getName());
        softAssert.assertEquals(requestDTO.getPhotoUrls(), responseDTO.getPhotoUrls());
        softAssert.assertEquals(requestDTO.getTags(), responseDTO.getTags());
        softAssert.assertEquals(requestDTO.getStatus(), responseDTO.getStatus());
        softAssert.assertAll();
    }

    public static void assertPet(PetsRequestDTO requestDTO, PetsResponseDTO responseDTO,PetStatus petStatus){
        requestDTO.setStatus(petStatus.name());
        assertPet(requestDTO,responseDTO);
    }
}

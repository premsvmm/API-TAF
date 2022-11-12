package com.premsvmm.tests.pettests;

import com.premsvmm.dtos.pets.PetsRequestDTO;
import com.premsvmm.dtos.pets.PetsResponseDTO;
import com.premsvmm.exceptions.APIException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.premsvmm.controllers.TestGroups.PET;

public class PetTest extends PetBase {

    @Test(enabled = true, alwaysRun = true, dataProviderClass = PetDataProvider.class, dataProvider = "CreateAndUpdatePetDataProvider", testName = "ValidateCreateAndUpdatePet", description = "Validate create and update user", groups = {PET})
    public void ValidateCreateAndUpdatePet(PetsRequestDTO requestDTO, ArrayList<PetsRequestDTO> update) throws APIException {
        PetsResponseDTO responseDTO = petsImpl.createPet(requestDTO);
        PetAssertionMethods.assertPet(requestDTO, responseDTO);
        updateAndValidatePet(responseDTO.getId(), update);
    }

}
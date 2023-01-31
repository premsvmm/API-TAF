package com.premsvmm.tests.pet;

import com.premsvmm.dtos.pets.PetsRequestDTO;
import com.premsvmm.dtos.pets.PetsResponseDTO;
import com.premsvmm.exceptions.APIException;
import com.premsvmm.services.APIUtilities;
import com.premsvmm.utils.utils;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.Iterator;

import static com.premsvmm.controllers.TestGroups.PET;

public class PetTest extends PetBase {

    @Test(enabled = true, alwaysRun = true, dataProviderClass = PetDataProvider.class, dataProvider = "CreateAndUpdatePetDataProvider", testName = "ValidateCreateAndUpdatePet", description = "Validate create and update user", groups = {PET})
    public void ValidateCreateAndUpdatePet(PetsRequestDTO requestDTO, ArrayList<PetsRequestDTO> update) throws APIException {
        PetsResponseDTO responseDTO = petsImpl.createPet(requestDTO);
        PetAssertionMethods.assertPet(requestDTO, responseDTO);
        updateAndValidatePet(responseDTO.getId(), update);
    }

    @Test(enabled = true, alwaysRun = true, testName = "SameResponseObjectAssert", description = "Same Object Assertion", groups = {PET})
    public void assertSameResponseObject() throws APIException {
        PetDataProvider obj = new PetDataProvider();
        Iterator<Object[]> inputIterator = obj.createPet();
        Object[] inputObj = inputIterator.next();
        PetsRequestDTO input = (PetsRequestDTO) inputObj[0];
        PetsResponseDTO responseDTO = petsImpl.createPet(input);
        input.setId(2l);
        utils.assertCommonObject(APIUtilities.convertDtoToMap(input), APIUtilities.convertDtoToMap(responseDTO));
    }

}
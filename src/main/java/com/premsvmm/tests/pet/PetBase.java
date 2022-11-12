package com.premsvmm.tests.pet;

import com.premsvmm.dtos.pets.PetsRequestDTO;
import com.premsvmm.dtos.pets.PetsResponseDTO;
import com.premsvmm.enums.PetStatus;
import com.premsvmm.exceptions.APIException;
import com.premsvmm.impls.PetsImpl;
import com.premsvmm.tests.BaseTests;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PetBase extends BaseTests {
    protected PetsImpl petsImpl;

    @BeforeClass(alwaysRun = true)
    public void initPetBase() {
        petsImpl = new PetsImpl();
    }

    protected Map<Long, PetsResponseDTO> convertGetPetResponseToMap(ArrayList<PetsResponseDTO> response) {
        Map<Long, PetsResponseDTO> map = new LinkedHashMap<>();
        for (PetsResponseDTO petsResponseDTO : response) {
            map.put(petsResponseDTO.getId(), petsResponseDTO);
        }
        return map;
    }


    protected void updateAndValidatePet(Long id, ArrayList<PetsRequestDTO> updateRequest) throws APIException {
        for (PetsRequestDTO petsRequestDTO : updateRequest) {
            PetsResponseDTO updatedPet = petsImpl.updatePet(petsRequestDTO);
            Map<Long, PetsResponseDTO> updateList = convertGetPetResponseToMap(petsImpl.getPet(PetStatus.valueOf(updatedPet.getStatus())));
            PetAssertionMethods.assertPet(petsRequestDTO, updateList.get(id), PetStatus.valueOf(updatedPet.getStatus()));
        }
    }
}

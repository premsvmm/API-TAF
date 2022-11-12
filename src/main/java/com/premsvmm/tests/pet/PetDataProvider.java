package com.premsvmm.tests.pet;

import com.premsvmm.dtos.pets.PetsBaseDTO;
import com.premsvmm.dtos.pets.PetsRequestDTO;
import com.premsvmm.enums.PetStatus;
import org.testng.annotations.DataProvider;

import java.util.*;

public class PetDataProvider {

    @DataProvider(name = "CreateAndUpdatePetDataProvider")
    public Iterator<Object[]> createPet() {
        List<Object[]> addToList = new LinkedList<>();

        PetsRequestDTO.PetsRequestDTOBuilder petCreate = PetsRequestDTO.builder();
        petCreate.id(01l)
                .category(new PetsBaseDTO.Category(01, "dog"))
                .name("scoobydoo")
                .photoUrls(new ArrayList<>(Arrays.asList("https://www.cdc.gov/healthypets/images/pets/cute-dog-headshot.jpg?_=42445")))
                .tags(new ArrayList<>(Arrays.asList(new PetsBaseDTO.Tags(01, "scooby"))))
                .status(PetStatus.available.name());


        ArrayList<PetsRequestDTO> updatePetList = new ArrayList<>();

        PetsRequestDTO.PetsRequestDTOBuilder updatePet = PetsRequestDTO.builder();
        updatePet.id(01l)
                .category(new PetsBaseDTO.Category(01, "dog"))
                .name("scoobydoo")
                .photoUrls(new ArrayList<>(Arrays.asList("https://www.cdc.gov/healthypets/images/pets/cute-dog-headshot.jpg?_=42445")))
                .tags(new ArrayList<>(Arrays.asList(new PetsBaseDTO.Tags(01, "scooby"))))
                .status(PetStatus.pending.name());
        updatePetList.add(updatePet.build());

        updatePet = PetsRequestDTO.builder();
        updatePet.id(01l)
                .category(new PetsBaseDTO.Category(01, "dog"))
                .name("scoobydoo")
                .photoUrls(new ArrayList<>(Arrays.asList("https://www.cdc.gov/healthypets/images/pets/cute-dog-headshot.jpg?_=42445")))
                .tags(new ArrayList<>(Arrays.asList(new PetsBaseDTO.Tags(01, "scooby"))))
                .status(PetStatus.sold.name());
        updatePetList.add(updatePet.build());

        addToList.add(new Object[]{petCreate.build(), updatePetList});
        return addToList.iterator();
    }


}

package com.epampets.domain.helper;

import com.epampets.domain.builder.PetBuilder;
import com.epampets.domain.client.PetClient;
import com.epampets.domain.entity.Pet;
import com.epampets.domain.response.ResponsePet;
import com.epampets.domain.utils.NumberGenerateHelper;

public class PetService {
    private PetClient petClient;
    private int petId;

    public PetService(PetClient petClient) {
        this.petClient = petClient;
    }

    public int create(Pet pet) {
        petClient.postPet(pet);
        return pet.id;
    }

    public int createPet() {
        petId = NumberGenerateHelper.getRandomPetId();
        Pet pet = new PetBuilder().withId(petId).build();
        return create(pet);
    }

    public int createPetWithName(String petName) {
        petId = NumberGenerateHelper.getRandomPetId();
        Pet pet = new PetBuilder().withId(petId).withName(petName).build();
        return create(pet);
    }

    public int createPetWithStatus(String petStatus) {
        petId = NumberGenerateHelper.getRandomPetId();
        Pet pet = new PetBuilder().withId(petId).withName("is" + petStatus).withStatus(petStatus).build();
        return create(pet);
    }

    public ResponsePet findPetWithId(int petId) {
        return petClient.getPetById(petId);
    }

    public void updatePetWithId(int petId) {
        Pet pet = new PetBuilder().withId(petId).withName("GasparUpdated").build();
        petClient.updatePet(pet);
    }

    public void deletePetWithId(int petId) {
        petClient.delete(petId);
    }

    public void uploadImageWithId(int petId) {
        petClient.uploadImage(petId);
    }

    public int getPetList(String status) {
        return petClient.getPetWithStatus(status);
    }

    public int getAllNumberOfPet() {
        return petClient.getAllPets();
    }

    public void updatePetNameWithId(int petId, String name){
        petClient.updatePetName(petId, name);
    }

    public void updatePetStatusWithId(int petId, String status){
        petClient.updatePetStatus(petId, status);
    }

    public void updatePetNameAndStatus(int petId, String name, String status){
        petClient.updateBothNameAndStatus(petId, name, status);
    }
}

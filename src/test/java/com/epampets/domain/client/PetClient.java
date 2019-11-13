package com.epampets.domain.client;
import com.epampets.core.configuration.ConfigParser;
import com.epampets.core.client.PetRestClient;
import com.epampets.domain.entity.Pet;
import com.epampets.domain.entity.PetStatus;
import com.epampets.domain.response.ResponsePet;

public class PetClient extends PetRestClient {
    private String url;

    public PetClient(){
        this.url = ConfigParser.getValue("BaseUrl");
    }

    public void postPet(Pet pet){
        post(url, pet);
    }

    public void updatePet(Pet pet) { put(url, pet);}

    public void updatePetName(int petId, String petName){
        postName(url + "/" + petId, petName);
    }

    public void updatePetStatus(int petId, String petStatus){
        postStatus(url + "/" + petId, petStatus);
    }

    public void updateBothNameAndStatus(int petId, String petName, String petStatus){
        postBothNameAndStatus(url + "/" + petId, petName, petStatus);
    }

    public ResponsePet getPetById(int petId){
        return get(url + "/" + petId);
    }

    public int getPetWithStatus(String status){
        return getList(url + "/findByStatus?status=" + status).size();
    }

    public int getAllPets(){
        return getList(url + "/findByStatus?status=" + PetStatus.available.name()
                + "&status=" + PetStatus.pending.name() + "&status=" + PetStatus.sold.name()).size();
    }

    public void delete(int petId){
        delete(url + "/" + petId);
    }

    public void uploadImage(int petId) {
        post(url + "/" + petId + "/uploadImage");}
}

package org.example.steps;

import io.restassured.response.Response;
import org.example.entities.Pet;
import org.example.service.PetService;

import static org.example.service.uritemplate.PetServiceUri.PET;
import static org.example.service.uritemplate.PetServiceUri.PET_BY_ID;

public class PetServiceSteps {
    private static final PetService PET_SERVICE = PetService.getInstance();


    public static Response getPetById(String petId) {
        return PET_SERVICE.getRequest(PET_BY_ID, petId);
    }

    public static Response addPet(Pet pet) {
        return PET_SERVICE.postRequest(PET, pet);
    }
    public static Response updatePet(Pet pet) {
        return PET_SERVICE.postRequest(PET_BY_ID, pet);
    }

    public static void deletePetById(String id) {
        PET_SERVICE.deleteRequest(PET_BY_ID, id);
    }

}

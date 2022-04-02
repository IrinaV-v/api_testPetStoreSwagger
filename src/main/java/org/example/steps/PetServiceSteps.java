package org.example.steps;

import io.restassured.response.Response;
import org.example.service.PetService;

import static org.example.service.uritemplate.StoreServiceUri.STORE_ORDER;
import static org.example.service.uritemplate.StoreServiceUri.STORE_ORDER_BY_ID;

public class PetServiceSteps {
    private static final PetService PET_SERVICE = PetService.getInstance();


    public static Response getPetById(String petId) {
        return PET_SERVICE.getRequest(STORE_ORDER_BY_ID, petId);
    }

    public static Response AddPet(String pet) {
        return PET_SERVICE.postRequest(STORE_ORDER, pet);
    }

    public static void deletePetById(String id) {
        PET_SERVICE.deleteRequest(STORE_ORDER_BY_ID, id);
    }
}

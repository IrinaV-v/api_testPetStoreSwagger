package org.example.userstest;

import io.restassured.response.Response;
import org.example.entities.Pet;
import org.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PetServiceTest {
    Pet createdPet = createPet();

    @Test
    public void addPetTest() {
        Response expectedPet = PetServiceSteps.addPet(createdPet);
        Assert.assertEquals(expectedPet.getStatusCode(), 200,
                "pet was not added");
    }

    @Test
    public void deletePetTest() {
        addPetTest();
        PetServiceSteps.deletePetById(String.valueOf(createdPet.getId()));
        Assert.assertEquals(getPetById().getStatusCode(), 404,
                "pet has not been deleted");
    }

    @Test
    public void updatePetTest() {
        addPetTest();
        Pet update = createPetUpdate();
        Assert.assertEquals(PetServiceSteps.updatePet(update).getStatusCode(), 200,
                "pet was not updated");
        Assert.assertEquals(getPetById().as(Pet.class).getName(), "Nemira",
                "name is not updated");
    }

    public Response getPetById() {
        return PetServiceSteps.getPetById(String.valueOf(createdPet.getId()));
    }

    private Pet createPetUpdate() {
        return new Pet().setId(1).
                setName("Nemira").
                setStatus("available");
    }


    private Pet createPet() {
        String[] ar = new String[]{"string"};
        return new Pet().setId(1).
                setName("Bobik").
                setPhotoUrls(ar).
                setStatus("available");
    }

}

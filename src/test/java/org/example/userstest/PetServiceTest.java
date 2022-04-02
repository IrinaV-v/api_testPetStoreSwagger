package org.example.userstest;

import io.restassured.path.json.JsonPath;
import org.example.entities.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetServiceTest {
    String body = Pet.getPet();

    @Test
    public void addPetTest() {
        String postResponse = given().log().all().
                header("Content-Type", "application/json").
                body(body).
                when().post("https://petstore.swagger.io/v2/pet").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
    }

    @Test
    public void deletePetTest() {
        addPetTest();
        String deleteResponse = given().log().all().
                when().post("https://petstore.swagger.io/v2/pet/101").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
    }


    @Test
    public void getPetById() {
        addPetTest();
        String getResponse = given().log().all().
                header("Content-Type", "application/json").
                body(body).
                when().get("https://petstore.swagger.io/v2/pet/101").
                then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(getResponse);
        String name = js.getString("name");
        Assert.assertEquals(name, "Sarancha",
                "name is not as expected");
    }


}

package org.example.userstest;

import io.restassured.response.Response;
import org.example.entities.Store;
import org.example.steps.StoreServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class StoreServiceTest {

    Store createdOrder = createOrder();

    @Test
    public void createOrderTest() {
        Store expectedOrder = StoreServiceSteps.createOrder(createdOrder);
        Assert.assertEquals(getOrderTest().getStatusCode(), 200,
                "Order has not been added");
        Assert.assertEquals(createdOrder.getId(), expectedOrder.getId(),
                "Expected order doesn't have correct id");
        Assert.assertEquals(createdOrder.getShipDate(), expectedOrder.getShipDate(),
                "Expected order doesn't have correct shipDate");
    }


    @Test
    public void deleteOrderTest() {
        createOrderTest();
        StoreServiceSteps.deleteOrderById(String.valueOf(createdOrder.getId()));
        Assert.assertEquals(getOrderTest().getStatusCode(), 404,
                "Incorrect request");
    }


    private Store createOrder() {
        Random random = new Random();
        return new Store()
                .setId(1)
                .setPetId(1)
                .setQuantity(1)
                .setShipDate("2022-04-01T18:42:55.000+0000")
                .setStatus("placed")
                .setComplete(true);
    }

    public Response getOrderTest() {
        return StoreServiceSteps.getOrder(createdOrder.getPetId());
    }
}


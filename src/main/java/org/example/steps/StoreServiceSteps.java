package org.example.steps;

import io.restassured.response.Response;
import org.example.entities.Store;
import org.example.entities.User;
import org.example.service.StoreService;
import org.example.service.UserService;

import java.util.List;

import static org.example.service.uritemplate.StoreServiceUri.STORE_ORDER;
import static org.example.service.uritemplate.StoreServiceUri.STORE_ORDER_BY_ID;


public class StoreServiceSteps {
    private static final StoreService STORE_SERVICE = StoreService.getInstance();

    public static Response getOrder(int petId) {
        return STORE_SERVICE.getRequest(STORE_ORDER_BY_ID, petId);
    }

    public static Store createOrder(Store store) {
        return STORE_SERVICE.postRequest(STORE_ORDER, store).as(Store.class);
    }

    public static void deleteOrderById(String id) {
        STORE_SERVICE.deleteRequest(STORE_ORDER_BY_ID, id);
    }
}

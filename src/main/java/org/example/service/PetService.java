package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class PetService extends CommonService{

    private static PetService instance;

    public static PetService getInstance() {
        if (instance == null) {
            instance = new PetService();
        }
        return instance;
    }

    public Response getRequest(UriTemplate uri, String id) {
        return super.getRequest(uri.getUri(id));
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public void deleteRequest(UriTemplate uri, String id) {
        super.deleteRequest(uri.getUri(id));
    }
}

package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.example.log.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class CommonService {
    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    private final Function<String, String> prepareUri = uri -> String.format("%s%s", BASE_URI, uri);

    protected RequestSpecification requestSpecification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        this.requestSpecification = RestAssured.given().auth().oauth2("fe2a7801b80136b54cfb3bb31b3dbed8b3bfdf7885fe4fc125e0acf5420af522");
        setCommonParams();
    }

    protected void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        requestSpecification.headers(headers);
    }

    protected Response getRequest(String uri) {
        return requestSpecification.expect()
                .when().get(prepareUri.apply(uri));
    }

    protected Response postRequest(String uri, Object body) {
        return requestSpecification.body(body)
                .when().post(prepareUri.apply(uri));
    }

    protected Response postRequestUpdate(String uri,String body) {
        return requestSpecification.body(body)
                .when().post(prepareUri.apply(uri));
    }

    protected void deleteRequest(String uri) {
        requestSpecification.expect()
                .when().delete(prepareUri.apply(uri));
    }
}

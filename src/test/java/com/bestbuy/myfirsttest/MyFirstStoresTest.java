package com.bestbuy.myfirsttest;

import com.bestbuy.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyFirstStoresTest extends StoresTestBase {
    @Test
    public void getAllStoresInfo(){
        Response response= given()
                .when()
                .get("/stores");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}

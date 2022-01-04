package com.bestbuy.bestbuyinfo.storesinfo;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPatchStoresTest extends StoresTestBase {
    @Test
    public void updatesAStoreBasedOnStoreId() {

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setCity("London");

        Response response = given()
                .header("Content-Type","application/json")
                .pathParam("id",14)
                .body(storesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

}
}

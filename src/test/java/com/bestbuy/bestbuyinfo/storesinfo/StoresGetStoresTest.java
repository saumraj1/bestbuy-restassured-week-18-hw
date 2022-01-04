package com.bestbuy.bestbuyinfo.storesinfo;

import com.bestbuy.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoresGetStoresTest extends StoresTestBase {
    @Test
    public void getAllStoresInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStoresInfo() {
        Response response = given()
                .pathParam("id", 6)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStoresByType() {

        Response response = given()
                .pathParam("id", 8923)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }

//    @Test
//    public void searchStoreWithParameter(){
//    HashMap<String> qParams= new HashMap<>();
//    qParams.put("programme" ,"Financial Analysis");
//
//
//    Response response = given()
//            /*   .queryParam("programme" ,"Financial Analysis") // all
//               .queryParam("limit" ,2)*/ // two id list
//            .queryParams(qParams)
//            .when()
//            .get("/{id}");
//    response.then().statusCode(200);
//    response.prettyPrint();
//
//}


}
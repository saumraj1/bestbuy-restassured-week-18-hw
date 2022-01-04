package com.bestbuy.bestbuyinfo.storesinfo;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPostStoresTest extends StoresTestBase {
    @Test
    public void createNewStores(){
        StoresPojo storesPojo= new StoresPojo();

        storesPojo.setName("Minneto");
        storesPojo.setType("Bigbox ");
        storesPojo.setAddress("13 Ridge");
        storesPojo.setAddress2("Mession");
        storesPojo.setCity("Holland");
        storesPojo.setState("NM");
        storesPojo.setZip("66063");
        storesPojo.setLat(54.69);
        storesPojo.setLng(-93.44);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
/* "id": 4,
      "name": "Minnetonka",
      "type": "BigBox",
      "address": "13513 Ridgedale Dr",
      "address2": "",
      "city": "Hopkins",
      "state": "MN",
      "zip": "55305",
      "lat": 44.969658,
      "lng": -93.449539,
      "hours": "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8",*/
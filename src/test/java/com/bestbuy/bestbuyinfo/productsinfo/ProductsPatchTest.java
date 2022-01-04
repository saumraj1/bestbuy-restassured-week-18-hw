package com.bestbuy.bestbuyinfo.productsinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductsPatchTest extends ProductsTestBase {
    @Test
    public void updatesofProducts() {
        ProductPojo productPojo = new ProductPojo();
//999981
        //  "name": "Power Walk- AAA Battery(4 -Pack)"
        // "type": "Holland"
       // productPojo.setName("Pomo Wali -AAA Battery(4 -Pack)");
       //  productPojo.setType("Polland");
          String bodyData= "{\n \"name\": \"Pomo Wali - AAA Battery(4-Pack)\",\n \"type\" :\"Polland\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 9999681)
                .body(bodyData)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void patchOfProducts() {
        ProductPojo productPojo = new ProductPojo();
        // "name": "Power Walk- AAA Battery(4 -Pack)",
        //       "type": "Holland",
   productPojo.setName("MoTo Wala -AAA Battery(4 -Pack)");
   productPojo.setType("Polland");

   Response response = given()
           .header("Content-Type","application/json")
           .pathParam("id",9999680)
           .when()
           .patch("/{id}");
   response.then().statusCode(200);
   response.prettyPrint();

    }
}

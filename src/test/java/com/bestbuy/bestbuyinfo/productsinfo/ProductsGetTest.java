package com.bestbuy.bestbuyinfo.productsinfo;

import com.bestbuy.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;



import static io.restassured.RestAssured.given;

public class ProductsGetTest extends ProductsTestBase {
    @Test
    public void getallProductInfo(){
        Response response =given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleProductInfo(){
        Response response = given()
                .pathParam("id",43900)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}

package com.bestbuy.bestbuyinfo.productsinfo;

import com.bestbuy.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsDeleteTest extends ProductsTestBase {
    @Test
    public void productOfDelete(){
        Response response = given()
                .pathParam("id",346646)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();


    }
}

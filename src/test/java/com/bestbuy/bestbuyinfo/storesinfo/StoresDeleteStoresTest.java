package com.bestbuy.bestbuyinfo.storesinfo;

import com.bestbuy.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;



import static io.restassured.RestAssured.given;

public class StoresDeleteStoresTest extends StoresTestBase {
    @Test
    public void deleteASinglebasedOnTheID(){
        Response response = given()
                .pathParam("id",8923)
                .when()
               .delete("/{id}");
      response.then().statusCode(204);
      response.prettyPrint();


    }
}

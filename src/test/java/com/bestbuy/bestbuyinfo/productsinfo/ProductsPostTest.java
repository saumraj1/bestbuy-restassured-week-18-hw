package com.bestbuy.bestbuyinfo.productsinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductsPostTest extends ProductsTestBase {
    @Test
    public void createNewProducts(){
        ProductPojo productPojo= new ProductPojo();

        productPojo.setName("Power Walk- AAA Battery(4 -Pack)");
        productPojo.setType("Holland");
        productPojo.setPrice(5.49);
        productPojo.setUpc("256323");
        productPojo.setShipping(2365);
        productPojo.setDescription("Compatible electronic devices; BAB size; DURALOCK Power Preserve technology; 4-pack");
        productPojo.setManufacturer("DurgaCell");
        productPojo.setModel("nm2400Z4B");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        Response response = given()
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }


}

/*"id": 43900,
      "name": "Duracell - AAA Batteries (4-Pack)",
      "type": "HardGood",
      "price": 5.49,
      "upc": "041333424019",
      "shipping": 0,
      "description": "Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack",
      "manufacturer": "Duracell",
      "model": "MN2400B4Z",
      "url": "http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC",
      "image": "http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg",
      "createdAt": "2016-11-17T17:58:03.298Z",
      "updatedAt": "2016-11-17T17:58:03.298Z",
       Response response = given()
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();*/

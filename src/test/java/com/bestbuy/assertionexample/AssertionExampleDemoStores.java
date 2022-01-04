package com.bestbuy.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;

/*Assert the following:
1. Verify the if the total is equal to 1561
2. Verify the if the stores of limit is equal to 10
3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
5. Verify the storied=7 inside storeservices of the third store of second services
6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
7. Verify the state = MN of forth store
8. Verify the store name = Rochester of 9th store
9. Verify the storeId = 11 for the 6th store
10. Verify the serviceId = 4 for the 7th store of forth service
*/

public class AssertionExampleDemoStores {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }


    // 1) Verify that the products of limit is equal to 10
    @Test
    public void test001() {
        response.body("limit", equalTo(10));

    }

    // 2) Verify that the products of total is = 5161
    @Test
    public void test002() {
        //homework
        response.body("total", equalTo(1561));
    }

    //Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void test003() {
        response.body("data.name", hasItem("Inver Grove Heights"));

    }

    // Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void test004() {
        //Homework
        response.body("data.name", hasItems("Roseville", "Burnsville", "Maplewood"));
    }

    //Verify the storied=7 inside storeservices of the third store of second services
    @Test
    public void test005() {
        response.body("data[1].services[1].storeservices", hasEntry("storeId", 7));

    }

     //response.body("data[2].services[1].storeservices",hasEntry("createdAt","2016-11-17T17:57:09.417Z"));
     //$.data.[1].services[*].storeservices.createdAt
     //Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville

    @Test
    public void test006() {
        response.body("data[1].services[1].storeservices", hasEntry("createdAt", "2016-11-17T17:57:09.417Z"));
    }

    //$.data[0].state
//Verify the state = MN of sixth store
    // 7) Checking multiple values in the same statement
    //response.body("data[0]",hasEntry("state","MN"));
    @Test
    public void test007() {
       // response.body("data[0]", hasEntry("state", "MN"));
        response.body("data[0]",hasEntry("state","MN"));


        // .body("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}", hasItem(hasEntry("manufacturer", "Energizer")))
        //  .body("data[0]", hasKey("state"));
    }
    //$.data[3].name
    //verify the store name = Maplewood of 10th store
        //Verify the store name = Rochester of 9th store
         @Test
        public void test008 () {
             List<String> address = response.extract().path("data.findAll{it.name=='Burnsville'}.address");

            // response.body("data[2]", hasEntry("name", "Maplewood"));

        }
        //Verify the storeId = 11 for the 6th store
    //$.data[4].services[1].storeservices.storeId
        @Test
        public void test009(){

            response.body("data[4].services[1].storeservices",hasEntry("storeId",11));

        }
        //Verify the serviceId = 4 for the 7th store of forth service
    //$.data[1].services[3].storeservices.serviceId
        @Test
        public void test0010(){
            response.body("data[1].services[3].storeservices",hasEntry("serviceId",4));

        }

    }


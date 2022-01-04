package com.bestbuy.extractingresponsedata;

import gherkin.deps.com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.objects.annotations.Where;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
/*1. Extract the limit
2. Extract the total
3. Extract the name of 5th store
4. Extract the names of all the store
5. Extract the storeId of all the store
6. Print the size of the data list
7. Get all the value of the store where store name = St Cloud
8. Get the address of the store where store name = Rochester
9. Get all the services of 8th store
10. Get storeservices of the store where service name = Windows Store
11. Get all the storeId of all the store
12. Get id of all the store
13. Find the store names Where state = ND
14. Find the Total number of services for the store where store name = Rochester
15. Find the createdAt for all services whose name = “Windows Store”
16. Find the name of all services Where store name = “Fargo”
17. Find the zip of all the store
18. Find the zip of store name = Roseville
19. Find the storeservices details of the service name = Magnolia Home Theater
20. Find the lat of all the store */


public class SearchjsonPathExampleStores {

    private static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    // 1) Extract the value of limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2.Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total name is : " + new GsonBuilder().setPrettyPrinting().create().toJson(total));
        System.out.println("------------------End of Test---------------------------");
    }

    // 3.Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + new GsonBuilder().setPrettyPrinting().create().toJson(name));
        //System.out.println("The name of 5th store : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
// 4.Extract the names of all the store
// System.out.println("The first product name is : "+ new GsonBuilder().setPrettyPrinting().create().toJson(storeId));

    @Test
    public void test004() {
        List<String> allStores = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all store : " + new GsonBuilder().setPrettyPrinting().create().toJson(allStores));
        //System.out.println("The name of all store : " + allStores);
        System.out.println("------------------End of Test---------------------------");
    }

    // 5.Extract the storeId of all the store
    @Test
    public void test005() {
        List<String> storeId = response.extract().path("data.services.storeservices.storeId");


        System.out.println("------------------StartingTest---------------------------");

        //System.out.println("List of Ids are : " + idList);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6.Print the size of the data list
    // List<String> dataList=response.extract().path("data");
    @Test
    public void test006() {
        List<Integer> dataList = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The List of size are : " + new GsonBuilder().setPrettyPrinting().create().toJson(dataList.size()));
        //System.out.println("List of size are : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 7.Get all the value of the store where store name = St Cloud
    //$.data[*].name
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The List of size are : " + new GsonBuilder().setPrettyPrinting().create().toJson(values));
        //System.out.println("The values for product name 'St Cloud' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8.Get the address of the store where store name = Rochester/Maplewood/id-10/ "1795 County Rd D E"
    //$.data[3].address

    @Test
    public void test008() {
        List<String> listAddress = response.extract().path("data.findAll{it.name=='Maplewood'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("address of the store name 'Maplewood' is : " + new GsonBuilder().setPrettyPrinting().create().toJson(listAddress));
        System.out.println("------------------End of Test---------------------------");
    }

    //9.Get all the services of 8th store
    //List<String> service = response.extract().path("data[7].services");
    //$.data[7].services
    @Test
    public void test009() {
        List<String> listService = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store are : " + new GsonBuilder().setPrettyPrinting().create().toJson(listService));
        System.out.println("------------------End of Test---------------------------");
    }

    // 10. Get storeservices of the store where service name = Windows Store
    // $.data[0].services[7].name
    //List<String> service = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");
    @Test
    public void test0010() {
        List<String> service = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The List of size are : " + new GsonBuilder().setPrettyPrinting().create().toJson(service));
        //System.out.println("The values for product name 'St Cloud' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 11. Get all the storeId of all the store
    //List<String> id = response.extract().path("data.findAll{it.name}.id");
    // $.data[*].services[*].storeservices.storeId
    @Test
    public void test0011() {
        List<HashMap<Integer, ?>> storeId = response.extract().path("data.services.findAll{it.storeservices}.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store are : " + new GsonBuilder().setPrettyPrinting().create().toJson(storeId));
        System.out.println("------------------End of Test---------------------------");
    }

    // 12.Get id of all the store
    // List<String> id = response.extract().path("data.id");
    // $.data[*].id
    @Test
    public void test0012() {
        List<String> id = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all stores Id are : " + new GsonBuilder().setPrettyPrinting().create().toJson(id));
        System.out.println("------------------End of Test---------------------------");
    }

    // 13. Find the store names Where state = ND
    // List<String> names = response.extract().path("data.findAll{it.state=='ND'}.name");
    // $.data[6].state
    @Test
    public void test0013() {
        List<String> name = response.extract().path("data.findAll{it.state== 'ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names ,state are : " + new GsonBuilder().setPrettyPrinting().create().toJson(name));
        System.out.println("------------------End of Test---------------------------");
    }

    // 14. Find the Total number of services for the store where store name = Rochester

    // 15. Find the createdAt for all services whose name = “Windows Store”
    // List<String> name = response.extract().path("data.findAll{it.name=='Windows Store'}.createdAt");

    @Test
    public void test0015() {
        List<String> name = response.extract().path("data.findAll{it.name == 'Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the createAt for all sevices name 'Windows Store' : " + new GsonBuilder().setPrettyPrinting().create().toJson(name));
        System.out.println("------------------End of Test---------------------------");
    }
    // 16. Find the name of all services Where store name = “Fargo”
    // 16.List<String> names = response.extract().path("data.findAll{it.name=='Fargo'}.services");

    @Test
    public void test0016() {
        List<String> names = response.extract().path("data.findAll{it.name == 'Fargo'}.services.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the name of all sevices  store name 'Fargo' : " + new GsonBuilder().setPrettyPrinting().create().toJson(names));
        System.out.println("------------------End of Test---------------------------");
    }
    // 17. Find the zip of all the store
    // List<String> names = response.extract().path("data.findAll{it.name}.zip");

    @Test
    public void test0017() {
        List<String> names = response.extract().path("data.findAll{it.name}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the zip of all store name: " + new GsonBuilder().setPrettyPrinting().create().toJson(names));
        System.out.println("------------------End of Test---------------------------");
    }
    // 18. Find the zip of store name = Roseville
    // List<String> names = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

    @Test
    public void test0018() {
        List<String> names = response.extract().path("data.findAll{it.name== 'Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the zip of store name 'Roseville': " + new GsonBuilder().setPrettyPrinting().create().toJson(names));
        System.out.println("------------------End of Test---------------------------");
    }
    // 19. Find the storeservices details of the service name = Magnolia Home Theater
    // List<String> names = response.extract().path("data.findAll{it.name=='Magnolia Home Theater'}.services");

    @Test
    public void test0019() {
        List<String> names = response.extract().path("data.findAll{it.name== 'Magnolia Home Theater'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the storeservices of service name 'Magnolia Home Theater': " + new GsonBuilder().setPrettyPrinting().create().toJson(names));
        System.out.println("------------------End of Test---------------------------");
    }

    // 20. Find the lat of all the store
    // List<Integer> lat = response.extract().path("data.lat");
    @Test
    public void test0020() {
        List<Integer> names = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the lat of all the store : " + new GsonBuilder().setPrettyPrinting().create().toJson(names));
        System.out.println("------------------End of Test---------------------------");
    }
}
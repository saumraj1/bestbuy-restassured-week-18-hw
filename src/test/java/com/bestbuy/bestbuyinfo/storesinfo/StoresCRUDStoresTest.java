package com.bestbuy.bestbuyinfo.storesinfo;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.StoresTestBase;
import gherkin.deps.com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoresCRUDStoresTest extends StoresTestBase {
    static String name="Minnetonk";
    static String type="iPhone";
    static String address="kenton",address2="hergaroad",city="London",state="London",hours ="Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";
    static String zip="HA5 2SA";
    static double lat=44.969658;
    static double lng=-93.449539;
    static Integer storeId;

    @Test
    public void test001() {

       StoresPojo storePojo = new StoresPojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
//    static String s1= "data.findAll{it.name=='"+name+"'}.id";

    @Test
    public void test002(){
        String s1= "data.findAll{it.name='";
        String s2="'}.get(0)";

        HashMap<String, Object> value=
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(s1+name+s2);
//        System.out.println(value);
        storeId =(Integer) value.get("id");
        System.out.println("StoreId:"+storeId);

    }


    @Test
    public void test003() {
        String p1 = "data.findAll{it.id='";
        String p2 = "'}.get(0)";

        name = name + "_updated";
        type = type + "_updated";
        address = address2 + "_updated";
        address2 = address2 + "_updated";

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("sId", storeId)
                .body(storesPojo)
                .when()
                .put("/{sId}");
        response.then().log().all().statusCode(200);

        HashMap<String, Object> value =
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + storeId + p2);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
    }
    @Test
    public void test004() {

        Response response = given()
                .pathParam("storeID", storeId)
                .when()
                .delete("/{storeID}");
        response.then().statusCode(200);
        response.prettyPrint();

        Response response1 =
                given()
                        .pathParam("storeID", storeId)
                        .when()
                        .get("/{storeID}");
        response1.then().statusCode(404);
    }




}
/*static String name = "prime testing"+TestUtils.getRandomValue();
    static String type = "IT Academy";
    static String address = "12 london Road";
    static String address2 = "lamda street";
    static String city ="coventry";
    static String state ="West midland";
    static String zip ="cv3 2np";
    static int lat = 3;
    static int lng = 2;
    static String hours ="mon to fri :9 to 5";
//8928
*/
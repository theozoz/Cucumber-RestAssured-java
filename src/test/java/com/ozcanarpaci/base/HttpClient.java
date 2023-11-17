package com.ozcanarpaci.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.ozcanarpaci.base.BaseConstant.BASE_URL;
import static io.restassured.RestAssured.given;

public class HttpClient {


    public static Response get(HashMap<String, Object> map) {
        return given()
                .baseUri(BASE_URL)
                .queryParams(map)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                //log().body()
                .extract().response();
    }



    /*
    public static Response get(String baseurl,String path) {
        return given()
                .log().all()
                .baseUri(baseurl)
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }


    public static Response get(String baseurl,String path, Header header) {

        return given()
                .log().all()
                .baseUri(baseurl)
                .contentType(ContentType.JSON)
                .header(header)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response post(String baseurl,Object body, String path) {
        return given()
                .log().all()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(path)
                .then()
                .log().body()
                .extract().response();
    }

     */

}

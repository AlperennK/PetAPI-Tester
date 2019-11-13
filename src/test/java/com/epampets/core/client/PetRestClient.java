package com.epampets.core.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import com.epampets.domain.entity.Pet;
import com.epampets.domain.response.ResponsePet;
import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetRestClient {
    public PetRestClient(){
//        RequestSpecification requestSpecification= new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
//        RestAssured.requestSpecification=requestSpecification;


    }
    protected boolean post(String url, Object body){
        return given().log().all().accept("application/json").contentType("application/json").body(body).when().post(url).getStatusCode() == HttpStatus.SC_OK;
    }

    protected boolean postName(String url, String petName){
        return given().log().all().accept("application/json").contentType(" application/x-www-form-urlencoded").formParam("name", petName).when().post(url).getStatusCode() == HttpStatus.SC_OK;
    }

    protected boolean postStatus(String url, String petStatus){
        return given().log().all().accept("application/json").contentType(" application/x-www-form-urlencoded").formParam("status",petStatus ).when().post(url).getStatusCode() == HttpStatus.SC_OK;
    }

    protected boolean postBothNameAndStatus(String url, String petName, String petStatus){
        return given().accept("application/json").contentType(" application/x-www-form-urlencoded").formParam("name", petName).formParam("status",petStatus ).when().post(url).getStatusCode() == HttpStatus.SC_OK;

    }

    protected boolean post(String url){
        return given().accept("application/json").header("Content-Type", "multipart/form-data").when().multiPart("file", new File(System.getProperty("user.dir") + "/src/test/resources/file/gaspar.jpeg")).post(url).getStatusCode() == HttpStatus.SC_OK;
    }

    protected ResponsePet get(String url){
        return given().accept("application/json").contentType("application/json").when().get(url).getBody().as(ResponsePet.class);
    }

    protected boolean put(String url, Pet pet){
        return given().accept("application/json").contentType("application/json").body(pet).when().put(url).getStatusCode() ==  HttpStatus.SC_OK;
    }

    protected List<Pet> getList(String url){
        return given().contentType("application/json").when().get(url).getBody().jsonPath().get();
    }

    protected boolean delete(String url){
        return given().contentType("application/json").when().delete(url).getStatusCode() == HttpStatus.SC_OK;
    }

}

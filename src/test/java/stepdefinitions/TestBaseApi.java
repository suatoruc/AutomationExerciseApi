package stepdefinitions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class TestBaseApi {
    protected RequestSpecification spec;
    public void setup(){
        spec=new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }





}

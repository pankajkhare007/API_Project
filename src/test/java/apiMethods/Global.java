package apiMethods;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class Global {

    public static RequestSpecBuilder requestSpecBuilder;
    public static String authKey;
    public static RequestSpecification requestSpecification;
    public static ResponseSpecBuilder responseSpecBuilder;
    public static ResponseSpecification responseSpecification;
    public static Response response;
    public static HashMap<String,Object> payload = new HashMap<>();
    public static HashMap<String,String> nestedObject = new HashMap<>();




    public static String baseURI = "https://restful-booker.herokuapp.com";
}

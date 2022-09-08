package apiMethods;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class Common {

    public static RequestSpecBuilder createRequest(String basePath)
    {
        Global.requestSpecBuilder = new RequestSpecBuilder();
        Global.requestSpecBuilder.setBaseUri(Global.baseURI);
        Global.requestSpecBuilder.setBasePath(basePath);
        Global.requestSpecBuilder.addHeader("Cookie","token="+Global.authKey);
        Global.requestSpecBuilder.addHeader("Content-Type","application/json");
        return Global.requestSpecBuilder;
    }
    public static RequestSpecification createFinalRequest()
    {
       Global.requestSpecification= Global.requestSpecBuilder.build();
       return Global.requestSpecification;
    }

    public static ResponseSpecBuilder createResponse()
    {
        Global.responseSpecBuilder = new ResponseSpecBuilder();
        return Global.responseSpecBuilder;
    }

    public static ResponseSpecification createFinalResponse()
    {
        Global.responseSpecification=Global.responseSpecBuilder.build();
        return Global.responseSpecification;
    }
    public static Response finalExecution(String methodType)
    {
        if(methodType.equals("get"))
        {
            Global.response=given().spec(Global.requestSpecification).get().then().spec(Global.responseSpecification).extract().response();
        }
        else if(methodType.equals("post"))
        {
            Global.response=given().spec(Global.requestSpecification).post().then().spec(Global.responseSpecification).extract().response();
        }
        else if(methodType.equals("patch"))
        {
            Global.response=given().spec(Global.requestSpecification).patch().then().spec(Global.responseSpecification).extract().response();
        }
        else if(methodType.equals("delete"))
        {
            Global.response=given().spec(Global.requestSpecification).delete().then().spec(Global.responseSpecification).extract().response();
        }
        return Global.response;
    }

    public static void createBody(String key,Object value)
    {
        Global.payload.put(key,value);
    }
    public static void createSubBody(String key, String value)
    {
        Global.nestedObject.put(key,value);
    }

    public static void addBody()
    {
        Global.requestSpecBuilder.setBody(Global.payload);
    }
}

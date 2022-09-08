package apiMethods;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class AuthKeys {

    static RequestSpecBuilder requestSpecBuilderForAuth;
    static RequestSpecification requestSpecificationForAuth;
    static ResponseSpecBuilder responseSpecBuilderForAuth;
    static ResponseSpecification responseSpecificationForAuth;
    public static String getAuthKey()
    {
        HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("username", "admin");
        payload.put("password", "password123");
        requestSpecBuilderForAuth = new RequestSpecBuilder();
        requestSpecBuilderForAuth.setBaseUri(Global.baseURI);
        requestSpecBuilderForAuth.setBasePath("/auth");
        requestSpecBuilderForAuth.setContentType("application/json");
        requestSpecBuilderForAuth.setBody(payload);
        requestSpecificationForAuth=requestSpecBuilderForAuth.build();
        responseSpecBuilderForAuth = new ResponseSpecBuilder();
        responseSpecBuilderForAuth.expectStatusCode(200);
        responseSpecificationForAuth = responseSpecBuilderForAuth.build();
        Response response = given().spec(requestSpecificationForAuth).when().post().then().spec(responseSpecificationForAuth).extract().response();
        Global.authKey=response.jsonPath().getString("token");
        return Global.authKey;
    }
}

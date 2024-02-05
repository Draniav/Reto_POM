package setup;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class SetUpPage {
    public static String URL_BACK = "";

    protected static final String BASE_URL = "https://reqres.in";
    protected static final String BASE_PATH = "/api";
    protected static final String RESOURCE = "/users";

    protected void generalSetUp(){
        configurationForRestAssured();
    }

    public void configurationForRestAssured(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
    //    RestAssured.filters(new RequestLoggingFilter(),new ErrorLoggingFilter(), new ResponseLoggingFilter());
     //   RestAssured.filters(new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }


}

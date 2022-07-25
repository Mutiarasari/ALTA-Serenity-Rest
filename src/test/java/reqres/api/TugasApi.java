package reqres.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.json.Json;

import java.io.File;



public class TugasApi {
    public static final String URL = "https://reqres.in/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/json/";

    public static String GET_LIST_RESOURCE = URL+"api/unknown";
    public static String GET_SINGLE_RESOURCE = URL+"api/unknown/{id}";
    public static String POST_REGISTER = URL + "api/register";
    public static String PATCH_USER = URL + "api/users/{id}";
    public static String GET_INVALID_RESOURCE = URL+"api/unknown/{id}";
    public static String GET_REGISTER = URL + "api/register";

    @Step("Get list resource")
    public void getListResource(){
        SerenityRest.given();
    }
    @Step("Get single resource")
    public void getSingleResource(int id){
        SerenityRest.given()
                .pathParam("id",id);  // Ngasi parameter id
    }
    @Step
    public void getInvalidResource(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step
    public void setGetRegister(){
        SerenityRest.given();
    }

    @Step("Post Register")
    public void PostRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch user")
    public void PatchUser(File json, int id){
        SerenityRest.given()
                .pathParam("id",id) // parameter id
                .contentType(ContentType.JSON) //file json
                .body(json); // body json
    }
}


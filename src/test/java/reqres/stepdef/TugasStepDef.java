package reqres.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.simple.parser.JSONParser;
import reqres.api.ReqresApi;
import reqres.api.TugasApi;
import reqres.response.ReqresResponse;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;

public class TugasStepDef {
    @Steps
    TugasApi tugasApi;
    @Given("Get list user resource")
    public void getListUserResource() {
        tugasApi.getListResource();
    }

    @When("Send request Get list user resource")
    public void sendRequestGetListUserResource() {
        SerenityRest.when().get(TugasApi.GET_LIST_RESOURCE);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int statuscode) {
        SerenityRest.then().statusCode(statuscode);

    }

    @And("Get list user resource assert json validation")
    public void getListUserResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/Bebas.json"); // Mendirect ke file json
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile)); //Membandingkan antara hasil dan json file yang seharusnya
    }

    @Given("get single user resource with {int}")
    public void getSingleUserResource(int id) {
        tugasApi.getSingleResource(id);
    }

    @When("Send request get single user resource")
    public void sendRequestGetSingleUserResource() {
        SerenityRest.when().get(TugasApi.GET_SINGLE_RESOURCE);
    }

    @And("Get single user resource assert json validation")
    public void getSingleUserResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/Bebas2.json"); // Mendirect ke file json
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile)); //Membandingkan antara hasil dan json file yang seharusnya
    }

    @Given("post register user")
    public void postRegisterUser() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/PostRegister.json");
        tugasApi.PostRegister(jsonFiles);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(TugasApi.POST_REGISTER);

    }

    @And("Post create register assert json validation")
    public void postCreateRegisterAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/Bebas3.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Patch user with {int}")
    public void patchUserWith2(int id) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/PatchUser.json");
        tugasApi.PatchUser(jsonFiles,id);
    }

    @When("Send Request Patch user")
    public void sendRequestPatchUser() {
        SerenityRest.when().patch(TugasApi.PATCH_USER);
    }

    @And("Patch user assert json validation")
    public void patchUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/Bebas4.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get single invalid resource with {int}")
    public void getSingleInvalidResourceWith(int id) {
        tugasApi.getInvalidResource(id);
    }

    @When("send request invalid resource")
    public void sendRequestInvalidResource() {
        SerenityRest.when().get(TugasApi.GET_INVALID_RESOURCE);
    }

    @Then("Status code should be {int} Not found")
    public void statusCodeShouldBeNotFound(int status) {
        SerenityRest.then().statusCode(status);
    }
    @Given("Get Register")
    public void getRegister() {
        tugasApi.setGetRegister();
    }

    @Given("Post reg to invalid url")
    public void postRegToInvalidUrl() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/PostRegister.json");
        tugasApi.PostRegister(jsonFiles);
    }

    @When("send request to invalid url")
    public void sendRequestToInvalidUrl() {
        SerenityRest.when().post(TugasApi.GET_LIST_RESOURCE);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int stats) {
        SerenityRest.then().statusCode(stats);
    }
}

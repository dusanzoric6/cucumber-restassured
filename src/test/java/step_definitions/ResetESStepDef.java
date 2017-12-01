package step_definitions;

import com.equifax.igl.rest.model.Request;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import model.query.ESApp.IdentityQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ResetESStepDef {

    private   String identityQueryString;
    protected RequestSpecification request;
    protected Response response;
    protected File queryJsonFile;
    protected ObjectMapper objectMapper = new ObjectMapper();
    protected Request apiQueryIdentity;
    protected IdentityQuery identityQuery;

    public ResetESStepDef() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @When("^PUT request is sent$")
    public void pUTRequestIsSent() {
        response = given()
                .header("Content-Type", "application/json")
                .body(queryJsonFile)
                .when().
                        put();
    }

    @When("^DELETE request is sent$")
    public void dELETERequestIsSent() {
        response = given()
                .header("Content-Type", "application/json")
                .when().
                        delete();
    }

    @And("^input_data JSON sent with request is located on (.*)$")
    public void inputJSON(String jsonPath) {
        queryJsonFile = new File(jsonPath);
    }

    @And("^mapping JSON sent with request is located on (.*)$")
    public void mappingJSON(String jsonPath) {
        inputJSON(jsonPath);
    }

    @When("^query JSON is located on (.*)$")
    public void queryJSONIs(String jsonPath) throws IOException{
        queryJsonFile = new File(jsonPath);
        identityQuery = objectMapper.readValue((queryJsonFile), IdentityQuery.class);
    }

    @When("^APIquery JSON is located on (.*)$")
    public void APIqueryJSONIs(String jsonPath) throws IOException {
        queryJsonFile = new File(jsonPath);
        apiQueryIdentity = objectMapper.readValue(queryJsonFile, Request.class);
    }

    @And("^POST request is sent$")
    public void POSTRequestIsSent() {
        response = given()
                .header("Content-Type", "application/json")
                .body(queryJsonFile)
                .when().
                        post();
    }

    @When("^GET request is sent$")
    public void sendGETRequestIsSended() throws Throwable {
        response = request.when().
                get();
    }

    @And("^(.*) number of identity is (.*)$")
    public void sSNNumberOfIdentityIs399688(String key, String value) {
        request = given().
                param(key, value);
    }

    @And("^query JSON is modified by changing the last name with the (.+)$")
    public void lastNameInQueryJSONCathrineIsSwitchedWith(String token) {
        identityQuery.getConsumerIdentity().getNames().get(0).setLastName(token);
        try {
            identityQueryString = objectMapper.writeValueAsString(identityQuery);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @And("^POST request is sent with String$")
    public void POSTRequestIsSentWithString() {

        response = given()
                .header("Content-Type", "application/json")
                .body(identityQueryString)
                .when().
                        post();
    }
}

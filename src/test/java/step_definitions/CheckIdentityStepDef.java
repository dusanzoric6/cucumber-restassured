package step_definitions;


import com.equifax.igl.rest.model.Response;
import model.query.API.APIQueryIdentity;
import model.query.ESApp.IdentityQuery;
import model.response.API.APIResponseIdentity;
import model.response.ESApp.Identity;
import model.singleIdentity.SingleIdentity;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckIdentityStepDef {

    private IdentityQuery identityQuery;
    private List<Identity> identitiesResponse;
    private List<SingleIdentity> singleIdentityList;
    private File queryJsonFile;

    private ObjectMapper objectMapper = new ObjectMapper();
    private APIQueryIdentity apiQueryIdentity;
    private APIResponseIdentity apiResponse;
    protected String urlGlob;

    ResetESStepDef resetESStepDef;
    public CheckIdentityStepDef(ResetESStepDef resetESStepDef){
        this.resetESStepDef = resetESStepDef;
    }
    protected io.restassured.response.Response response ;

    @Given("^url of an API is (.*)")
    public void urlOfAnAPIIsUrl(String url)  {
        urlGlob = url;
        RestAssured.baseURI = urlGlob;
    }

    @Then("^response status code is (\\d+)")
    public void verifyStatusCode(int statusCode) {
        response = resetESStepDef.response;
        assertEquals(statusCode,response.statusCode());
    }

    @And("^check Customer ID List$")
    public void checkCidList() {
        apiResponse = response.getBody().as(APIResponseIdentity.class);

        assertEquals("SUCCESS", apiResponse.getSearchResponse().getResponseStatus());
        assertEquals( (Integer) 1, apiResponse.getSearchResponse().getMatchFound());
        assertEquals("54321", apiResponse.getSearchResponse().getCidlist().get(0));
    }

    @And("^check Customer ID List Is Empty$")
    public void checkCidListIsEmpty() {
        apiResponse = response.getBody().as(APIResponseIdentity.class);

        assertEquals("SUCCESS", apiResponse.getSearchResponse().getResponseStatus());
        assertEquals((Integer) 0, apiResponse.getSearchResponse().getMatchFound());
        assertEquals(Collections.emptyList(), apiResponse.getSearchResponse().getCidlist());
    }

    @And("^response body is empty$")
    public void responseBodyIsEmpty(){
        identitiesResponse = Arrays.asList(response.getBody().as(Identity[].class));
        assertTrue(identitiesResponse.size()==0);
    }

    @And("^response is checked$")
    public void responseIsChecked() {
        response.prettyPrint();
        singleIdentityList = Arrays.asList(response.getBody().as(SingleIdentity[].class));
        assertTrue("Response body is empty", singleIdentityList.size() > 0);
        for (SingleIdentity singleIdentity : singleIdentityList) {
            for (int i = 0; i < singleIdentityList.size(); i++) {
                assertEquals(singleIdentity.getKeyResponse().getSearchResult().getSearchBucket().get(i).getName(), "abc");
                for (int j = 0; j < singleIdentity.getKeyResponse().getSearchResult().getSearchBucket().get(i).getEntities().size(); j++) {
                    assertEquals(singleIdentity.getKeyResponse().getSearchResult().getSearchBucket().get(i).getEntities().get(j).getKey(), "entityKey1");
                }
            }
        }
    }

    @And("^response is checked against query JSON$")
    public void responseIsCheckedAgainsQueryJSON() {
        identityQuery = resetESStepDef.identityQuery;
        identitiesResponse = Arrays.asList(response.getBody().as(Identity[].class));
        assertTrue("Response body is empty", identitiesResponse.size() > 0);
        for (Identity identityResponse : identitiesResponse) {
            assertEquals(identityQuery.getConsumerIdentity().getSsn(), identityResponse.getSsn());
            for (int i = 0; i < identityResponse.getNames().size(); i++) {
                assertEquals(identityQuery.getConsumerIdentity().getNames().get(i).getIdentifier(),
                        identityResponse.getNames().get(i).getIdentifier());
                assertEquals(identityQuery.getConsumerIdentity().getNames().get(i).getPrefix(),
                        identityResponse.getNames().get(i).getPrefix());
                assertEquals(identityQuery.getConsumerIdentity().getNames().get(i).getFirstName(),
                        identityResponse.getNames().get(i).getFirstName());

                if (identityResponse.getNames().get(i).getLastName().length() == 3) {
                    assertThat(identityResponse.getNames().get(i).getLastName(),
                            CoreMatchers.containsString(identityQuery.getConsumerIdentity().getNames().get(i).getLastName()));
                }else if(identityQuery.getConsumerIdentity().getNames().get(i).getLastName().length() > 3) {
                    assertEquals(identityQuery.getConsumerIdentity().getNames().get(i).getLastName(),
                            identityResponse.getNames().get(i).getLastName());
                }
                assertEquals(identityQuery.getConsumerIdentity().getNames().get(i).getMiddleName(),
                        identityResponse.getNames().get(i).getMiddleName());
                assertEquals(identityQuery.getConsumerIdentity().getNames().get(i).getSuffix(),
                        identityResponse.getNames().get(i).getSuffix());
            }
            for (int i = 0; i < identityResponse.getNames().size(); i++) {
                assertEquals(identityQuery.getConsumerIdentity().getAddresses().get(i).getAddressLine1(),
                        identityResponse.getAddresses().get(i).getAddressLine1());
            }
        }
    }


}






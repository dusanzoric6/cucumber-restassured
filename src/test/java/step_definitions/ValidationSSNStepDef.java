package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.io.File;

public class ValidationSSNStepDef {

    protected File queryJsonFile;



    @When("^APIquery JSON with valid SSN is located on (.*)$")
    public void aPIqueryJSONWithValidSSN(String jsonPath) {
        queryJsonFile = new File(jsonPath);
    }

    @When("^APIquery JSON with invalid SSN is located on (.*)$")
    public void aPIqueryJSONWithInalidSSN(String jsonPath) {
        queryJsonFile = new File(jsonPath);
    }

    @And("^check that request was valid$")
    public void checkThatRequestWasValid() {
    }

    @And("^check for the error message$")
    public void checkForTheErrorMessage() {

    }

}

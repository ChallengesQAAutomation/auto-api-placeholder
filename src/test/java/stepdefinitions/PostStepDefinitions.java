package stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.placeholder.question.AttributesQuestion.attributesOf;
import static org.placeholder.question.StatusCodeQuestion.statusCodeof;
import static org.placeholder.task.CraetePost.forResource;
import static org.placeholder.task.ListPost.getPost;
import static stepdefinitions.setupConfiguration.user;


public class PostStepDefinitions {

    @Given("^I perform a GET request to (.*)$")
    public void performGETRequest(String resource) {
        user.attemptsTo(getPost(resource));
    }

    @Then("^the response status code should be (\\d+)$")
    public void verifyStatusCode(int response) {
        user.should(seeThat(statusCodeof(response)));
    }

    @Then("^the response should contain the following attributes:$")
    public void verifyResponseAttributes(DataTable response) {
       user.should(seeThat(attributesOf(response)));
    }

    @Given("I perform a POST request to (.*)$")
    public void iPerformAPOSTRequestToPosts(String resource) {
        user.attemptsTo(forResource(resource));
    }
}

package stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.placeholder.question.AttributesQuestion.attributesOf;
import static org.placeholder.question.StatusCodeQuestion.statusCodeof;
import static org.placeholder.task.GetPost.getPost;
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

    @Then("^the response should be a collection of resources with the following attributes:$")
    public void verifyCollectionResponseAttributes(DataTable dataTable) {
        // Implementación del paso para verificar los atributos de una respuesta de tipo colección utilizando la tabla de datos
    }

    @Given("^I perform a POST request to \"([^\"]*)\" with the following data:$")
    public void performPOSTRequestWithData(String url, DataTable dataTable) {
        // Implementación del paso para realizar una solicitud POST a la URL especificada con los datos proporcionados en la tabla de datos
    }

    @Given("^I perform a PUT request to \"([^\"]*)\" with the following data:$")
    public void performPUTRequestWithData(String url, DataTable dataTable) {
        // Implementación del paso para realizar una solicitud PUT a la URL especificada con los datos proporcionados en la tabla de datos
    }

    @Given("^I perform a PATCH request to \"([^\"]*)\" with the following data:$")
    public void performPATCHRequestWithData(String url, DataTable dataTable) {
        // Implementación del paso para realizar una solicitud PATCH a la URL especificada con los datos proporcionados en la tabla de datos
    }

    @When("^I perform a DELETE request to \"([^\"]*)\"$")
    public void performDELETERequest(String url) {
        // Implementación del paso para realizar una solicitud DELETE a la URL especificada
    }

}

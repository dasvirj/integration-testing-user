package stepDefinitions;

import fixtures.RequestInformations;
import fixtures.UserDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import utils.Utils;

public class UserSteps {

    @Given("as informacoes de um usuario")
    public void userInformations(){
        UserDTO user = RequestInformations.user;
    }

    @When("realizo o seu cadastro")
    public void createUser(){
        RequestInformations.response = RestAssured
                .given()
                .spec(Utils.getRequestSpecAPI())
                .body(RequestInformations.user)
                .when()
                .post("/users");
    }

    @Then("o status code da API deve retornar 201")
    public void validateStatus(){
        RequestInformations.response
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Then("todos os usuarios cadastrados sao listados")
    public void listUsers(){
        RestAssured
                .given()
                .spec(Utils.getRequestSpecAPI())
                .when()
                    .get("/users")
                .then()
                    .statusCode(HttpStatus.SC_OK);
    }
}

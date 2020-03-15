package testSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import petStroreApi.UserApi;

import java.io.IOException;


public class CreateUserSteps {

    private UserApi userApi;

    public CreateUserSteps(UserApi userApi) {
        this.userApi = userApi;
    }

    @And("I ([^\\\"]*) a new user")
    public void actionsWithUsers(String action) throws IOException {
        userApi.actionsWithUser(action);
    }

    @Then("I get an username of recently used user")
    public void getIdOfRecentlyCreatedUser() {
        System.out.println(userApi.getUserName());
    }

}

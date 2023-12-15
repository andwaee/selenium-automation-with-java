package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;

public class HomePageSteps {
    private HomePage homePage = new HomePage();

    @Then("^user navigates to user profile$")
    public void userNavigatesToUserProfile() {
       homePage.isUserOnUserProfile();
    }

}

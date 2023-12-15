package steps;

import common.CommonUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProfilePage;

import java.io.IOException;

public class ProfilePageSteps {

    private ProfilePage profilePage = new ProfilePage();
    private CommonUtil util = new CommonUtil();

    @Then("^user should see that user details are correct$")
    public void userDetailsAreCorrect() throws IOException {
        final String email = util.testDataHandler("username");
        final String firstName = util.testDataHandler("first-name");
        final String lastName = util.testDataHandler("last-name");
        profilePage.areCredentialsCorrect(email, firstName, lastName);
    }

    @When("^user changes the profile details$")
    public void userChangesTheProfile() throws IOException {
        profilePage.changeCompanyName();
    }

    @Then("^user should see successful update message$")
    public void successfulMessageDisplayed() throws IOException {
        profilePage.isSuccessUpdateMessageDisplayed();
    }

}

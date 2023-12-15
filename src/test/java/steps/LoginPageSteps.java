package steps;

import common.CommonUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPageSteps {
    Scenario scenario;
    private LoginPage loGinpage = new LoginPage();
    private HomePage homePage = new HomePage();
    private CommonUtil util = new CommonUtil();

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        loGinpage.setScenario(scenario);
        loGinpage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^user has logged in and is on the homepage$")
    public void userLoginWithCredentials() throws InterruptedException, IOException {
        loGinpage.isUserOnLoginPage();
        String username  = util.testDataHandler("username");
        String password  = util.testDataHandler("password");
        loGinpage.inputCredentials(username, password);
        homePage.isUserOnHomePage();
    }

}

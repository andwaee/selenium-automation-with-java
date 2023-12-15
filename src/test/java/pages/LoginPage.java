package pages;

import common.BaseTest;
import common.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseTest {
    final String websiteLink = "https://courses.ultimateqa.com/users/sign_in";

    @FindBy(xpath = "//input[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
    @FindBy(css = ".logo.img-responsive")
    private WebElement loginIcon;

    private CommonUtil util = new CommonUtil();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public LoginPage() {
        goTo(websiteLink);
    }


    public void inputCredentials(String email, String password) throws InterruptedException {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        util.takeScreenshot(driver, scenario);
    }

    public void isUserOnLoginPage() {
        wait.until(d -> this.loginIcon.isDisplayed());
        boolean assertion = this.loginIcon.isDisplayed();
        Assert.assertTrue(assertion);
        util.takeScreenshot(driver, scenario);
    }


}

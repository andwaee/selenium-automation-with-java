package pages;

import common.BaseTest;
import common.CommonUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class ProfilePage extends BaseTest {
    @FindBy(xpath = "//input[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user[first_name]']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='user[last_name]']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='user[profile_attributes][company]']")
    private WebElement companyField;

    @FindBy(xpath = "//input[@value='Save Changes']")
    private WebElement saveChangeButton;

    @FindBy(xpath = "//p[@class='message-text']")
    private WebElement successfulUpdateMessage;


    private CommonUtil util = new CommonUtil();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    JavascriptExecutor executor = (JavascriptExecutor)driver;


    public void areCredentialsCorrect(String email, String firstName, String lastName) {
        String actualEmail = emailField.getAttribute("value");
        String actualFirstName = firstNameField.getAttribute("value");
        String actualLastName = lastNameField.getAttribute("value");
        Assert.assertEquals(actualEmail, email);
        Assert.assertEquals(actualFirstName, firstName);
        Assert.assertEquals(actualLastName, lastName);
        util.takeScreenshot(driver, scenario);
    }
    public void changeCompanyName() throws IOException {
        String companyNameValue = companyField.getAttribute("value");
        String companyName1 = util.testDataHandler("first-company");
        String companyName2 = util.testDataHandler("second-company");
        System.out.println("validate here");
        System.out.println(companyNameValue);

        if (companyNameValue.equals(companyName1)) {
            System.out.println("First Condition");
            WebElement waitForCompanyField = wait.until(ExpectedConditions.elementToBeClickable(companyField));
            companyField.click();
            companyField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            companyField.sendKeys(companyName2);
        } else {
            System.out.println("Second Condition");
            WebElement waitForCompanyField = wait.until(ExpectedConditions.elementToBeClickable(companyField));
            companyField.click();
            companyField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            companyField.sendKeys(companyName1);
        }

        util.ScrollIntoView(driver, saveChangeButton);
        wait.until(d -> this.saveChangeButton.isDisplayed());
        WebElement saveChangeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveChangeButton));
        executor.executeScript("arguments[0].click();", saveChangeButton);
        util.takeScreenshot(driver, scenario);
    }

    public void isSuccessUpdateMessageDisplayed() {
        wait.until(d -> this.successfulUpdateMessage.isDisplayed());
        boolean assertion = this.successfulUpdateMessage.isDisplayed();
        Assert.assertTrue(assertion);
        util.takeScreenshot(driver, scenario);
    }

}

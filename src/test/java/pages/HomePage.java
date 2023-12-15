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

public class HomePage extends BaseTest{
    @FindBy(xpath = "//li[@class='header__nav-item header__nav-item--default']/a")
    private WebElement dashBoardLinkText;

    @FindBy(xpath = "//button/img")
    private WebElement profileIcon;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement myAccountMenu;

    @FindBy(xpath = "//h2[@class='my-account__heading']")
    private WebElement editProfileText;


    private CommonUtil util = new CommonUtil();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public void isUserOnHomePage() {
        wait.until(d -> this.dashBoardLinkText.isDisplayed());
        boolean assertion = this.dashBoardLinkText.isDisplayed();
        Assert.assertTrue(assertion);
        util.takeScreenshot(driver, scenario);
    }

    public void isUserOnUserProfile() {
        profileIcon.click();
        myAccountMenu.click();
        wait.until(d -> this.editProfileText.isDisplayed());
        boolean assertion = this.editProfileText.isDisplayed();
        Assert.assertTrue(assertion);
        util.takeScreenshot(driver, scenario);
    }


}

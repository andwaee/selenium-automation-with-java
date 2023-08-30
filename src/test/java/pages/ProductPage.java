package pages;

import common.BaseTest;
import common.CommonUtil;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends BaseTest {

    @FindBy(xpath = "//a[@class='shopping_cart_link']/child::span")
    private WebElement cartCount;
    @FindBy(xpath = "//div[@class='bm-burger-button']/child::button")
    private WebElement humberger;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement humbergerAllItems;
    @FindBy(id = "about_sidebar_link")
    private WebElement humbergerAbout;
    @FindBy(id = "logout_sidebar_link")
    private WebElement humbergerLogout;
    @FindBy(id = "'reset_sidebar_link")
    private WebElement humbergerResetAppState;
    @FindBy(xpath = "//div[@class='pricebar']/div")
    private List<WebElement> allPrices;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement Select;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement homePageHeaderText;
    Select dropdown = new Select(Select);

    private CommonUtil util = new CommonUtil();


    public WebElement getProductName(String productname) {
        return driver.findElement(By.partialLinkText(productname));
    }

    public void selectOnDropdown(String DropdownItem) {
        dropdown.selectByVisibleText(DropdownItem);
    }

    public WebElement product(String productName) {
        String xpath = "//a/div[text()='" + productName + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div/button";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement cartCount(int expectedCartCount) {
        String xpath = "//a[@class='shopping_cart_link']/span[text()='" + expectedCartCount + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public void closeBrowser() {
        getDriver().close();
    }

    public void getAllPrices() {
        for (WebElement prices : allPrices) {
            System.out.println(prices.getText());
        }
        util.takeScreenshot(driver, scenario);
    }

    public void addProductToCart(String productName) {
        this.product(productName).click();
    }

    public void validateCartCount(int expectedCartCount) {
        boolean assertion = this.cartCount(expectedCartCount).isDisplayed();
        Assert.assertTrue(assertion);
    }

    public void validateHomePage() {
        boolean assertion = this.homePageHeaderText.isDisplayed();
        Assert.assertTrue(assertion);
    }

}


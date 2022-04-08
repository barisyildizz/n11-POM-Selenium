package Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    protected By cookieLocator = By.xpath("//div[@id='cookieUsagePopIn']//span[@class='closeBtn']");
    protected By searchFieldLocator = By.id("searchData");
    protected By searchButtonLocator = By.cssSelector(".icon.iconSearch");
    protected By kategoriLocator = By.cssSelector(".catMenu");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage load(){
        load("/");
        return this;
    }


    public HomePage closeCookie() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(cookieLocator)).click();
       return this;
    }

    public ProductPage searchProduct(String txt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator)).sendKeys(txt);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator)).click();
        return new ProductPage(driver);
    }

    public WebElement kategoriFieldInHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(kategoriLocator));
        WebElement e = driver.findElement(kategoriLocator);
        return e;
    }

    public HomePage isOnHomePage(){
        kategoriFieldInHomePage().isDisplayed();
        return this;
    }
}

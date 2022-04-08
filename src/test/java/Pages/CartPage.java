package Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    protected By popUpCloseLocator = By.xpath("//span[@class='btn btnBlack']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage closeThePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(popUpCloseLocator)).click();
        return this;
    }



}

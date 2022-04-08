package Pages;

import POM.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends BasePage {
    protected By resultTextLocator = By.cssSelector(".resultText h1");
    protected By urunLocator = By.cssSelector(".productName");
    protected By renkLocator = By.cssSelector("span[data-unif-seovalue='altin']");
    protected By quantityIncreaseLocator = By.cssSelector(".spinnerUp");
    protected By quantityDecreaseLocator = By.cssSelector(".spinnerDown");
    protected By addToCartButtonLocator = By.cssSelector(".product-add-cart");
    protected By goToCartButtonLocator = By.cssSelector(".btn.btnBlack.btnGoBasket");
    protected By popupLocator = By.cssSelector(".btn.btnBlack.confirm");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage isOnProductSearchPage(){
        String e = wait.until(ExpectedConditions.visibilityOfElementLocated(resultTextLocator)).getText();
        Assert.assertEquals(e,"IPhone 13 Pro Max,","Ürün arama sayfasında değilsiniz!");
        return this;
    }

    public ProductPage selectAProduct(int i){
        wait.until(ExpectedConditions.visibilityOfElementLocated(urunLocator));
        List<WebElement> urunListesi = driver.findElements(urunLocator);
        urunListesi.get(i).click();
        return this;
    }

    public ProductPage selectColor(){
        wait.until(ExpectedConditions.elementToBeClickable(renkLocator)).click();
        return this;
    }

    public ProductPage quantityIncrease(){
        wait.until(ExpectedConditions.elementToBeClickable(quantityIncreaseLocator)).click();
        return this;
    }

    public ProductPage quantityDecrease(){
        wait.until(ExpectedConditions.elementToBeClickable(quantityDecreaseLocator)).click();
        return this;
    }

    public ProductPage addToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator)).click();
        return this;
    }

    public CartPage goToCartPage(){
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButtonLocator)).click();
        return new CartPage(driver);
    }

    public ProductPage closeThePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(popupLocator)).click();
        return this;
    }




}

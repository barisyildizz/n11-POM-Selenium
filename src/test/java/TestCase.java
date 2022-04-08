import POM.Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {

    @Test
    public void FirstTestCase(){

        HomePage homePage = new HomePage(driver);
        homePage.
                load().
                closeCookie().
                isOnHomePage().
                searchProduct("iPhone 13 Pro Max");

        CartPage productPage = new ProductPage(driver).
                isOnProductSearchPage().
                selectAProduct(1).
                selectColor().
                quantityIncrease().
                addToCart().
                closeThePopUp().
                quantityDecrease().
                addToCart().
                goToCartPage();

        CartPage cartPage = new CartPage(driver).
                closeThePopUp();









    }





}

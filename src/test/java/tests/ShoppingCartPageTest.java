package tests;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.RegisterPage;
import pages.ShoppingCartPage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static tests.URLS.*;

public class ShoppingCartPageTest {

    private WebDriver driver;
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private URLS urls;


    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        shoppingCartPage = PageFactory.initElements(driver,ShoppingCartPage.class);

        driver.get(HOME_PAGE);
    }

    @Test
    public void addToShoppingCart() {

        homePage.clickOnBooksButton();

        homePage.clickOnBookToCart();

        shoppingCartPage.clickOnShoppingCartButton();

        driver.get(CART_PAGE);

        assertTrue("not add to cart", shoppingCartPage.isInCart());

    }

    @Test
    public void addToShoppingCartLongWay() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage.clickNotebooksButton();

        driver.get(NOTEBOOKS_PAGE);

        shoppingCartPage.clickOnMacBook();

        shoppingCartPage.clickOnAddToCart4();

        driver.get(CART_PAGE);

        Assertions.assertThat(shoppingCartPage.getSkuNumber()).isEqualToIgnoringCase("AP_MBP_13");

    }

    @Test
    public void continueShopping(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage.clickOnBooksButton();

        homePage.clickOnBookToCart();

        shoppingCartPage.clickOnShoppingCartButton();

        driver.get(CART_PAGE);

        shoppingCartPage.clickOnContinueShoppingButton();

        driver.get(HOME_PAGE);

        homePage.clickNotebooksButton();

        driver.get(NOTEBOOKS_PAGE);

        shoppingCartPage.clickOnMacBook();

        shoppingCartPage.clickOnAddToCart4();

        driver.get(CART_PAGE);

        Assertions.assertThat(shoppingCartPage.getSkuNumber()).isEqualToIgnoringCase("AP_MBP_13");
        Assertions.assertThat(shoppingCartPage.getSkuNumber2()).isEqualToIgnoringCase("PRIDE_PRJ");

    }

    @After
    public void tearDown() { driver.close(); }

}

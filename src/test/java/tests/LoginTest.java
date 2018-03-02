package tests;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;
import static tests.URLS.LOGIN_PAGE;


public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private URLS urls;


    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);

        driver.get(LOGIN_PAGE);
    }

    @Test
    public void loginTest() {

        String email = "henryk@gmail.com";
        String password = "henrykkowalski";

        loginPage.inputInformation(email,password);
        loginPage.clickOnLogInButton();

        Assertions.assertThat(homePage.logOutButton()).isEqualToIgnoringCase("Log out");

    }


    @After
    public void tearDown() {
        driver.close();
    }
}

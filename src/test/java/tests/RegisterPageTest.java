package tests;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterPage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;

import java.util.UUID;

import static tests.URLS.REGISTER_PAGE;

public class RegisterPageTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private URLS urls;


    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        registerPage = PageFactory.initElements(driver, RegisterPage.class);

        driver.get(REGISTER_PAGE);
    }

    @Test
    public void registerTest() {

        String firstName = "Ala";
        String lastName = "Kot";
        String email = "@gmail.com";
        String password = "123kotala";
        String confirmPassword = "123kotala";
        String dayOfBirth = "1";
        String monthOfBirth = "January";
        String yearOfBirth = "2000";

        registerPage.clickFemaleButton();
        registerPage.inputRegisterInformationForm(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, UUID.randomUUID() + email);
        registerPage.inputUserInformation(password, confirmPassword);

        registerPage.clickOnRegisterButton();

        // assertEquals("http://demo.nopcommerce.com/registerresult/1", driver.getCurrentUrl());
        Assertions.assertThat(registerPage.getResultMessage()).isEqualToIgnoringCase("Your registration completed");

    }


    @After
    public void tearDown() {
        driver.close();
    }
}




package tests;

import org.assertj.core.api.Assertions;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterPage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;

import java.util.UUID;

import static tests.URLS.REGISTER_PAGE;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "src/test/resources/registration.xml" }, loaderType = LoaderType.XML, writeData = false)
public class RegisterPageWithEasyTest {

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
    public void registerUserTest(@Param(name = "firstName") String firstName,
                                 @Param(name = "lastName") String lastName,
                                 @Param(name = "dayOfBirth") String dayOfBirth,
                                 @Param(name = "monthOfBirth") String monthOfBirth,
                                 @Param(name = "yearOfBirth") String yearOfBirth,
                                 @Param(name = "email") String email,
                                 @Param(name = "password") String password,
                                 @Param(name = "confirmPassword") String confirmPassword){

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

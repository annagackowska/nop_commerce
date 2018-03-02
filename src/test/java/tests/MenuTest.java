package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuTest {
    private static final String URL = "http://demo.nopcommerce.com/";

    private WebDriver driver;

    private HomePage homePage;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);

        driver.get(URL);
    }


    @Test
    public void menuContainsAllElements() {

        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='header-menu']"));
        List<String> stringElements = new ArrayList<>();

        for (WebElement element : listOfElements) {
            stringElements.add(element.getText());
        }


        List<String> expectedOptions = Arrays.asList("Computers", "Electronics", "Apparel", "Digital Downloads", "Books", "Jewelry", "Gift Cards");

        stringElements.containsAll(expectedOptions);

    }

    @After
    public void tearDown() {
        driver.close();
    }
}


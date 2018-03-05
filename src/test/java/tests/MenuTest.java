package tests;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void computersMenuIsDropdownAndClickable() {

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[@href='/computers']")))
                .click(driver.findElement(By.xpath("//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/desktops']")))
                .perform();

        Assertions.assertThat(homePage.getDesktopMessage()).isEqualToIgnoringCase("Desktops");

        driver.navigate().back();


        Actions builder1 = new Actions(driver);
        builder1.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[@href='/computers']")))
                .click(driver.findElement(By.xpath("//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/notebooks']")))
                .perform();

       // homePage.clickNotebooksButton();
        Assertions.assertThat(homePage.getNoteBooksMessage()).isEqualToIgnoringCase("Notebooks");

       driver.navigate().back();

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[@href='/computers']")))
                .click(driver.findElement(By.xpath("//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/software']")))
                .perform();


        Assertions.assertThat(homePage.getSoftwareMessage()).isEqualToIgnoringCase("Software");
        }

    @Test
    public void submenuComputersContainsAllElements() {

        List<WebElement> listOfElements = driver.findElements(By.xpath("//ul[@class='top-menu']//li//a[@href='/computers']"));
        List<String> stringElements = new ArrayList<>();

        for (WebElement element : listOfElements) {
            stringElements.add(element.getText());
        }

        List<String> expectedOptions = Arrays.asList("Desktops", "Notebooks", "Software");

        stringElements.containsAll(expectedOptions);

    }


    @After
    public void tearDown() { driver.close(); }
}


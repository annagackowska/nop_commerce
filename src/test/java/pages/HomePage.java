package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='header-menu']")
    private WebElement menu;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logOutButton;

    @FindBy(xpath = "//ul[@class='top-menu']//li//a[@href='/apparel']")
    private WebElement apparelButton;

    @FindBy(xpath = "//ul[@class='top-menu']//li//a[@href='/computers']")
    private WebElement computersButton;

    @FindBy(xpath = "//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/desktops']")
    private WebElement desktops;

    @FindBy(xpath = "//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/notebooks']")
    private WebElement notebooks;

    @FindBy(xpath = "//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/software']")
    private WebElement software;

    @FindBy(xpath = "//ul[@class='top-menu']//li//a[@href='/electronics']")
    private WebElement electronicButton;

    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    private WebElement desktopMessage;

    @FindBy(xpath = "//h1[contains(text(),'Notebooks')]")
    private WebElement notebooksMessage;

    @FindBy(xpath = "//h1[contains(text(),'Software')]")
    private WebElement softwareMessage;

    @FindBy(xpath = "//ul[@class='top-menu']//li//a[@href='/books']")
    private WebElement booksButton;

    @FindBy(xpath = "//html//div[3]/div[1]/div[2]/div[3]/div[2]/input[1]")
    private WebElement bookToCart;

    @FindBy(xpath = "//p[@class='content'][contains(text(),'The product has been added to your')]")
    private WebElement addToCartMessage;

    public String getAddToCartMessage() {return addToCartMessage.getText();}

    public String getDesktopMessage() {return desktopMessage.getText();}
    public String getNoteBooksMessage() {return notebooksMessage.getText();}
    public String getSoftwareMessage() {return softwareMessage.getText();}
    public void clickOnBooksButton() {booksButton.click();}
    public void clickOnBookToCart() {bookToCart.click();}

    public void clickDesktopButton() {

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[@href='/computers']")))
                .click(driver.findElement(By.xpath("//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/desktops']")))
                .perform();

    }

    public void clickNotebooksButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[@href='/computers']")))
                .click(driver.findElement(By.xpath("//ul[@class='top-menu']//li//ul[@class='sublist first-level']//li//a[@href='/notebooks']")))
                .perform();



    }


    public String logOutButton() {return logOutButton.getText();}

    public void clickOnApparelButton() {apparelButton.click();}

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//div[@class='header-menu']")
    private WebElement menu;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logOutButton;

    public String logOutButton() {return logOutButton.getText();}

}

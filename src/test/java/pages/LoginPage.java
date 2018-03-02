package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id="Email")
    private WebElement emailField;

    @FindBy(id="Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    private WebElement logInButton;

    public void inputInformation(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickOnLogInButton() {logInButton.click();}
}

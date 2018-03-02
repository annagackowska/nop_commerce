package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    @FindBy(id="gender-female")
    private WebElement femaleButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dateOfBirthDayField;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement dateOfBirthMonthField;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement dateOfBirthYearField;

    @FindBy(id="Email")
    private WebElement emailField;

    @FindBy(id = "Newsletter")
    private WebElement newsletterButton;

    @FindBy(id="Password")
    private WebElement passwordField;

    @FindBy(id="ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id="register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement resultMessage;

    public void clickFemaleButton() {femaleButton.click();}



    public void inputRegisterInformationForm(String firstName, String lastName, String dayOfBirth, String monthOfBirth,
                                             String yearOfBirth, String email) {


        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        new Select(dateOfBirthDayField).selectByVisibleText(dayOfBirth);
        new Select(dateOfBirthMonthField).selectByVisibleText(monthOfBirth);
        new Select(dateOfBirthYearField).selectByVisibleText(yearOfBirth);
        emailField.sendKeys(email);
    }

    public void clickOnNewletterButton(){newsletterButton.click();}

    public void inputUserInformation(String password, String confirmPassword) {
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);

    }

    public void clickOnRegisterButton(){registerButton.click();}

    public String getResultMessage() {
        return resultMessage.getText();
    }


}

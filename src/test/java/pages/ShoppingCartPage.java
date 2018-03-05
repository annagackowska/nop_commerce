package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//html//div[@class='cart-options']//input[1]")
    private WebElement updateShoppingCart;

    @FindBy(xpath = "//a[@href='/apple-macbook-pro-13-inch'][contains(text(),'Apple MacBook Pro 13-inch')]")
    private WebElement macBook;

    @FindBy(id="add-to-cart-button-4")
    private WebElement addToCart4;

    @FindBy(xpath = "//span[@class='sku-number'][contains(text(),'AP_MBP_13')]")
    private WebElement skuNumber;

    @FindBy(xpath = "//div[@class='cart-options']//input[2]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//span[@class='sku-number'][contains(text(),'PRIDE_PRJ')]")
    private WebElement skuNumber2;

    public void clickOnContinueShoppingButton() {continueShoppingButton.click();}

    public String getSkuNumber(){return skuNumber.getText();}
    public String getSkuNumber2(){return skuNumber2.getText();}

    public void clickOnAddToCart4(){addToCart4.click();}

    public void clickOnMacBook() {macBook.click();}

    public void clickOnShoppingCartButton() {shoppingCartButton.click();}

    public boolean isInCart() {return updateShoppingCart.isDisplayed();}



}

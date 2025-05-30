package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    
    @FindBy(id = "userName")
    private WebElement fullNameInput;
    
    @FindBy(id = "userEmail")
    private WebElement emailInput;
    
    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;
    
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;
    
    @FindBy(id = "submit")
    private WebElement submitButton;
    
    @FindBy(id = "output")
    private WebElement outputBox;
    
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> fullNameInput.isDisplayed());
    }
    
    public void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        typeText(fullNameInput, fullName, "Full Name");
        typeText(emailInput, email, "Email");
        typeText(currentAddressInput, currentAddress, "Current Address");
        typeText(permanentAddressInput, permanentAddress, "Permanent Address");
    }
    
    public void submitForm() {
        clickElement(submitButton, "Submit Button");
    }
    
    public boolean isOutputDisplayed() {
        return outputBox.isDisplayed();
    }
    
    public String getOutputText() {
        return outputBox.getText();
    }
}
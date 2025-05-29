package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class HomePage extends BasePage {
    
    @FindBy(xpath = "//h5[text()='Elements']/..")
    private WebElement elementsCard;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return elementsCard.isDisplayed();
    }
    
    public void navigateToElements() {
        clickElement(elementsCard, "Elements Card");
    }
}
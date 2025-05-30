package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {
    
    @FindBy(xpath = "//span[text()='Text Box']/..")
    private WebElement textBoxMenuItem;
    
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> textBoxMenuItem.isDisplayed());
    }
    
    public void navigateToTextBox() {
        clickElement(textBoxMenuItem, "Text Box Menu Item");
    }
}
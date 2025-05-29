package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.debug("Initialized page: {}", this.getClass().getSimpleName());
    }

    public abstract boolean isAt();
    
    protected void clickElement(WebElement element, String elementName) {
        logger.info("Clicking on {}", elementName);
        element.click();
    }
    
    protected void typeText(WebElement element, String text, String fieldName) {
        logger.info("Entering text '{}' in {}", text, fieldName);
        element.clear();
        element.sendKeys(text);
    }
}
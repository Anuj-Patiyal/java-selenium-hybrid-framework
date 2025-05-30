package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        try {
            logger.info("Clicking on {}", elementName);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            logger.debug("Successfully clicked on: {}", elementName);
        } catch (Exception e) {
            logger.error("Error clicking on element: {}", elementName, e);
            throw e;
        }
    }
    
    protected void typeText(WebElement element, String text, String fieldName) {
        try {
            logger.info("Entering text in {}: {}", fieldName, text);
            element.clear();
            element.sendKeys(text);
            logger.debug("Successfully entered text in: {}", fieldName);
        } catch (Exception e) {
            logger.error("Error entering text in field: {}", fieldName, e);
            throw e;
        }
    }
}
package tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextBoxTest {

    WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(TextBoxTest.class);

    @BeforeClass
    public void setUp()
    {
        logger.info("Setting up ChromeDriver with headless options.");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://demoqa.com/text-box");
        logger.info("Navigated to demoqa Text Box page.");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testTextBoxFormSubmission()
    {
        logger.info("Starting form submission test.");

        String fullName = "John Doe";
        String email = "john.doe@example.com";
        String currentAddress = "123 Main St";
        String permanentAddress = "456 Secondary St";

        logger.debug("Filling form fields.");
        waitAndSendKeys(By.id("userName"), fullName);
        waitAndSendKeys(By.id("userEmail"), email);
        waitAndSendKeys(By.id("currentAddress"), currentAddress);
        waitAndSendKeys(By.id("permanentAddress"), permanentAddress);

        By submitButtonLocator = By.id("submit");
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonLocator));

        try {
            logger.debug("Clicking submit button.");
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        } catch (ElementClickInterceptedException e) {
            logger.warn("ElementClickInterceptedException caught. Clicking via JavaScript.");
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitButton);
        }

        logger.debug("Validating form output.");
        Assert.assertEquals(waitAndGetText(By.id("name")), "Name:" + fullName);
        Assert.assertEquals(waitAndGetText(By.id("email")), "Email:" + email);
        Assert.assertEquals(waitAndGetText(By.xpath("//p[@id='currentAddress']")), "Current Address :" + currentAddress);
        Assert.assertEquals(waitAndGetText(By.xpath("//p[@id='permanentAddress']")),
            "Permananet Address :" + permanentAddress);

        logger.info("Form submission test passed.");
    }

    private void waitAndSendKeys(By locator, String text)
    {
        logger.debug("Waiting for element {} to be visible.", locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        logger.debug("Entered text '{}' into element {}.", text, locator);
    }

    private String waitAndGetText(By locator)
    {
        logger.debug("Getting text from element {}.", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Tearing down WebDriver.");
        if (driver != null) {
            driver.quit();
        }
    }
}

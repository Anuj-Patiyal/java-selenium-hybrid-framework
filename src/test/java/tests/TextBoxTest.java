package tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigManager;

public class TextBoxTest {
    private static final Logger logger = LogManager.getLogger(TextBoxTest.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        logger.info("Setting up test environment");
        
        // Setup WebDriverManager
        WebDriverManager.chromedriver().clearDriverCache().setup();
        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        if (ConfigManager.getBooleanProperty("headless")) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=" + 
            ConfigManager.getIntProperty("window.width") + "," + 
            ConfigManager.getIntProperty("window.height"));
        
        // Initialize driver
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 
            Duration.ofSeconds(ConfigManager.getIntProperty("explicit.wait")));
        
        // Navigate to base URL
        logger.info("Navigating to application URL: {}", ConfigManager.getProperty("base.url"));
        driver.get(ConfigManager.getProperty("base.url"));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    @Test
    public void textBoxText() {
        logger.info("Starting textBoxText test execution");

        // Load test data from config
        final String fullName = ConfigManager.getProperty("full.name");
        final String email = ConfigManager.getProperty("email");
        final String currentAddress = ConfigManager.getProperty("current.address");
        final String permanentAddress = ConfigManager.getProperty("permanent.address");
        logger.debug("Test data loaded successfully");

        // Navigate directly to text-box page
        logger.info("Navigating to Text Box page");
        driver.get(ConfigManager.getProperty("textbox.url"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));

        // Fill form
        logger.info("Filling text box form");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys(fullName);
        logger.debug("Entered full name: {}", fullName);

        driver.findElement(By.id("userEmail")).sendKeys(email);
        logger.debug("Entered email: {}", email);

        // Use JavaScript for long text entry
        WebElement currentAddr = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1];", currentAddr, currentAddress);
        logger.debug("Entered current address");

        WebElement permanentAddr = driver.findElement(By.id("permanentAddress"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1];", permanentAddr, permanentAddress);
        logger.debug("Entered permanent address");

        // Submit form
        logger.info("Submitting form");
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        logger.debug("Form submitted");

        // Verify output
        logger.info("Verifying output");
        WebElement outputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
        
        // Verify text appears incrementally
        wait.until(d -> outputBox.getText().contains("Name:" + fullName));
        logger.debug("Verified full name presence");
        
        wait.until(d -> outputBox.getText().contains("Email:" + email));
        logger.debug("Verified email presence");
        
        String currentAddrSub = currentAddress.substring(0, 20);
        wait.until(d -> outputBox.getText().contains(currentAddrSub));
        logger.debug("Verified current address presence");
        
        String permAddrSub = permanentAddress.substring(0, 15);
        wait.until(d -> outputBox.getText().contains(permAddrSub));
        logger.debug("Verified permanent address presence");

        logger.info("All assertions passed successfully");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            logger.info("Tearing down test environment");
            driver.quit();
            logger.debug("Browser closed successfully");
        }
    }
}
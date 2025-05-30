package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.ConfigManager;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void baseSetup() {
        try {
            logger.info("========== Test Setup Started ==========");
            initializeDriver();
            configureBrowser();
            logger.info("========== Test Setup Completed ==========");
        } catch (Exception e) {
            logger.fatal("Test setup failed", e);
            takeScreenshot("setup_failure");
            if (driver != null) {
                driver.quit();
            }
            throw e;
        }
    }

    protected void initializeDriver() {
        try {
            logger.info("Initializing WebDriver...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (ConfigManager.getBooleanProperty("headless")) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--window-size=" + 
                ConfigManager.getIntProperty("window.width") + "," + 
                ConfigManager.getIntProperty("window.height"));
            driver = new ChromeDriver(options);
            logger.info("WebDriver initialized successfully");
        } catch (Exception e) {
            logger.error("WebDriver initialization failed", e);
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }

    protected void configureBrowser() {
        try {
            logger.info("Configuring browser settings...");
            logger.info("Browser configured successfully");
        } catch (Exception e) {
            logger.error("Browser configuration failed", e);
            throw new RuntimeException("Browser configuration failed", e);
        }
    }

    protected void navigateToUrl(String url) {
        try {
            logger.info("Navigating to URL: {}", url);
            driver.get(url);
            logger.info("Successfully navigated to: {}", url);
        } catch (Exception e) {
            logger.error("Navigation to URL failed: {}", url, e);
            throw new RuntimeException("Navigation failed: " + url, e);
        }
    }

    protected byte[] takeScreenshot(String screenshotName) {
        try {
            if (driver instanceof TakesScreenshot) {
                logger.info("Taking screenshot: {}", screenshotName);
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            }
            return null;
        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
            return null;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void baseTeardown() {
        try {
            logger.info("========== Test Teardown Started ==========");
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed successfully");
            }
            logger.info("========== Test Teardown Completed ==========");
        } catch (Exception e) {
            logger.error("Error during test teardown", e);
        }
    }
}
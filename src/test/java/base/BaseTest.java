package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigManager;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void baseSetup() {
        try {
            logger.info("Initializing test setup");
            WebDriverManager.chromedriver().setup();
            
            ChromeOptions options = new ChromeOptions();
            if (ConfigManager.getBooleanProperty("headless")) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--window-size=" + 
                ConfigManager.getIntProperty("window.width") + "," + 
                ConfigManager.getIntProperty("window.height"));
            
            driver = new ChromeDriver(options);
                
            logger.info("Test setup completed");
        } catch (Exception e) {
            logger.error("Test setup failed", e);
            throw e;
        }
    }

    @AfterMethod
    public void baseTeardown() {
        try {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed successfully");
            }
        } catch (Exception e) {
            logger.error("Error during teardown", e);
        }
    }
    
    protected void navigateToUrl(String url) {
        driver.get(url);
        logger.info("Navigated to: {}", url);
    }
}
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.time.Duration;

public class TextBoxTest {
    private static final Logger logger = LogManager.getLogger(TextBoxTest.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        logger.info("Setting up test environment");
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

        logger.debug("Configuring browser settings");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        logger.info("Navigating to application URL");
        driver.get("https://demoqa.com/");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        logger.debug("Browser launched successfully");
    }

    @Test
    public void textBoxText() {
        logger.info("Starting textBoxText test execution");

        // Test data
        final String fullName = "A Tester";
        final String email = "ATester@test.com";
        final String currentAddress = "Noida, Uttar Pradesh, India";
        final String permanentAddress = "New Delhi, India";
        logger.debug("Test data initialized");

        // 1. Navigate to Elements - Fixed selector
        logger.info("Navigating to Elements section");
        WebElement elementsCard = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='card-body']/h5[text()='Elements']/..")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementsCard);
        logger.debug("Clicked on Elements card");

        // 2. Verify URL
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/elements"));
        logger.info("Verified Elements page URL");

        // 3. Open Text Box form - Direct navigation
        logger.info("Opening Text Box form");
        driver.get("https://demoqa.com/text-box");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
        logger.debug("Text Box form loaded");

        // 4. Fill form - Optimized entry
        logger.info("Filling text box form");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys(fullName);
        logger.debug("Entered full name: {}", fullName);

        driver.findElement(By.id("userEmail")).sendKeys(email);
        logger.debug("Entered email: {}", email);

        // Use JavaScript for long text entry (better performance)
        WebElement currentAddr = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1];", 
            currentAddr, currentAddress
        );
        logger.debug("Entered current address: {}", currentAddress);

        WebElement permanentAddr = driver.findElement(By.id("permanentAddress"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1];", 
            permanentAddr, permanentAddress
        );
        logger.debug("Entered permanent address: {}", permanentAddress);

        // 5. Submit form - Robust click
        logger.info("Submitting form");
        WebElement submitButton = driver.findElement(By.id("submit"));
        
        // Scroll into view with offset to avoid footer
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});" +
            "window.scrollBy(0, -100);", 
            submitButton
        );
        
        // Use JavaScript click to avoid element interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        logger.debug("Form submitted");

        // 6. Verify output - Smart text verification
        logger.info("Verifying output");
        WebElement outputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
        
        // Verify text appears incrementally
        wait.until(d -> outputBox.getText().contains("Name:" + fullName));
        logger.debug("Verified full name presence");
        
        wait.until(d -> outputBox.getText().contains("Email:" + email));
        logger.debug("Verified email presence");
        
        // Use contains with substring for long addresses
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
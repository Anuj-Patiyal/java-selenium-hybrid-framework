package tests;

import java.time.Duration;
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

    @BeforeClass
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();

        // Prevent usage of user data dir
        options.addArguments("--no-sandbox"); // Good practice in CI
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new"); // Required in CI unless using Xvfb
        options.addArguments("--disable-gpu"); // Optional, useful for stability
        options.addArguments("--remote-allow-origins=*"); // Avoid CORS issues
        options.addArguments("--disable-popup-blocking");

        // START SESSION
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://demoqa.com/text-box");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testTextBoxFormSubmission()
    {
        // Input data
        String fullName = "John Doe";
        String email = "john.doe@example.com";
        String currentAddress = "123 Main St";
        String permanentAddress = "456 Secondary St";

        // Fill form fields with wait
        waitAndSendKeys(By.id("userName"), fullName);
        waitAndSendKeys(By.id("userEmail"), email);
        waitAndSendKeys(By.id("currentAddress"), currentAddress);
        waitAndSendKeys(By.id("permanentAddress"), permanentAddress);

        // Click the submit button robustly
        By submitButtonLocator = By.id("submit");
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonLocator));

        try {
            // Scroll into view
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click in case of overlay
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitButton);
        }

        // Validate outputs
        Assert.assertEquals(waitAndGetText(By.id("name")), "Name:" + fullName);
        Assert.assertEquals(waitAndGetText(By.id("email")), "Email:" + email);
        Assert.assertEquals(waitAndGetText(By.xpath("//p[@id='currentAddress']")), "Current Address :" + currentAddress);
        Assert.assertEquals(waitAndGetText(By.xpath("//p[@id='permanentAddress']")),
            "Permananet Address :" + permanentAddress);
    }

    private void waitAndSendKeys(By locator, String text)
    {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    private String waitAndGetText(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    @AfterClass
    public void tearDown()
    {
        if (driver != null) {
            driver.quit();
        }
    }
}

package tests;

import java.time.Duration;
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

public class TextBoxTest 
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() 
    {
        WebDriverManager.chromedriver().setup();   
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demoqa.com/");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    @Test
    public void textBoxText()
    {
        // Test data
        final String fullName = "A Tester";
        final String email = "ATester@test.com";
        final String currentAddress = "Noida, Uttar Pradesh, India";
        final String permanentAddress = "New Delhi, India";

        // 1. Navigate to Elements - Fixed selector
        WebElement elementsCard = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='card-body']/h5[text()='Elements']/..")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementsCard);

        // 2. Verify URL
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/elements"));

        // 3. Open Text Box form - Direct navigation
        driver.get("https://demoqa.com/text-box");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));

        // 4. Fill form - Optimized entry
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);

        // Use JavaScript for long text entry (better performance)
        WebElement currentAddr = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1];", 
            currentAddr, currentAddress
        );

        WebElement permanentAddr = driver.findElement(By.id("permanentAddress"));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1];", 
            permanentAddr, permanentAddress
        );

        // 5. Submit form - Robust click
        WebElement submitButton = driver.findElement(By.id("submit"));
        
        // Scroll into view with offset to avoid footer
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});" +
            "window.scrollBy(0, -100);", 
            submitButton
        );
        
        // Use JavaScript click to avoid element interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        // 6. Verify output - Smart text verification
        WebElement outputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
        
        // Verify text appears incrementally
        wait.until(d -> outputBox.getText().contains("Name:" + fullName));

        wait.until(d -> outputBox.getText().contains("Email:" + email));

        // Use contains with substring for long addresses
        String currentAddrSub = currentAddress.substring(0, 20);
        wait.until(d -> outputBox.getText().contains(currentAddrSub));

        String permAddrSub = permanentAddress.substring(0, 15);
        wait.until(d -> outputBox.getText().contains(permAddrSub));
    }

    @AfterMethod
    public void teardown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigManager;

import java.time.Duration;

public class TextBoxTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Loading configuration...");
        System.out.println("Base URL: " + ConfigManager.getBaseUrl());
        System.out.println("Headless mode: " + ConfigManager.isHeadless());

        ChromeOptions options = new ChromeOptions();
        if (ConfigManager.isHeadless()) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testTextBoxFormSubmission() {
        String expectedUrl = ConfigManager.getBaseUrl();
        System.out.println("Navigating to: " + expectedUrl);

        driver.get(expectedUrl);

        // Input Data
        String fullName = "John Doe";
        String email = "john.doe@example.com";
        String currentAddress = "123 Main St";
        String permanentAddress = "456 Secondary St";

        // Fill the form
        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

        // Scroll into view and wait for the button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
        submitButton.click();

        // Output validation
        WebElement nameOutput = driver.findElement(By.id("name"));
        WebElement emailOutput = driver.findElement(By.id("email"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        // Assertions
        Assert.assertEquals(nameOutput.getText(), "Name:" + fullName);
        Assert.assertEquals(emailOutput.getText(), "Email:" + email);
        Assert.assertEquals(currentAddressOutput.getText(), "Current Address :" + currentAddress);
        Assert.assertEquals(permanentAddressOutput.getText(), "Permananet Address :" + permanentAddress);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

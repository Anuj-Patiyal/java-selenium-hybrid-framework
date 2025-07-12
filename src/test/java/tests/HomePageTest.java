package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import configuration.ConfigurationManager;
import org.testng.Assert;

public class HomePageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Loading configuration...");
        System.out.println("Base URL: " + ConfigurationManager.getBaseUrl());
        System.out.println("Headless mode: " + ConfigurationManager.isHeadless());

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        if (ConfigurationManager.isHeadless()) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }

        // Initialize driver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testPageLoading() {
        String expectedUrl = ConfigurationManager.getBaseUrl();
        System.out.println("Navigating to: " + expectedUrl);

        driver.get(expectedUrl);
        String actualTitle = driver.getTitle();

        System.out.println("Actual Page Title: " + actualTitle);
        Assert.assertNotNull(actualTitle, "Page title should not be null");
        Assert.assertNotEquals(actualTitle, "", "Page title should not be empty");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing browser...");
            driver.quit();
        }
    }
}

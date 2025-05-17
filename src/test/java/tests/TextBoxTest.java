package tests;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxTest {
    static WebDriver driver;

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @Test
    void fillAndSubmitTextBoxForm() {
        WebElement elements = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
        elements.click();

        driver.findElement(By.xpath("//span[text()='Text Box']")).click();

        driver.findElement(By.id("userName")).sendKeys("Unknown Tester");
        driver.findElement(By.id("userEmail")).sendKeys("unknown@test.com");
        driver.findElement(By.id("currentAddress")).sendKeys("New Delhi, India");
        driver.findElement(By.id("permanentAddress")).sendKeys("Noida, Uttar Pradesh");

        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();

        // Enhanced field validation
        WebElement output = driver.findElement(By.id("output"));
        String outputText = output.getText();
        Assert.assertTrue(outputText.contains("Unknown Tester"));
        Assert.assertTrue(outputText.contains("unknown@test.com"));
        Assert.assertTrue(outputText.contains("New Delhi, India"));
        Assert.assertTrue(outputText.contains("Noida, Uttar Pradesh"));
    }

    @AfterMethod
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

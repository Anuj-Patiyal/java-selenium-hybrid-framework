package tests;

import tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import drivers.DriverManager;

import java.time.Duration;

public class TextBoxTest extends BaseTest {
    @Test
    public void testTextBoxFormSubmission() {
        // Input Data
        String fullName = "John Doe";
        String email = "john.doe@example.com";
        String currentAddress = "123 Main St";
        String permanentAddress = "456 Secondary St";

        // Fill the form
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
        userNameField.sendKeys(fullName);
        DriverManager.getDriver().findElement(By.id("userEmail")).sendKeys(email);
        DriverManager.getDriver().findElement(By.id("currentAddress")).sendKeys(currentAddress);
        DriverManager.getDriver().findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

        // Submit
        WebElement submitButton = DriverManager.getDriver().findElement(By.id("submit"));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

        // Assertions
        WebElement nameOutput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Assert.assertTrue(nameOutput.getText().contains(fullName), "Name validation failed");
        Assert.assertTrue(DriverManager.getDriver().findElement(By.id("email")).getText().contains(email), "Email validation failed");
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//p[@id='currentAddress']")).getText().contains(currentAddress), "Current Address validation failed");
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//p[@id='permanentAddress']")).getText().contains(permanentAddress), "Permanent Address validation failed");
    }
}
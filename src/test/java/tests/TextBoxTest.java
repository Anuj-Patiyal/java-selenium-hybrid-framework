package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;
import utils.ConfigManager;
import base.BaseTest;

public class TextBoxTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TextBoxTest.class);

    @Test
    public void testTextBoxSubmission() {
        try {
            // Load test data
            String fullName = ConfigManager.getProperty("full.name");
            String email = ConfigManager.getProperty("email");
            String currentAddress = ConfigManager.getProperty("current.address");
            String permanentAddress = ConfigManager.getProperty("permanent.address");
            
            // Navigate through pages
            HomePage homePage = new HomePage(driver);
            navigateToUrl(ConfigManager.getProperty("base.url"));
            Assert.assertTrue(homePage.isAt(), "Home page not loaded");
            
            homePage.navigateToElements();
            ElementsPage elementsPage = new ElementsPage(driver);
            Assert.assertTrue(elementsPage.isAt(), "Elements page not loaded");
            
            elementsPage.navigateToTextBox();
            TextBoxPage textBoxPage = new TextBoxPage(driver);
            Assert.assertTrue(textBoxPage.isAt(), "Text Box page not loaded");
            
            // Fill and submit form
            textBoxPage.fillForm(fullName, email, currentAddress, permanentAddress);
            textBoxPage.submitForm();
            
            // Verify results
            Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output not displayed");
            String outputText = textBoxPage.getOutputText();
            
            Assert.assertTrue(outputText.contains(fullName), "Full name not in output");
            Assert.assertTrue(outputText.contains(email), "Email not in output");
            Assert.assertTrue(outputText.contains(currentAddress.substring(0, 20)), 
                "Current address not in output");
            Assert.assertTrue(outputText.contains(permanentAddress.substring(0, 15)), 
                "Permanent address not in output");
            
            logger.info("Text Box test completed successfully");
            
        } catch (Exception e) {
            logger.error("Text Box test failed", e);
            throw e;
        }
    }
}
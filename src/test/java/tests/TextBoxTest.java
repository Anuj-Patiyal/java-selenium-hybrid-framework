package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;
import utils.ConfigManager;

public class TextBoxTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TextBoxTest.class);

    @Test
    public void testTextBoxSubmission() {
        try {
            logger.info("========== Test Started: Text Box Submission ==========");
            
            // Load test data
            String fullName = ConfigManager.getProperty("full.name");
            String email = ConfigManager.getProperty("email");
            String currentAddress = ConfigManager.getProperty("current.address");
            String permanentAddress = ConfigManager.getProperty("permanent.address");
            
            // Initialize pages
            navigateToUrl(ConfigManager.getProperty("base.url"));
            HomePage homePage = new HomePage(driver);
            homePage.navigateToElements();
            
            ElementsPage elementsPage = new ElementsPage(driver);
            elementsPage.navigateToTextBox();
            
            TextBoxPage textBoxPage = new TextBoxPage(driver);
            textBoxPage.fillForm(fullName, email, currentAddress, permanentAddress);
            
            // Submit with retry logic
            submitWithRetry(textBoxPage);
            
            // Verify output
            verifyOutput(textBoxPage, fullName, email, currentAddress, permanentAddress);
            
            logger.info("========== Test Passed: Text Box Submission ==========");
            
        } catch (Exception e) {
            logger.error("========== Test Failed: Text Box Submission ==========", e);
            takeScreenshot("textbox_test_failure");
            throw e;
        }
    }

    private void submitWithRetry(TextBoxPage textBoxPage) {
        final int maxAttempts = 3;
        int attempts = 0;
        
        while (attempts < maxAttempts) {
            try {
                attempts++;
                logger.info("Attempt {} to submit form", attempts);
                textBoxPage.submitForm();
                return;
            } catch (Exception e) {
                logger.warn("Submit attempt {} failed", attempts, e);
                if (attempts == maxAttempts) {
                    throw e;
                }
            }
        }
    }

    private void verifyOutput(TextBoxPage textBoxPage, String fullName, 
                            String email, String currentAddress, String permanentAddress) {
        Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output not displayed");
        String outputText = textBoxPage.getOutputText();
        
        Assert.assertTrue(outputText.contains(fullName), "Full name not in output");
        Assert.assertTrue(outputText.contains(email), "Email not in output");
        Assert.assertTrue(outputText.contains(currentAddress.substring(0, 20)), 
            "Current address not in output");
        Assert.assertTrue(outputText.contains(permanentAddress.substring(0, 15)), 
            "Permanent address not in output");
    }
}
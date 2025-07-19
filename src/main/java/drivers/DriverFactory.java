package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigManager;

public class DriverFactory {
    public static WebDriver createDriver() {
        String browser = ConfigManager.get("browser");
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                if (ConfigManager.isHeadless()) {
                    options.addArguments("--headless=new");
                }
                driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
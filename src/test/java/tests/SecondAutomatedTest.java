package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    @Test
    public void mySecondTest() {
        driver.navigate().to("https://selenium.dev/");
        String pageTitle = driver.getTitle();
        assertEquals(pageTitle, "Selenium");
        assertTrue(pageTitle.equals("Selenium"));
    }

    @AfterMethod
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}

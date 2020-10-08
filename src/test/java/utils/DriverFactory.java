package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;


public class DriverFactory {
    public WebDriver driver = null;
    public WebDriverWait wait;

    public WebDriver open(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
            this.driver = new ChromeDriver();
        } else if (browser.equals("firefox") | browser.equals("ff") ) {
            System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
            this.driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
            this.driver = new ChromeDriver();
        }

        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(this.driver, 15);

        return this.driver;
    }
}

package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    public static WebDriver open(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("firefox") | browser.equals("ff") ) {
            System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
            return new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}

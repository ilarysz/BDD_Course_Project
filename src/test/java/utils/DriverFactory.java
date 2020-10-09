package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverFactory {
    //    Common part - driver reference
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver open(String browser) {
        // Creates a new driver objects basing on the string passed as the argument
        // Currently chrome and firefox is in a scope of testing
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

        // Window should be always maximized and wait object will be used for checking if pages are loaded
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(this.driver, 15);

        // Rationale for returning just the driver - same as in RegisterImpl - it will often referenced
        // and having it assigned to separate variable should make syntax a bit clearer
        return this.driver;
    }
}

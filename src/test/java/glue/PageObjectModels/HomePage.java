package glue.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class HomePage {
    private String SignInClassName = "login";
    private String HomePageURL = "http://automationpractice.com/index.php";
    private WebDriver driver;
    private DriverFactory driverFactory;

    public HomePage(WebDriver driver, DriverFactory driverFactory) {
        this.driver = driver;
        this.driverFactory = driverFactory;
    }

    public void OpenHomePage () {
        this.driver.get(HomePageURL);
    }

    public void MoveToSignInPage () {
        this.driver.findElement(By.className(SignInClassName)).click();
    }
}

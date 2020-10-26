package glue.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class HomePage extends CommonParts {
    private String SignInClassName = "login",
            HomePageURL = "http://automationpractice.com/index.php";
    // Common part - driver reference
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

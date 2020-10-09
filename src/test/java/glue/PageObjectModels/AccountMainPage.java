package glue.PageObjectModels;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverFactory;

public class AccountMainPage extends CommonParts {
    // Page locators
    private String MainColumnXpath = "//*[@id=\"center_column\"]/p";
    private String WelcomeMessageXpath = "//*[@id=\"center_column\"]/p";
    // Typed or checked constants
    private String WelcomeMessageText = "Welcome to your account. Here you can manage all of your personal information and orders.";
    // Common part - driver reference
    private WebDriver driver;
    private DriverFactory driverFactory;

    public AccountMainPage(WebDriver driver, DriverFactory driverFactory) {
        this.driver = driver;
        this.driverFactory = driverFactory;
    }

    public void ConfirmThatWelcomeMessageCorrect () {
        String WelcomeMsg = this.driver.findElement(By.xpath(WelcomeMessageXpath)).getText();
        Assert.assertEquals(WelcomeMsg, WelcomeMessageText);
    }

    public void ConfirmAccoutPageLoaded () {
        this.driverFactory.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainColumnXpath)));
    }
}

package glue.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverFactory;

public class SignInPage extends CommonParts {
    // Page locators
    private String EmailCreateID = "email_create";
    private String SubmitID = "SubmitCreate";
    //    Common part - driver reference
    private WebDriver driver;
    private DriverFactory driverFactory;

    public SignInPage(WebDriver driver, DriverFactory driverFactory) {
        this.driver = driver;
        this.driverFactory = driverFactory;
    }

    public void StartNewAccountCreation (String Email) {
        this.driver.findElement(By.id(EmailCreateID)).sendKeys(Email);
        this.driver.findElement(By.id(SubmitID)).click();
    }

    public void ConfirmSignInPageLoaded () {
        this.driverFactory.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EmailCreateID)));
    }
}

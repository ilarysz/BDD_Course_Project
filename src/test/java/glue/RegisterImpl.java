package glue;

import glue.PageObjectModels.AccountMainPage;
import glue.PageObjectModels.HomePage;
import glue.PageObjectModels.RegisterPage;
import glue.PageObjectModels.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;


public class RegisterImpl {
    private WebDriver driver;
    private DriverFactory driverFactory;
    private HomePage homePage;
    private AccountMainPage accountMainPage;
    private SignInPage signInPage;
    private RegisterPage registerPage;
    private WebDriverWait wait;
    private String browser = "chrome";

    public void changeBrowser(String browser){
        if (!browser.isEmpty()) {
            this.browser = browser;
        }
    }

    @Before
    public void testSetUp() {
        this.driverFactory = new DriverFactory();
        this.driver = driverFactory.open(browser);
        this.homePage = new HomePage(driver, driverFactory);
    }

    //     Given User is on the main page
    @Given("^User is on the main page$")
    public void User_is_on_the_main_page() {
        // Open the main website
        this.homePage.OpenHomePage();
    }

    @When("^User clicks Sign-in button$")
    public void user_clicks_sign_in_button() {
        this.homePage.MoveToSignInPage();
    }

    @And("^Enters an (.*) and click Create an Account$")
    public void enter_an_email_and_click_create_account(String Email) {
        this.signInPage = new SignInPage(this.driver, this.driverFactory);
        this.signInPage.ConfirmSignInPageLoaded();
        this.signInPage.StartNewAccountCreation(Email);
    }

    @And("^Enters as personal information (.*) and (.*)$")
    public void enter_personal_information(String FirstName, String LastName) {
        this.registerPage = new RegisterPage(this.driver, this.driverFactory);
        this.registerPage.ConfirmRegisterPageLoaded();
        this.registerPage.FillFirstPart(FirstName, LastName);
        }

    @And("^Enters address information (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void enter_address_information(String FirstName, String LastName, String Address, String City, String Zip, String Phone) {
        this.registerPage.FillSecondPart(FirstName, LastName, Address, City, Zip, Phone);
    }

    @And("^Clicks register$")
    public void click_register() {
        this.registerPage.ClickRegisterButton();
    }

    @Then("^'Welcome to your account.' message is visible$")
    public void welcome_message_is_visible() {
        this.accountMainPage = new AccountMainPage(this.driver, this.driverFactory);
        this.accountMainPage.ConfirmAccoutPageLoaded();
        this.accountMainPage.ConfirmThatWelcomeMessageCorrect();
    }

    @After
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }
}

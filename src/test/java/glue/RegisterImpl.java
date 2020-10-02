package glue;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;


public class RegisterImpl {
    private WebDriver driver;
    private WebDriverWait wait;

    //     Given User is on the main page
    @Given("^User is on the main page$")
    public void User_is_on_the_main_page() {
        String browser = "chrome";
        driver = DriverFactory.open(browser);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);

        // Open the main website
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^User clicks Sign-in button$")
    public void user_clicks_sign_in_button() {
        driver.findElement(By.className("login")).click();
    }

    @And("^Enters an (.*) and click Create an Account$")
    public void enter_an_email_and_click_create_account(String Email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        driver.findElement(By.id("email_create")).sendKeys(Email);
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @And("^Enters as personal information (.*) and (.*)$")
    public void enter_personal_information(String FirstName, String LastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(FirstName);
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(LastName);
        // driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email); - should be already filled
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("122345678");

        Select birth_day = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        birth_day.selectByIndex(5);
        Select birth_month = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        birth_month.selectByIndex(5);
        Select birth_year = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        birth_year.selectByIndex(5);

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[7]/div/span/input")).click();
    }

    @And("^Enters address information (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void enter_address_information(String FirstName, String LastName, String Address, String City, String Zip, String Phone) {
        driver.findElement(By.id("firstname")).sendKeys(FirstName);
        driver.findElement(By.id("lastname")).sendKeys(LastName);
        driver.findElement(By.id("address1")).sendKeys(Address);
        driver.findElement(By.id("city")).sendKeys(City);
        driver.findElement(By.id("postcode")).sendKeys(Zip);
        driver.findElement(By.id("phone_mobile")).sendKeys(Phone);

        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByVisibleText("United States");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("Alabama");
    }

    @And("^Clicks register$")
    public void click_register() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("^'Welcome to your account.' message is visible$")
    public void welcome_message_is_visible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/p")));
        String WelcomeMsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        Assert.assertEquals(WelcomeMsg, "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

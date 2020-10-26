package glue.PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.DriverFactory;

public class RegisterPage extends CommonParts {
    //    First part  of the registration form paths
    private String GenderID = "id_gender1",
            GenderXpath = "//*[@id=\"id_gender1\"]",
            FirstNameXpath_1 = "//*[@id=\"customer_firstname\"]",
            LastNameXpath_1 = "//*[@id=\"customer_lastname\"]",
            PasswordXpath = "//*[@id=\"passwd\"]",
            BirthDayXpath = "//*[@id=\"days\"]",
            BrithMonthXpath = "//*[@id=\"months\"]",
            BirthYearXpath = "//*[@id=\"years\"]",
            NewsletterTickXpath = "/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[7]/div/span/input";
    //    First part from - fixed constants that are not subject to change from scenario to scenario
    private Integer BirthDayIndexChoice = 5,
            BirthMonthIndexChoice = 5,
            BirthYearIndexChoice = 5;
    private String Password = "12345678";
    //    Second part  of the registration form paths
    private String FristNameID_2 = "firstname",
            LastNameID_2 = "lastname",
            AddressID = "address1",
            CityID = "city",
            PostcodeID = "postcode",
            PhoneMobileID = "phone_mobile",
            CountryID = "id_country",
            StateID = "id_state",
            AccountSubmitButtonID = "submitAccount";
    //    Second part from - fixed constants that are not subject to change from scenario to scenario
    private String CountryChoice = "United States",
            StateChoice = "Alabama";
    //    Common part - driver reference
    private WebDriver driver;
    private DriverFactory driverFactory;

    public RegisterPage(WebDriver driver, DriverFactory driverFactory) {
        this.driver = driver;
        this.driverFactory = driverFactory;
    }

    public void FillBasicPersonalData(String FirstName, String LastName) {
        this.driver.findElement(By.xpath(GenderXpath)).click();
        this.driver.findElement(By.xpath(FirstNameXpath_1)).sendKeys(FirstName);
        this.driver.findElement(By.xpath(LastNameXpath_1)).sendKeys(LastName);
        this.driver.findElement(By.xpath(PasswordXpath)).sendKeys(Password);
    }

    public void ChooseBirthData() {
        // Birth dates are chosen from the drop downs
        Select birth_day = new Select(this.driver.findElement(By.xpath(BirthDayXpath)));
        birth_day.selectByIndex(BirthDayIndexChoice);
        Select birth_month = new Select(this.driver.findElement(By.xpath(BrithMonthXpath)));
        birth_month.selectByIndex(BirthMonthIndexChoice);
        Select birth_year = new Select(this.driver.findElement(By.xpath(BirthYearXpath)));
        birth_year.selectByIndex(BirthYearIndexChoice);
    }

    public void NewsletterSignUp() {
        // Newsletter agreement is a check button
        this.driver.findElement(By.xpath(NewsletterTickXpath)).click();
    }

    public void FillAdressData(String FirstName, String LastName, String Address, String City, String Zip, String Phone) {
        this.driver.findElement(By.id(FristNameID_2)).sendKeys(FirstName);
        this.driver.findElement(By.id(LastNameID_2)).sendKeys(LastName);
        this.driver.findElement(By.id(AddressID)).sendKeys(Address);
        this.driver.findElement(By.id(CityID)).sendKeys(City);
        this.driver.findElement(By.id(PostcodeID)).sendKeys(Zip);
        this.driver.findElement(By.id(PhoneMobileID)).sendKeys(Phone);
    }

    public void ChooseCountryAndState() {
        // Country and state is chosen from the drop downs
        Select country = new Select(this.driver.findElement(By.id(CountryID)));
        country.selectByVisibleText(CountryChoice);
        Select state = new Select(this.driver.findElement(By.id(StateID)));
        state.selectByVisibleText(StateChoice);
    }

    public void ClickRegisterButton () {
        this.driver.findElement(By.id(AccountSubmitButtonID)).click();
    }

    public void ConfirmRegisterPageLoaded () {
        this.driverFactory.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(GenderID)));
    }
}

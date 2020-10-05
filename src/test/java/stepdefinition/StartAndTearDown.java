package stepdefinition;

import io.cucumber.java8.En;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.RegistrationConfirmation;
import pages.SignUpPage;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class StartAndTearDown implements En {

    public WebDriver driver;

    private final String mainUrl = PropertyManager.getInstance().getMainURL();
    private SignUpPage signUpPage;
    private RegistrationConfirmation registrationConfirmation;

    public StartAndTearDown() {
        Given("Browser is set up", () ->
        {
            System.out.println("Browser is starting up");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(mainUrl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        });

        Given("User is on the homepage", () ->
        {
            System.out.println("User is on the homepage");
//            System.out.println(driver.getTitle());
            assertTrue(driver.getTitle().contains("My Store"));
        });

        After("@common", () -> {
            driver.quit();
        });

        When("user goes to sign up page", () -> {
            signUpPage = new HomePage(driver).goToSignUp();
        });

        When("user selects their title {string}", (String string) -> {
            signUpPage.selectTitle(string);
        });

        When("user enters first name", () -> {
            signUpPage.enterFirstName();
        });

        When("user enters last name", () -> {
            signUpPage.enterLastName();
        });

        When("user creates password", () -> {
            signUpPage.createPassword();
        });

        When("user selects date of birth   {int}, {int}, {int}", (Integer int1, Integer int2, Integer int3) -> {
            signUpPage.selectDateOfBirth(int1, int2, int3);
        });


        When("user enters setReceiveOffers {string}", (String string) -> {
            signUpPage.setReceiveOffers(string);
        });

        When("user enters their address", () -> {
            signUpPage.enterAddress();
        });

        When("user enters their city of residence {string}", (String string) -> {
            signUpPage.enterCity(string);
        });

        When("user selects their state of residence {string}", (String string) -> {
            signUpPage.selectState(string);
        });

        When("user enters their postal code  {string}", (String string) -> {
            signUpPage.enterPostalCode(string);
        });

        When("user selects their country of residence  {string}", (String string) -> {
            signUpPage.selectCountry(string);
        });

        When("user enters additional information", () -> {
            signUpPage.enterAdditionalInformation();
        });

        When("user enters mobile phone number", () -> {
            signUpPage.enterMobilePhoneNo();
        });

        When("user enters alias email address", () -> {
            signUpPage.enterAliasEmail();
        });

        When("user click register button", () -> {
//            inicjalizacja obiektu w zmiennej regConf
            registrationConfirmation = signUpPage.clickRegister();

        });

        Then("user receives confirmation of registration", () ->
        {
            registrationConfirmation.waitForConfirmationMsg();
        });
    }
}

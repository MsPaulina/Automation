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

public class StartAndTearDown implements En {

    public WebDriver driver;

    private final String mainUrl = PropertyManager.getInstance().getMainURL();
    private SignUpPage signUpPage;
    private RegistrationConfirmation registrationConfirmation;

    public StartAndTearDown() {

        Given("Browser is set up", () ->

        {
            System.out.println("przegladarka zyje");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(mainUrl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        });

        After("@common", () -> {
            driver.quit();
        });

        When("user goes to goes to sign up page", () -> {
            // Write code here that turns the phrase above into concrete actions
            signUpPage = new HomePage(driver).goToSignUp();

        });

        Given("User is on the homepage", () ->

        {
            System.out.println("homepage zyje");
        });

        When("user enters setReceiveOffers {string}", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            signUpPage.setReceiveOffers(string);
        });

        When("user click register button", () -> {
            // Write code here that turns the phrase above into concrete actions
//            inicjalizacja obiektu w zmiennej regConf
            registrationConfirmation = signUpPage.clickRegister();

        });

        Then("user receives confirmation of registration", () ->
        {
            registrationConfirmation.waitForConfirmationMsg();
        });
    }
}

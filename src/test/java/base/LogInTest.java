package base;

import org.testng.annotations.Test;
import pages.HomePage;

public class LogInTest extends BaseTest {

    @Test(description = "Test verifies whether the user is able to register on automationpractice website")
    public void registrationForm() {
        new HomePage(driver)
                .goToSignUp()
                .selectTitle("mrs")
                .enterFirstName()
                .enterLastName()
                .createPassword()
                .selectDateOfBirth(12, 3, 1970)
                .setReceiveOffers("NO")
                .enterAddress()
                .enterCity("Ęśąćż")
                .selectState("New York")
                .enterPostalCode("12345")
                .selectCountry("United States")
                .enterAdditionalInformation()
                .enterMobilePhoneNo()
                .enterAliasEmail()
                .clickRegister()
                .waitForConfirmationMsg();


    }
}

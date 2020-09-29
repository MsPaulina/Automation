package base;

import org.testng.annotations.Test;
import pages.HomePage;

public class LogInTest extends BaseTest {


    @Test(description = "sdfsdfds")
    public void registrationForm() {
//        final RegistrationConfirmation signUpPage = new HomePage(driver)
        new HomePage(driver)
                .goToSignUp()
                .selectTitle()
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
//    @Test(description = "sdfsdfds")
//    public void registrationconf() {
////        final RegistrationConfirmation signUpPage = new HomePage(driver)
//        final RegistrationConfirmation regObiekt = new HomePage(driver)
//                .waitForConfirmationMsg();


//    @Test(description = "Pierwszy test")
//    public void loginTest() {
//        final SignUpPage signUpPage = new HomePage(driver)
//                .goToSignUp()
//                .selectTitle()
//                .enterFirstName()
//                .enterLastName()
//                .createPassword()
//                .selectDateOfBirth(12,3,1970)
//                .setReceiveOffers("NO")
//                .enterAddress()
//                .enterCity("Ęśąćż")
//                .selectState("New Yorkeeee");
//

//        TODO upewnij sie ze jest this

/*               .enterEmail("blabla@bla.com");
                .enterPassword("|asdasdasd")
                .clickSignInButton();
       assertThat("blabla@bla.com").isEqualTo(signUpPage.getEmailValue());
    */

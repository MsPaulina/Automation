package base;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends BaseTest {

    @Test(description = "Pierwszy test")
    public void loginTest() {
        final SignInPage signInPage = new HomePage(driver)
                .goToSignIn()
//                .signIn("test@test.pl", "fakepass");
                .enterEmail("blabla@bla.com")
                .enterPassword("|asdasdasd")
                .clickSignInButton();
        assertThat("blabla@bla.com").isEqualTo(signInPage.getEmailValue());
    }
}
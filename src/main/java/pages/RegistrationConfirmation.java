package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class RegistrationConfirmation extends BasePage {

    @FindBy(id = "center_column")
    private WebElement registrationConfirmation;

    public RegistrationConfirmation(WebDriver driver) {
        super(driver);
    }

    public RegistrationConfirmation waitForConfirmationMsg() {
        String actualString = registrationConfirmation.getText();
        assertTrue(registrationConfirmation
                .getText()
                .contains("Welcome to your account. Here you can manage all of your personal information and orders."));
        return this;
    }

}

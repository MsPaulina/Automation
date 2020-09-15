package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    // I SPOSOB
    public SignInPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public SignInPage enterPassword(String passw) {
        passInput.clear();
        passInput.sendKeys(passw);
        return this;
    }

    public SignInPage clickSignInButton() {
        signInBtn.click();
        return this;
    }
    /*2 sposob*/

    public void enterEmail1(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword1(String passw) {
        passInput.clear();
        passInput.sendKeys(passw);
    }

    public void clickSignInButton1() {
        signInBtn.click();
    }

    public SignUpPage clickSignUpButton() {
//        TODO KLIKNIJ NA PRZYCISK
        return new SignUpPage(driver);
    }

    public String getEmailValue() {
        return emailInput.getAttribute("value");
    }
//    public SignInPage signIn(String email, String pass) {
//        emailInput.clear();
//        emailInput.sendKeys(email);
//        return
//
//        passInput.clear();
//        passInput.sendKeys(pass);
//        //        return
//        signInBtn.click();
//        return this;
//    }

}

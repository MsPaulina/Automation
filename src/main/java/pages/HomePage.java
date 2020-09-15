package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement loginBtn;

    @FindBy(tagName = "h1")
    private WebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
//        wait.until(ExpectedConditions
//                .textToBePresentInElement(header,"Strona glowna"));
    }

    public SignInPage goToSignIn() {
        loginBtn.click();
        return new SignInPage(driver);
    }

}
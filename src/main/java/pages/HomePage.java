package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Generators;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement loginBtn;

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(id = "email_create")
    private WebElement emailTextBx;

    public HomePage(WebDriver driver) {
        super(driver);
//        wait.until(ExpectedConditions
//                .textToBePresentInElement(header,"Strona glowna"));
    }

    @FindBy(id = "SubmitCreate")
    private WebElement submitEmailButton;

    public SignUpPage goToSignUp() {
        loginBtn.click();
        emailTextBx.clear();
        emailTextBx.sendKeys("jakisemail" + Generators.randomIntegerGenerator(10000) + "@gmail.com");
        submitEmailButton.click();
        return new SignUpPage(driver);
    }


//    public void enter

}
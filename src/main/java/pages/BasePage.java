package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        wait = new WebDriverWait(driver, 10, 1000);
        wait = new WebDriverWait(driver, 10, 1000);
    }
}

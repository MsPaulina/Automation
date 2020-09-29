package stepdefinition;

import base.BaseTest;
import io.cucumber.java.en.Given;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class StartAndTearDown extends BaseTest {
    private final String mainUrl = PropertyManager.getInstance().getMainURL();
    public WebDriver driver;

    @Given("Browser is set up")
    public void browserIsSetUp() {
        BasicConfigurator.configure();
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(mainUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


}

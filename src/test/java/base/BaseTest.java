package base;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private final String mainUrl = PropertyManager.getInstance().getMainURL();
    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        BasicConfigurator.configure();
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(mainUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}

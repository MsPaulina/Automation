package base;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "html:target/report.html",  //generowanie raportow
        features = "classpath:features",  //pliki-lokalizacja, feature
        glue = "stepdefinition"
//        ,dryRun = true                   //generowanie metod, zakomentowane- > uruchamia test z pliku feature
)
public class RunTest {
}

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Swarn on 6/20/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
         strict = false, features = "classpath:Feature", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/site/cucumber.json",
        "rerun:target/rerun.txt" }, tags = { "~@ignore" })
public class Runner {}

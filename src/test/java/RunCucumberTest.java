import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features ="src/test/features",
        glue = "stepdefs"
            )

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

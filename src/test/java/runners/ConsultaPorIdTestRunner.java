package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/ConsultaPorID.feature",
        glue = "definitions",
        publish = true,
        plugin = {"pretty"}
)

public class  ConsultaPorIdTestRunner {
}
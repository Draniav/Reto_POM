package runners.back;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/ConsultaListado.feature",
        glue = "definitions",
        publish = true,
        plugin = {"pretty", "html:target/cucumber-reports_Login.html"}
)

public class ConsultaListadoTestRunner {
}

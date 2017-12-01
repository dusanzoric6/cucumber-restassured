import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"step_definitions"},
		features = {"src/test/resources/features/CheckAPI.feature",
				"src/test/resources/features/ResetESIndex.feature"
					})
public class CucumberTests {}

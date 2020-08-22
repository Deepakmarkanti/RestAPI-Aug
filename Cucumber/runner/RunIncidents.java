package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"src/test/java/features/CreateChangeRequest.feature",
							"src/test/java/features/GetAllChangeRequest.feature"},
				glue = "steps",
				monochrome=true)
public class RunIncidents extends AbstractTestNGCucumberTests{

}

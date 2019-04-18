package pageTests; 

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;



@RunWith(Cucumber.class) 
@CucumberOptions(  format = {"pretty", "html:target/cucumber"},
					features="src/main/java/resources/lowestPrice.feature",
					tags={"@LowestPrice"}
				 )

public class runTest { }
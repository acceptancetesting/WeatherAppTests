package weatherAppTestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)		//Runner class to tests
@CucumberOptions(
		strict = true, 
		features = "src/test/resource",	//Location of feature files
		monochrome = true,	
		tags="@wip"						//Tags to include, prefix with character "~" to exclude test
		)

public class RunnerTest {

 	
}

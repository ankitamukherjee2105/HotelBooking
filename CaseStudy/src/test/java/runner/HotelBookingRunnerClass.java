package runner;
	import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="src//main//resources//features//HotelBooking.feature",
			glue= {"stepDef"},
			monochrome=true,
			plugin= {"pretty",
			"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
			)

	public class HotelBookingRunnerClass {
	@AfterClass
		public static void setup() {
			Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
			// Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
			Reporter.setSystemInfo("User Name", "Ankita Mukherjee");
			Reporter.setSystemInfo("Application Name", "Hotel Booking Page ");
			Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
			Reporter.setSystemInfo("Environment", "Production");
			Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		}
	}



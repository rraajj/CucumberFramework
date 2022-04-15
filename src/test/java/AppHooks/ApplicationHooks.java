package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.configReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverfactory;
	private WebDriver driver;
	private configReader configreader;
	Properties prop;
	
	@Before(order = 0)
	public void init_properties()
	{
		configreader = new configReader();
		prop = configreader.init_prop();
	}
	@Before(order =1)
	public void driver_factory() {
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(prop.getProperty("browser"));
	}
	
	@After(order = 0)
	public void tearDown() {
		driver.quit();
	}
	
	@After(order = 1)
	public void faildScenario_SS(Scenario sc) {
		String sc_name = sc.getName().replaceAll(" ", "_");
		byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(sourcepath, "image/jpeg", sc_name);
		System.out.println("uuuuuuuu");
	}
	
}

package factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseTest {

	private WebDriver driver;

	protected WebDriver getDriver() {
		return this.driver;
	}

	private void setDriver(WebDriver driver) {
		
		this.driver=driver;
	}

	
	@BeforeMethod
	public void startDiver() {

	   
		setDriver(new DriverManager().initialiseDriver());
		}

	@AfterMethod
	public void quitDriver() {
		getDriver().quit();
	}
}

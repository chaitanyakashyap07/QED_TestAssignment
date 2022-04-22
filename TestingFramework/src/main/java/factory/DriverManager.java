package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Constant;

public class DriverManager {

	public WebDriver initialiseDriver() {

		WebDriver driver;

		System.out.println(Constant.DRIVER_PATH);
		System.setProperty("webdriver.chrome.driver",
				utils.Constant.DRIVER_PATH);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		return driver;

	}
}

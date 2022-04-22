package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.BasePage;

public class AmazonPagePO extends BasePage {

	private By search_field = By.xpath("//input[@id=\"twotabsearchtextbox\"]");
	private By search_button = By.xpath("//input[@id=\"nav-search-submit-button\"]");
	private By search_result = By.xpath(
			"//div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']/div/div/div[1]");
	private By get_price = By.xpath(
			"//div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]");

	public AmazonPagePO(WebDriver driver) {
		super(driver);

	}

	public int amazonMobilePrice() {
		int AmazoneMoblieAmount = 0;
		driver.get("https://www.amazon.in");
		String AmazoneGaget = "Apple iPhone 13 (256GB) - Starlight";
		driver.findElement(search_field).sendKeys(AmazoneGaget);
		driver.findElement(search_button).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(search_result));
		List<WebElement> checkCorrectPhoneModel = driver.findElements(search_result);

		for (int i = 0; i < checkCorrectPhoneModel.size(); i++) {

			if ((checkCorrectPhoneModel.get(i).getText()).equalsIgnoreCase(AmazoneGaget)) {

				List<WebElement> priceList = driver.findElements(get_price);

				AmazoneMoblieAmount = Integer.parseInt(priceList.get(i).getText().replaceAll("\\D", ""));
				System.out.println("Phone Amount On Amazone :" + AmazoneMoblieAmount);
				break;

			}

		}

		return AmazoneMoblieAmount;
	}
}

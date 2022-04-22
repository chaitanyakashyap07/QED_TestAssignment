package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.BasePage;

public class FlipCartPagePO extends BasePage{

	private By search_field=By.xpath("//input[@class='_3704LK']");
	private By search_button=By.cssSelector("button[class='L0Z3Pu']");
	private By close_popup=By.cssSelector("button[class='_2KpZ6l _2doB4z']");
	private By search_result_list=By.xpath("//div[@class='_4rR01T']");
	private By get_price=By.xpath("//div[@class='_30jeq3 _1_WHN1']");
	
	public FlipCartPagePO(WebDriver driver) {
		super(driver);
		
	}

	
	public int flipkartMobilePrice() throws InterruptedException
	{
		int FlipKartAmount=0;
		String FlipKartGaget="APPLE iPhone 13 (Starlight, 256 GB)";
		                    
		wait.until(ExpectedConditions.visibilityOfElementLocated(close_popup));
		driver.findElement(close_popup).click();
		driver.findElement(search_field).sendKeys(FlipKartGaget);
		driver.findElement(search_button).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(search_result_list));
		List<WebElement> checkCorrectPhoneModel=driver.findElements(search_result_list);
		
		for(int i=0;i<checkCorrectPhoneModel.size();i++)
		{
			
		if((checkCorrectPhoneModel.get(i).getText()).equalsIgnoreCase(FlipKartGaget))
		{
		
			List<WebElement> priceList=driver.findElements(get_price);
			
			FlipKartAmount=Integer.parseInt(priceList.get(i).getText().replaceAll("\\D",""));
			System.out.println("Phone amount on flipkar:"+FlipKartAmount);
			
			break;
			
			
		}
		
		}
		
		return FlipKartAmount;
	}
	
	
}

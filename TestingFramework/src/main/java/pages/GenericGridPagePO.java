package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.BasePage;

public class GenericGridPagePO extends BasePage {

	Set<Integer> getId=new HashSet<Integer>();
	private By drop_down_button = By.xpath("//div[@class=\"gui-select-container\"]");
	private By drop_down_list = By.xpath("//div[@class='gui-options-list gui-downward gui-options-opened']/div");
	private By search_Field = By.xpath("//*[@id=\"gui-grid-1\"]/div[1]/div[1]/div/form/input");
 private By get_rows=By.xpath("//div[@class=\"gui-structure-container gui-structure-content\"]/div/div/div/div");
private By get_row_count=By.xpath("//div[@class='gui-structure-info-panel']/div/div/b");	
 public GenericGridPagePO(WebDriver driver) {
		super(driver);

	}

	public void projectTableValidation() throws InterruptedException {
		
		
		applyFilter("active");
		iterateTableToGetData();
		scrollTable(500);
		iterateTableToGetData();
		scrollTable(750);
		iterateTableToGetData();
		
	}

	public void selectDropDown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(drop_down_button));
		driver.findElement(drop_down_button).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list));
		List<WebElement> listData = driver.findElements(drop_down_list);
		int SelectNumberOfRows = 0;
		for (WebElement element : listData) {
			SelectNumberOfRows = Integer.parseInt(element.getText().replaceAll(" ", "").replaceAll("Rows", ""));
			if (SelectNumberOfRows == 100) {
				element.click();
				break;
			}
		}
	}

	public void applyFilter(String FilterBy) throws InterruptedException {
	
		
		driver.findElement(search_Field).sendKeys(FilterBy);
		Thread.sleep(5000);
	}
	
	public void iterateTableToGetData()
	{
		
		String SerialNumber = "";
		String project_ID = "";
		String project_Name = "";
		String project_Percent = "";
		List<WebElement> web = driver.findElements(get_rows);
		for (int i = 0; i < web.size(); i++) {

			List<WebElement> webData = web.get(i).findElements(By.tagName("div"));
			
			SerialNumber = webData.get(1).getText();
			project_Name = webData.get(2).getText();
			project_ID = webData.get(4).getText();
			project_Percent = webData.get(14).getText();
			if(!getId.contains(Integer.parseInt(SerialNumber)))
			{
				getId.add(Integer.parseInt(SerialNumber));
				System.out.println("Project Name : "+project_Name);
				System.out.println("Project Id : "+project_ID);
				System.out.println("Project Percent : "+project_Percent);
				
			}
			
		}		
	}
	
	public void scrollTable(int px)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.gui-structure-content').scrollBy(0,'"+px+"')");
	}
	
	public boolean getTotalRows()
	{
		Boolean flag=false;
		selectDropDown();
		String TotalRowCount=driver.findElement(get_row_count).getText().replaceAll(" ","");
		if(Integer.parseInt(TotalRowCount)==100)
		{
			return true;
		}
		
		return flag;
	}

}

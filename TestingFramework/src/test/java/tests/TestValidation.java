package tests;

import static org.testng.Assert.assertEquals;

import org.apache.tools.ant.types.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import factory.BaseTest;
import pages.AmazonPagePO;
import pages.FlipCartPagePO;
import pages.GenericGridPagePO;
import utils.Constant;

public class TestValidation extends BaseTest {

	@Test(description = "Phone Price comparision of amazon and FlipKart ")
	public void PriceValidation() throws InterruptedException {

		getDriver().get(Constant.FLIPKART_URL);

		FlipCartPagePO flipkartPrice = new FlipCartPagePO(getDriver());

		int FlipKartPhonePrice = flipkartPrice.flipkartMobilePrice();

		getDriver().get(Constant.AMAZONE_URL);
		AmazonPagePO amazonePrice = new AmazonPagePO(getDriver());
		int AmazonePhonePrice = amazonePrice.amazonMobilePrice();

		if (FlipKartPhonePrice > AmazonePhonePrice) {
			System.out.println("Amazone price is cheaper " + AmazonePhonePrice);
		} else {
			System.out.println("FlipKart price is cheaper " + FlipKartPhonePrice);
		}

	}

	@Test(description="Grid UI Table Validation")
	public void TestGenericGrid() throws InterruptedException {
		getDriver().get(Constant.UI_GRID_URL);
		GenericGridPagePO genericTable = new GenericGridPagePO(getDriver());

		assertEquals(genericTable.getTotalRows(), true, "Total Rows Count is Not Matching");

		genericTable.projectTableValidation();

	}

}

package smokeTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;


@Listeners
public class filterProductFunctionality extends Actions {
	
	Assertions assertion;
	Actions action ; 
	String productName = "Jackets";
	String option = "Product Name";
	
	@BeforeSuite
	public void initData() throws InterruptedException {
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		action.openLumaWebsite();
		Thread.sleep(3000);
	}
	
	@Test(description="filter functionality")
	public void filterProduct() {

	    extentTest = extentReport.createTest("filter functionality");
	    extentTest.log(Status.INFO, "filter Test Start");

		action.clickOnCategory("What's New");
		action.clickOnProductLink(productName);
		action.selectProductByItsIndex(1);     
	    assertion.checkSelectIsContain(option);
	    assertion.checkOutputOfFilterIsSortedByAscendingOrder();
	}
	
	@AfterSuite
	public void afterTest() {
		action.closeBrowser();
	}
}
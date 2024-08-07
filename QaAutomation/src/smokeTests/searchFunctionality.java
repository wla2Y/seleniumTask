package smokeTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;

@Listeners
public class searchFunctionality extends Actions {
	Actions action ; 
	String productName = "bag";
	String title = "Search results for: "+"'"+productName+"'";
	Assertions assertion ; 
	
	@BeforeSuite
	public void initData() throws InterruptedException {
		
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		action.openLumaWebsite();
		Thread.sleep(2000);
	}
	
	@Test(description = "search for item")
	public void searchItem() {

	    extentTest = extentReport.createTest("search functionality");
	    extentTest.log(Status.INFO, "search Test Start");

		action.typeInSearchInputField(productName);
		action.printPageTitle();
		assertion.checkPageTitleIsContain(title);
	}
	
	@AfterSuite
	public void afterTest() {
		action.closeBrowser();
	}

}
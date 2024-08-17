package smokeTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.Actions;
import pageObjects.Assertions;
import org.testng.annotations.Listeners;

@Listeners
public class magentoWebsite extends Actions {
	Assertions assertion;
	String message = "Thank you for your purchase!";
	
	
	@BeforeSuite
	public void myBeforetest() {
		openLumaWebsite();
 	 }
	
	
@Test( description = "buying  Shirt product")
	public void searchForProduct() throws InterruptedException{
	extentTest = extentReport.createTest("buying  Shirt product"); 
	extentTest.log(Status.INFO, "log in");
	    searchForShirt();
		 getRandomElement();
		 selectProductOption();
		 addElementToCart();
         getShowCart() ;
         fillShippingAdress();
         getPlaceeHolder();
       assertion.checkOrderExist(message);
   }
	
@AfterSuite
	public void myafter() {
		closeBrowser();
	}
	
}

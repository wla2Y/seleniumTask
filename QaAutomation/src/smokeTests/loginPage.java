package smokeTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;

@Listeners
public class loginPage extends Actions {
	Actions action ; 
	Assertions assertion;
	String currentUrl ="https://magento.softwaretestingboard.com/";
	String message = "Welcome, cypress user!";
	

	@BeforeSuite
	public void initData() throws InterruptedException {
		action = new Actions();
		assertion = new Assertions();
		action.maximizeBrowser();
		
		// static wait 
		// Thread.sleep(2000); 

		
		// dynamic wait // explicit wait 
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("")));
// 		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(""))));
//		
		// dynamic wait // implicit wait 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}
	
	@Test(description="login functionality" )
	public void login() throws InterruptedException {
          
		extentTest = extentReport.createTest("Login Functionality","to check login functionality");
	    extentTest.log(Status.INFO, "login Test Start");
		action.openLumaWebsite();
		
 	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign In")));
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//        Thread.sleep(4000); 
		
//	Example  on relative locator 
//		By element = RelativeLocator.with(By.tagName("span")).below(By.cssSelector(".home-main .title"));
//		WebElement shopButton = driver.findElement(element);
//		System.out.println(shopButton.getText());

		action.clickOnSignInLink();
		action.typeInEmailInputField();
		action.typeInPasswordInputField();
		action.clickOnSignInButton();
		assertion.checkCurrentURLIsContain(currentUrl);
		Thread.sleep(3000);
		assertion.checkHeaderIsContain(message);
	}
	
	
	@AfterSuite
	public void afterTest() {
		action.closeBrowser();
	}
}
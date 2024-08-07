package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Constants {
	static public WebDriver driver = new ChromeDriver();
	static public String email = "CypressUser@gmail.com";
	static public String password = "test@123";
}
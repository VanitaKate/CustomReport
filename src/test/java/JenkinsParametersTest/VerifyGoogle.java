package JenkinsParametersTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VerifyGoogle {
public WebDriver driver;

@Test
public void definebrowser() {

}
@Test
	public void OpenGoogle( ) {
	String Browser=System.setProperty("Browser", "Chrome");
System.out.println(Browser);
		if (Browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (Browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.get("https://google.co.in");
		System.out.println("Multi Browser Test************************===================================================================");
	}

}

package JenkinsParametersTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class VerifyGoogle {   
	protected RemoteWebDriver Rdriver;
	public static WebDriverWait wait;
	public static String Browser;
	public static String BrowserName;
	public String User_Name;
	public String AccessKey;
	public String hub;
public WebDriver driver;

@BeforeTest
public void definebrowser() {
		Browser=System.getProperty("Browser");
		MutableCapabilities sauceCap=new MutableCapabilities();
		String User_Name="oauth-vani_ket-3e468";
		String AccessKey="8e176690-ece8-423e-846d-3910030becb6";
		sauceCap.setCapability("platform", "Windows 10");
		sauceCap.setCapability("version", "latest");
		DesiredCapabilities caps=new DesiredCapabilities();
	caps.setCapability("sauce:options", sauceCap);
		System.out.println("Browser Name is :    ***************"+Browser+"**************");

		if (Browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			caps.setCapability("browserName", "chrome");
		}
		driver = new RemoteWebDriver(new URL("https://"+User_Name+":"+AccessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);	

		System.out.println("Browser Name is :    ***************"+Browser+"**************");

//		sauceOptions.put("name", testInfo.getDisplayName());

//		options.setCapability("sauce:options", sauceOptions);



		driver.get("Https://google.com");
		System.out.println(driver.getCurrentUrl());
}
//@Test
	public void OpenGoogle( ) {
	String Browser=System.getProperty("Browser");
System.out.println("###########################" +Browser+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		if (Browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (Browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.get("https://google.co.in");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Multi Browser Test************************===================================================================");
	}

}

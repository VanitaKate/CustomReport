package JenkinsParametersTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
public class VerifyGoogle {   


	public static String Browser;
	public static String BrowserName;
	public String User_Name;
	public String AccessKey;
	public String hub;
//	private SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication("oauth-vani_ket-3e468", "8e176690-ece8-423e-846d-3910030becb6");
//   private SauceREST client = new SauceREST(authentication.getUsername(), authentication.getAccessKey());
public WebDriver driver;
@Parameters({"Browser"})
@Test
public void definebrowser(String Browser) {
//		Browser=System.getProperty("Browser");
		MutableCapabilities sauceCap=new MutableCapabilities();
		String User_Name="oauth-vani_ket-3e468";
		String AccessKey="8e176690-ece8-423e-846d-3910030becb6";
		sauceCap.setCapability("platform", "Windows 10");
		sauceCap.setCapability("version", "latest");
//		sauceCap.setCapability("username","oauth-vani_ket-3e468");
//		sauceCap.setCapability("accessKey", "8e176690-ece8-423e-846d-3910030becb6");
//	ChromeOptions browserOptions = new ChromeOptions();
//		URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

//		browserOptions.setPlatformName("Windows 10");
//		browserOptions.setBrowserVersion("latest");
	DesiredCapabilities caps=new DesiredCapabilities();
	caps.setBrowserName(System.getenv("SAUCE_ONDEMAND_BROWSERS"));
caps.setVersion(System.getenv("SAUCE_ONDEMAND_BROWSERS"));
caps.setCapability(CapabilityType.PLATFORM, System.getenv("SAUCE_ONDEMAND_BROWSERS"));
caps.setCapability(build, System.getenv("SAUCE_BUILD_NAME"));
//		caps.setCapability("sauce:options", sauceCap);	
		caps.setCapability("browserName", Browser);
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		System.out.println("Browser Name is :    ***************"+Browser+"**************");

		if (Browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			caps.setCapability("sauce:options", sauceCap);	
			caps.setCapability("browserName", Browser);
		}
		driver = new RemoteWebDriver(new URL("https://"+User_Name+":"+AccessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);	
//		driver = new RemoteWebDriver(new URL("https://@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);

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
	   @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

}

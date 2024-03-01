import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MaxWindow_DeleteCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DesiredCapabilities CH = DesiredCapabilities.chrome();
		CH.acceptInsecureCerts();
		CH.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		CH.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions c = new ChromeOptions();
		c.merge(CH);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		
		//Used to delete all cookies
		driver.manage().deleteAllCookies();
		
		//Used to delete any particular cookies with name.
		driver.manage().deleteCookieNamed("SessionKey");
		driver.get("https://google.com");
	}

}

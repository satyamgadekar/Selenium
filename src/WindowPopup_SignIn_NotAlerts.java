import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WindowPopup_SignIn_NotAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities CH = DesiredCapabilities.chrome();
		CH.acceptInsecureCerts();
		CH.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		CH.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
		
		ChromeOptions C = new ChromeOptions();
		C.merge(CH);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(C);
		
		/*
		 * Normal URL: https://the-internet.herokuapp.com/
		 * To handle Window popup: http://admin:admin@the-internet.herokuapp.com/
		 */
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

}

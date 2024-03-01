import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BrokenLinks_AllURL {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		DesiredCapabilities CH = DesiredCapabilities.chrome();
		
		CH.acceptInsecureCerts();
		CH.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		CH.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
		
		ChromeOptions C = new ChromeOptions();
		C.merge(CH);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(C);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0, 2000)");
		
		List<WebElement> Lists = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		System.out.println("The number of links of page : " + Lists.size());
		
		for(int i = 1; i < Lists.size(); i++)
		{
			String url = Lists.get(i).getAttribute("href");
			
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int ResponseCode = conn.getResponseCode();
		
		if(ResponseCode>400)
		{
			System.out.println("This link is broken with link name " + Lists.get(i).getText() + " With response code is : " +  ResponseCode);
			
			//HardAssertions will  fail the test after not meeting condition; it will not continue.
			//Here the broken link is BrokenURL which is in middle, we want to continue script till end to check all links; and at the end it should fail.
			//so we will use softAssertions; and that will be available in TestNG framework which we can download from chrome like download TestNG from maven.
		}
				
		}
	}

}

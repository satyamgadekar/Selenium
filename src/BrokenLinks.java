import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrokenLinks {
	
	/*
	 * Sometimes what happens there are more than 30 40 links on webpage; in practicle we cant open each link and check
	 * For that scenario we will use broken links concept; broken links is just a name actually link never be broken actually it is broken URL.
	 * So, we can say as broken URL
	 * 
	 * Any URL whose status is 400 or more than 400 then that link will give error.
	 * As we know sometimes we will get 404, 402 and 405 error so it is nothing but broken URL with status more than 400.
	 * NOw how can we check status of URL:
	 * 1: Go to developer tool ie. console screen.
	 * 2: Click on Network tab.
	 * 3: Click on XHR and click on the libk for whom u want to check the status.
	 * 4: NOw in screen it will show the status in status column.
	 * 5: Status column will give value, that value is nothing but the response code we got when we clicked on that link.
	 * 6: And if that status code is less than 400 means our link is working.
	 * (Gave pictorial representaion in word document look there;)
	 * 
	 */
	
	/*
	 * Now following is the way throgh which we can check Broken URL:
	 * 1: openConnection(); is a method from "URL" class. If we want to access that method.NOrmally what we will do we will create object for class and use.
	 * 
	 * so: new URL().openConnection();
	 * 
	 * 2: Now to check the status code of link we have to get its link; and we know link we can get throgh "href attribute"
	 * 3: Store the url in one string and pass it as parameter to URL class:
	 * 
	 * new URL(url).openConnection();
	 * 
	 * 4: Now if you when u r using that openConnection() method its return type is HttpURLConnection, so we will write as:
	 * 
	 * HttpURLConnection conn = (HttpURLConnection)new URL(url),openConnection();
	 * 
	 * 5: Now throgh "conn" we can get Request as "HEAD"
	 * conn.setRequestMethod("HEAD");
	 * conn.Connect();
	 * 
	 * 6: Now we will get Response code:
	 * conn.getResponseCode();
	 * 
	 * 7: We will store that response in int as it is number which we will use for if condition.
	 * 
	 * int ResponseCode = conn.getResponseCode();
	 * 
	 * 8: Now throgh this response code we can easily check the status:
	 * 
	 */

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
		
		//Here as of now we are doing for one link, next part we will do for all links.
		//for HttpURLConnection and URL class we have to import java.net files and at the end throw declaration.
		
		String url = driver.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href");
		
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int ResponseCode = conn.getResponseCode();
		System.out.println("The Response Code is :" + ResponseCode);
		
		if(ResponseCode>400)
		{
			//Actually here we have to use Assert class(TestNg) method, but we will see in TestNG framework
			//All HardAssertions and SoftAssertions.
			
			System.out.println("The link is not  working");
		}
		System.out.println("The link is working");
		
		

	}

}

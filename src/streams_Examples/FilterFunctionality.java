package streams_Examples;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FilterFunctionality {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities CH = DesiredCapabilities.chrome();
		CH.acceptInsecureCerts();
		CH.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		CH.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions C = new ChromeOptions();
		C.merge(CH);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Filter: Is nothing but when we search with particular name it; the search result should contain that value.
		//With the help of size function we are validationg filter.
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		
		List<WebElement> SerachResult = driver.findElements(By.xpath("//tr//td[1]"));
		int SerachResult_size = SerachResult.size();
		System.out.println(SerachResult_size);
		
		List<WebElement> ModifiedSearch = SerachResult.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		int ModifiedSearch_size = ModifiedSearch.size();
		System.out.println(ModifiedSearch_size);
		
		if(SerachResult.size() == ModifiedSearch.size())
		{
			System.out.println("Its matching");
		}
		else
		{
			System.out.println("Its not matching");
		}
		

	}

}

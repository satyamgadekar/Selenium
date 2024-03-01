package streams_Examples;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebTable_Sorting {

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
		
		//Clicking on column to sort the table
		driver.findElement(By.xpath("//table//thead//th[1]")).click();
		
		//Getting all values from first column and store in List.
		List<WebElement> WebSorting = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		System.out.println(WebSorting.size());
		
		//Getting text and collecting again to new List.
		List<String> OriginalSorting = WebSorting.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("This are the values we got from UI:" + OriginalSorting);
		
		//Applying sorting on list got from UI to validate.
		List<String> Actual_SortedValue = WebSorting.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		System.out.println("This are the values we got from UI and Sorted:" + Actual_SortedValue);
		
		//Comparing wether matches or no; in actual use assert methods.
		if(OriginalSorting.equals(Actual_SortedValue))
		{
			System.out.println("The values are matching and Table is sorting correctly");
		}
		else
		{
			System.out.println("The values are not matching and Table is not sorting correctly");
		}
		
		
		
		for(int i = 0; i<WebSorting.size(); i++)
		{
			String Name = WebSorting.get(i).getText();
			System.out.println(Name);
			
		}
		

	}

}

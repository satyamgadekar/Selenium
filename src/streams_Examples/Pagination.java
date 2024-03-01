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

public class Pagination {

	/*
	Now in last we saw that, taking price of rice.
	But, suppose rice is not present in first page then we have to navigate to second page.
	Then we will see how can we achive it.
	*/
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
		
		//Now, first we have to check on first page; if not found then go to second page.
		//After going on second page again get the new list as page changes list will change.
		//So first do then check condition.
		
		List<String> Price;
		
		do
		{
			List<WebElement> WebSorting = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
			System.out.println(WebSorting.size());
			
			Price = WebSorting.stream().filter(s->s.getText().contains("Beans")).map(s-> getProductPrice(s)).collect(Collectors.toList());
			Price.forEach(s-> System.out.println("The Price is: " + s));
			
			//Here we are getting size of price list. If the size of list is less than 1 means on that page product is not available.
			//So go for nect page, by clicking on Next button.
			//Same condition applied for while();
			if(Price.size()<1)
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
			
			
		}while(Price.size()<1);
		
		

	}
	
	public static String getProductPrice(WebElement s)
	{
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}

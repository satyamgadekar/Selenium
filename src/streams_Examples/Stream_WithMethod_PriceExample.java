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

public class Stream_WithMethod_PriceExample {

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
		
		//Now here we want to get the price of product where product = Rice.
		
		//Getting all values from first column and store in List.
		List<WebElement> WebSorting = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		System.out.println(WebSorting.size());
		
		//Here we converted List(WebSorting) to stream like .stream()
		//Again we filtered that stream and got text and again filtered on condition on contains.
		//Now we got only required stream.
		//NOw we want the price of subsequent product for that we cretaed a method "gettingPriceOfRice(s)" with paramerter as "S" and collecting it to List.
		//NOw once we will hover on error it will show to import the method, we will import the method and pass arguement as "WebElemnt s".
		//And it's return type mostly will be object we will change it to "String" as we are getting price as string so.
		//NOw, s.findElemnt we will apply instead driver. as we are already in table throgh "s". And we will get Text of price.
		//At the end we will print by for each.
		
		List<String> Price = WebSorting.stream().filter(s->s.getText().contains("Rice")).map(s-> gettingPriceOfRice(s)).collect(Collectors.toList());
		Price.forEach(s-> System.out.println("The price of rice is:" + s));
		
	}

	private static String gettingPriceOfRice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}

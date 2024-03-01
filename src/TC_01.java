import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TC_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Defining the configurations:
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\satya\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Launching the URL
		driver.get("https://www.amazon.in/");	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
		
		
		//Actiosn class for actions
		Actions action = new Actions(driver);
		
		WebElement SearBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		action.moveToElement(SearBox).sendKeys("Mobile").build().perform();
			
		WebElement Search_Btn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		action.moveToElement(Search_Btn).click().build().perform();
		
		driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys("15000");
		driver.findElement(By.xpath("//input[@id='high-price']")).sendKeys("25000");
		
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
		
		List<WebElement> Prices = driver.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']"));
		System.out.println(Prices.size());
		
			for(int i=1; i<=Prices.size(); i++) {
				String Price_UI = driver.findElement(By.xpath("//span[@class='a-price-whole'][' + i +']")).getText();
				String Price_UI1 = Price_UI.replace(",", "");
				int Price = Integer.parseInt(Price_UI1);
				
					if((Price>15000) && (Price<25000)) {
						System.out.println("Pass");
					}else {
						System.out.println("Fail");
					}
				
			}
	}

}

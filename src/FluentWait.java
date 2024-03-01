import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;



public class FluentWait {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//div[@id='start']//button")).click();
		
		
	/*
	 * There is another explicit wait mechanism called fluent wait.
	 * 
	 * Explicit wait can be achieved in two ways:
	 * 1: WebDriverWait -->Continuously fine the web element until it displayed.
	 * 2: fluent wait --> Find at regular interval of time, as we are giving polling.
	 * 
	 * Ex: E commerce web site, we want to verify 2nd message. two messages having same property. first message comes at 2 rd second and the message we want to verify
	 * comes at 3 rd second. Suppose in this case if we will give WebDriverWait then it will give 1 st message as it continuously find the element.
	 * But, through fluent wait if we give polling as 3 seconds then it will identify only at 3rd second. And our problem is solved.
	 * 
	 * Important:
	 * We know, Explicit wait can be achieved in two ways:
	 * 1: WebDriverWait
	 * 2: FluentWait
	 * Basically these two are classes which implement wait interface.
	 * 
	 * Like ChrimeDriver is class which implement WebDriver interface.
	 * 
	 * So we can direct code from selenium hq website
	 * But here i will explain 1 by 1:
	 * 
	 * 1: So FluentWait is class which implements Wait Interface, So we can write:
	 * Wait wait = new FluentWait();
	 * 
	 * 2: Now we are using driver so we have to pass driver as an arguement:
	 * Wait wait = new FluentWait(driver);
	 * 
	 * 3: Now it will show error, because as like ArrayList<String> S = new ArrayList<String>(); we have to define type of driver and it is webElemnt
	 * Wait<WebElement> wait = new FluentWait<WebElement>(driver);
	 * 
	 * 4: Now in fourth step we have to add method which are .withTimout(Duration.InSeconds(3)) and .pollingEvery(Duration.InSeconds(3)).IgnoreCaseException();
	 * 
	 *
	 */
		
		//Try to watch lecture again when revising.s
	
	
	/*
	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, SECONDS)
		       .pollingEvery(5, SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });
		   
		   Practise Code:
		   
		   Wait<WebElement> wait = new FluentWait<WebElement>(driver)
		   					.withTimeout(20, SECONDS)
		   					.pollingEvery(5, SECONDS)
		   					.ignoring(NoSuchElementException.class);
		   					
		   WebElement AnyWeb = wait.until(new Function<WebDriver, WebElement>() {
		   					public WebElement apply(WebDriver driver){
		   					return driver.findElement(By.id("AccountSumitted"));
		   					}
		   					});
	*/
	
	
	
	}
}

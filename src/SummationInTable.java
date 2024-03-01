import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SummationInTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		//Write JavaScriptExecutor Class:
		JavascriptExecutor JS = (JavascriptExecutor)driver;
				
		//Use the object to perform action:
		JS.executeScript("window.scrollBy(0,400)");
		
		//First we will get number of rows so we can iterate throgh it.
		
		List<WebElement> Rows = driver.findElements(By.xpath("//div[@class='tableFixHead']//table//tbody//tr"));
		System.out.println(Rows.size());
		
		int Total = 0;
		
		for(int i=1; i<=Rows.size(); i++)
		{
			String Value = driver.findElement(By.xpath("//div[@class='tableFixHead']//table//tbody//tr["+i+"]//td[4]")).getText();
			int IntValue = Integer.parseInt(Value);
			System.out.println(IntValue);
			
			 Total = Total + IntValue;
			
			
		}
		System.out.println("The summation of all values is:" + Total);
		
		String TotalValue = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		System.out.println(TotalValue);
		String IntTotalValue = TotalValue.split(" ")[3].trim();
		 int intTotalValue = Integer.parseInt(IntTotalValue);
		 System.out.println(intTotalValue);
		 
		 if(intTotalValue == Total)
		 {
			 System.out.println("Its Passed");
		 }
		 else
		 {
			 System.out.println("Its Failed");
		 }

	}

}

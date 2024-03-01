package exercise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Exercise {
	/*
	 * 1: Print no. of rows.
	 * 2: Print no.of columns
	 * 3: Print text from second row.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,400)");
		
		//1:Print number of Rows:
		List<WebElement> NoOfRows = driver.findElements(By.xpath("//table[@name='courses']//tr"));
		int NoOfRows_Size = NoOfRows.size();
		System.out.println(NoOfRows_Size);
		
		//2:Print number of Columns:
		List<WebElement> NoOfCol = driver.findElements(By.xpath("//table[@name='courses']//tr//th"));
		int NoOfCol_Size = NoOfCol.size();
		System.out.println(NoOfCol_Size);
		
		//3:Printing second row text only.
		for(int i=1; i<=NoOfRows_Size; i++)
		{
			if(i==3)
			{
				String SecondRow_Text = driver.findElement(By.xpath("//table[@name='courses']//tr[3]")).getText();
				System.out.println(SecondRow_Text);
				break;
			}
		}
	}

}

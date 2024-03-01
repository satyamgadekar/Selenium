 package exercise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandling {
	
	/*
	 * In Calender we have to handle date and month.
	 * For Date: We will retive all the dates from calender and will print it one by one and match with expected one.
	 * Once it get matched just click on that date.
	 */
	
	/*
	 * First we selct the month and then we will select Date:
	 * We will use while loop; we know how while loop works; it will get executed till the condition is true, when the condition gets false it will come out.
	 * So, here we will apply negotiation where, false condition we will make true to click on next arrow of month till we get expeced moth:
	 * Negotiation ! condition;
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#travel_date")).click();
		
		String ExpectedMonth = "April";
		String ExpectedDate = "20";
		
		while(!driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='datepicker-switch']")).getText().contains(ExpectedMonth))
		{
			driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='next']")).click();
		}
		
		List<WebElement> AllDates = driver.findElements(By.cssSelector(".day"));
		int Date_Count = AllDates.size();
		System.out.println(Date_Count);
		
		for(int i=0; i<Date_Count; i++)
		{
			String ParticularDate = driver.findElements(By.cssSelector(".day")).get(i).getText();
			System.out.println(ParticularDate);
			
			if(ParticularDate.equalsIgnoreCase(ExpectedDate))
			{
				AllDates.get(i).click();
				break;
			}
			
		}

	}
	
	
	
	
	
	/*
	 * for(int i=0; i<Date_Count; i++)
		{
			String DateProperty = AllDates.get(i).getAttribute("class");
			System.out.println(DateProperty);
			
			if((DateProperty == "active day") || (DateProperty == "day") || (DateProperty == "new day"))
			{
				String ParticularDate = AllDates.get(i).getText();
				System.out.println(ParticularDate);
				
				if(ParticularDate.equalsIgnoreCase(ExpectedDate))
				{
					AllDates.get(i).click();
				}
				else
				{
					System.out.println("Date is not present for this month.");
				}
				
			}
		}
	 */

}

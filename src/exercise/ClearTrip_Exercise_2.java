package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip_Exercise_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.get("https://www.cleartrip.com/");
		
		Thread.sleep(3000);
		
		Driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
		
		WebElement Adults = Driver.findElement(By.xpath("//div[@class='mb-4']//select"));
		
		Select Adults_1 = new Select(Adults);
		Adults_1.selectByIndex(3);
		
		WebElement Children = Driver.findElement(By.xpath("//h4[text()='Children']/following-sibling::select"));
		
		Select Children_1 = new Select(Children);
		Children_1.selectByIndex(2);
		
		WebElement Infants = Driver.findElement(By.xpath("//h4[text()='Infants']/following-sibling::select"));
		
		Select Infants_1 = new Select(Infants);
		Infants_1.selectByValue("0");
		
		Driver.findElement(By.cssSelector(".flex.flex-middle.p-relative.homeCalender")).click();
		Driver.findElement(By.cssSelector("div[class*='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']")).click();
		
		Driver.findElement(By.xpath("//a[text()='Class of travel, Airline preference']")).click();
		
		Driver.findElement(By.xpath("//div[@class='col flex flex-middle']//button[text()='Search flights']")).click();
		
		String ErrMsg = Driver.findElement(By.xpath("//span[text()='Select Departure and Arrival airports/cities.']")).getText();
		System.out.println(ErrMsg);

	}

}

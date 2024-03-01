package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement; 
import java.util.*;

public class Amazonexercise {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone 11");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		List<WebElement> TotalResult = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(TotalResult);
		for(int i=1; i<=TotalResult.size();i++) {
			String PhoneTYpe = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText();
			
			if(PhoneTYpe.trim() == "Apple iPhone 12 (128GB) - Green") {
				String Price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
				System.out.println(Price);
			}
		}
	}
}

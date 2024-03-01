package exercise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		
		driver.switchTo().window(ChildWindow);
		
		String ChildText = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
		System.out.println(ChildText);
		
		driver.switchTo().window(ParentWindow);
		
		String ParentText = driver.findElement(By.xpath("//*[@id='content']//h3")).getText();
		System.out.println(ParentText);
	}

}

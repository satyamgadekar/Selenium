package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		List<WebElement> Frames = driver.findElements(By.tagName("frame"));
		System.out.println("The available frames on webpage is:" +Frames.size());
	
		//Here we have used by string that is ID or name
		driver.switchTo().frame("frame-top");

		//Here we have used by string that is ID or name
		driver.switchTo().frame("frame-middle");

		System.out.println(driver.findElement(By.id("content")).getText());
		
		
	}

}

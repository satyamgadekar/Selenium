import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {
	
	/*Frames: We can identify frames simply by tagname called "iframe"
	 * Frames are simply nothing but the the apart of Webpage but it will act as new tab or another tab.
	 * Like how we will move to tab same way we have to move to frame.
	 * 
	 * We can move to frame by three ways: 1: By ID, 2: By Index 3: By WebElemnt.
	 * Mostly By WebElemnt will be preferred always as we most of the times s=dont know how many frames are there.
	 * 
	 * To Identify how many frames are there we can use findWebElemnts(By.tagname("iframe")).size()
	 * It will give how many iframes are there.
	 * 
	 * Once we will move to frames to move to normal webpage, we have to switchto default().
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
		//We will identify how many frames are there, by tagname.
		List<WebElement> Frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Frames available in WebPage:" + Frames.size());

		//Here we are switching to frame with WebElement Method, We stored WebElement in one WebElement and we are passing.
		WebElement Frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(Frame);
		
		//Now throgh actions class we will achieve drag and drop functionality.
		//Imp: Never forget to do build and perform on Actions class.
		
		Actions Act = new Actions(driver);
		WebElement Source = driver.findElement(By.cssSelector("div#draggable"));
		WebElement Target = driver.findElement(By.cssSelector("div#droppable"));
		Act.dragAndDrop(Source, Target).build().perform();
		
		//NOw to switch to back we have to use default();
		driver.switchTo().defaultContent();
		
		//Clicking on any available on default webpage.
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		
		System.out.println("Test Completed Successfully.");
	}

}

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling_Parent_Child {
	
	/*
	 * window is nothing but opening in a new tab or new window.
	 * Selenium will treat them same wither it will be new window or new tab.
	 * We will use iterator concept to achieve it.
	 * 
	 * 1: First we get to know how many windows are there throgh getWindowHandles()
	 * 2: Store it in Set<String> it will suggest while selecting
	 * 3: Use iterator method from Set collections to traverse with next() keyword.
	 * 4: Store each window in String value.
	 * 5: Use driver.switchTo().window(windowvalue), to traverse throgh different windows.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it=Windows.iterator();
		String ParentID=it.next();
		String ChildID=it.next();
		
		driver.switchTo().window(ChildID);
		String FullWording = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(FullWording);
		
		//We can directly perform action on splitted array with index as we did here with [1] and [0] as u see
		String Email = FullWording.split("at")[1].trim().split(" ")[0];
		System.out.println(Email);
		
		driver.switchTo().window(ParentID);
		driver.findElement(By.cssSelector("#username")).sendKeys(Email);

	}

}

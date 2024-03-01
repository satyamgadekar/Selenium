import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {
	
	/*
	 * Action class used for different things, as mentioned in word document.
	 * Action is a class like we have used Select class for handling static dropdown, same way we will use it.
	 * We have to pass driver as an arguement as we passed the Dropdown propert as an WebElemnt for Select class.
	 * Once we perform any action we have to build that action and perform it, it is very important.
	 * 
	 * Actions:
1.	How to mouseover on object with selenium?
2.	Performing mouse and keyboard interactions on selenium.
3.	Context clicks on element.
4.	Double click on element.
5.	Drag and dropping the element.

	 */
	
	/*
	 * Very Important:
	 * 1: KeyDown : Means we are pressing the key down.(Pressing the key.)
	 * 2:Keyup : Means we are removing the hand from key(leaving the key)
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		Actions Act = new Actions(driver);
		
		//1: Mouseover on object
		Act.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		
		//2: Right click on object with ContectClick.
		Act.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
		
		//3:Writing the value in text box in capital letters with KeyDown keyword.
		Act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
		
		//4:How to select the text whatever we have wriiten, using double click concept.
		Act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Satyam").doubleClick().build().perform();
		
		
		
	
		
		
		

	}

}

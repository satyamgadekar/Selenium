import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_page {
	
	/*
	 * We can achieve scrolling on page by javascript executor class.
	 * We will write the object of javascript and then import that class.
	 * 
	 * 1: To scroll main page:
	 * To scroll on main page we will go to console of that web page and write; window.scrollBy(x cor, y cor)
	 * 
	 * 2: To scroll on sub page of web page as in example we will write;
	 * document.querySelector(".page").scrollTop=coordinate
	 * 
	 * we will get cordinate by trail and error by inspecting them.
	 */

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
		

		
		//Now to scroll for sub webpage we will use document.querySelector("").scrollTop=500(if vertical scroll) or .scrollLeft=400(If horizontal scoll)
		//How we will write driver.findElement(By.cssSelector()) same way we will write and pass locator in above double inv quamma.
		//Here we have usd ".tableFixHead" css selector.
		
		JS.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		

	}

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		//create driver object for Chrome driver
		/*We will strictly implement methods of WebDriver so, will write the object as
		 * 
		 *   WebDriver driver = new ChromeDriver(); instead of 
		 *   
		 *   ChromeDriver driver = new ChromeDriver();
		 *   
		 *   We will strictly implement methods of WebDriver
		 *   When we will write this object, it will show error that time only move cursor on it, 
		 *   and import that file.
		 *   
		 *   This ChromeDrier.exe file is nothing but the Selenium Browser driver which we discused in WebDriver Architecture.
		 * 
		 */
		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver= new WebDriver();
			
		driver.get("https://www.google.com/");     //hit url on the browser.		
		System.out.println(driver.getTitle());     //validate if your page title is correct.
				
		/*
		 * Sometimes we giva some url and if that website is hacked, we may land on different url.
		 * So to check that we can have getCurrentUrl method of WebDriver.
		 */
		System.out.println(driver.getCurrentUrl());  //validate that we are landed on correct URL
		
		 /*
		  * There are many application like banking applications where we will not get page source so with 
			the getPageSource() method we can easily get the page source.
		  */
		
		System.out.println(driver.getPageSource());
				
		/*
		 * Suppose if we want to navigate on the page then we will use
		 * navigate().back or if we want to forward we will use
		 * navigate().forward
		 */
		
		driver.get("http://yahoo.com");
		driver.navigate().back();
		
		
		//It will close the current browser opened by selenium.
		driver.close();
		
		//It will close all browser opened by selenium.
		driver.quit();
		
		
		/*
		 * Now above if you see we have ran our test only on Chrome, but if we want to run it on
		 * Firefox or IE then download those particular driver place it in proper folder.
		 * Use the same way as we used for chrome
		 * 
		 * System.setProperty("webdriver.gecho.driver", "C:\\gechodriver.exe");
		
		WebDriver driver1 = new FirefoxDriver();
		WebDriver driver3 = new InternetExplorerDriver();
		
		driver.get("https://www.google.com/");
		
		String Title = driver.getTitle();
		
		System.out.println(Title);
		
		driver.close();
		
		The same can be done for IE.
		
		
		 */		

	}

}

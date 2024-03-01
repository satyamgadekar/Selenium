package exercise;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingWebDriverScope {
	
	/*
	 * Limiting WebDriver Scope: Its nothing but instaed of focusing on whole WebPage created new driver will have accesss to only that specific area.
	 * We will see it by example.
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println(AllLinks.size());
		
		//Now we will focus only on footer link; for that i=our driverscope should be only on footer, to achive do like this:
		WebElement Footer_Driver = driver.findElement(By.cssSelector("div#gf-BIG"));
		
		System.out.println(Footer_Driver.findElements(By.tagName("a")).size());
		
		//This way also we can do
		System.out.println(driver.findElements(By.cssSelector("div#gf-BIG a")).size());
		
		//Now here we will just focus on footer first column to get number of links, open in new tab with ctrl+enter key action.
		
		List<WebElement> AllLinks_Footer = driver.findElements(By.xpath("//div[@id='gf-BIG']//table//tbody//tr//td[1]//a"));
		System.out.println(AllLinks_Footer.size());
		
		for(int i = 1; i< AllLinks_Footer.size(); i++)
		{
			//Now to open link in new tab, we will say ctrl and click, same we acn achieve with keys.chord.
			//V.IMP: All keyboard action can be send to scipt as an sendkeys.
			String Keyboard_Action = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			AllLinks_Footer.get(i).sendKeys(Keyboard_Action);
			Thread.sleep(3000);
		}
		
		//Till here we have opened windows in a new tab, now we want toget title of each tab.
		//We can do it by getWindowHandles() method. But we will apply while loop to optimise the code.
		//hasNext() will give either next window is present or not. And next() will catually move to next window.
		
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> IT = Windows.iterator();
		
		//Now we dont know how many windows are there so we will aplly while loop with hasNext() condition.
		
		while(IT.hasNext())
		{
			driver.switchTo().window(IT.next());
			System.out.println(driver.getTitle());
		}

	}

}

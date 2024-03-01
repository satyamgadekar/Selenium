import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutosuggestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//ul[@class='erkvQe']//span
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		List<WebElement> Options = driver.findElements(By.xpath("//*[@class='wM6W7d']//span"));
		System.out.println(Options.size());
		
		for(WebElement Option : Options)
		{
			if(Option.getText().equalsIgnoreCase("Selenium testing"))
					{
				Option.click();
					}
		}
		

	}

}

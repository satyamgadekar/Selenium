import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).click();
		
		System.out.println(driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).isSelected());
		
		driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).click();
		
		System.out.println(driver.findElement(By.xpath("//input[@id=\"checkBoxOption1\"]")).isSelected());
		
		int ChkBox_Size = driver.findElements(By.cssSelector("input[name*='checkBoxOption']")).size();
		
		System.out.println(ChkBox_Size);
		
	}

}

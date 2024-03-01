package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NormalExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		
		String Label = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[1]")).getText();
		System.out.println(Label);
		
		WebElement AllValues = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select Dropdown = new Select(AllValues);
		Dropdown.selectByVisibleText(Label);
		
		driver.findElement(By.cssSelector("#name")).sendKeys(Label);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String Alert_Text = driver.switchTo().alert().getText();
		System.out.println(Alert_Text);
		
		if(Alert_Text.contains(Label))
		{
			System.out.println("Testcase is Passed");
		}
		else
		{
			System.out.println("Testcase is Failed");
		}
		
		driver.switchTo().alert().accept();
		

	}

}

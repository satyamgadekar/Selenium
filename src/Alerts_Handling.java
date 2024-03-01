import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_Handling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * MOst of the times in every application we will get Alerts.
		 * In that case either we have to accept it or dismiss it.
		 * In selenium we can do it by switchto() and alerts() method.
		 */
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(3000);
		
		String Name = "Satyam Gadekar";
		String FullName = "Satyam Namdev Gadekar";
		
		//first we will enter name and click on Alert button it will give Alert with Ok only.
		//Which we have to accept only.
		
		driver.findElement(By.cssSelector("#name")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		String Alert_Text_1 = driver.switchTo().alert().getText();
		System.out.println(Alert_Text_1);
		
		if(Alert_Text_1.contains("Satyam Gadekar")){
			System.out.println("Its passed");
		}else{
			System.out.println("Its failed");
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("#name")).sendKeys(FullName);
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		
		String Alert_Text_2 = driver.switchTo().alert().getText();
		System.out.println(Alert_Text_2);
		
		if(Alert_Text_2.contains("Satyam Namdev Gadekar")){
			System.out.println("Its Passed but Failed");
		}else{
			System.out.println("Its Ok Ok");
		}
		
		//Now this alert have Ok as well as cancel, so we will cancel it, means dismiss.		
		driver.switchTo().alert().dismiss();
			
			

	}

}

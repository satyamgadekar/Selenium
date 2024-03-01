package filehandeling;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities CH = DesiredCapabilities.chrome();
		CH.acceptInsecureCerts();
		CH.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		CH.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);		
		ChromeOptions C = new ChromeOptions();
		C.merge(CH);	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(C);		
		/*
		 * Now we know that selenium will not understand what is .au3 file or .exe file.
		 * Java will help us to undersatnd the file type. As we are scripting in java so we can do that with "Runtime" class.
		 * This Runtime class is having getRuntime() method which will take parameter where that .exe file is placed.
		 */		
		driver.get("https://avepdf.com/pdf-to-jpeg?gclid=CjwKCAiA-9uNBhBTEiwAN3IlNJWN8W-pN3dM50TFIu-H-6I8tzG5tL8sJ_BNGX2MTSOCMbAbGRR4GxoCLn4QAvD_BwE");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@aria-label='Upload Folder']//span[text()='Choose File']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\satya\\OneDrive\\Documents\\AutoITScript\\FileUpload.exe");

	}

}

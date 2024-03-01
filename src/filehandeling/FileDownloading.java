package filehandeling;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FileDownloading {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		

		//Here we are taking the project path so that we will not hardcode the path in script.
		//If we see this will be used by many people or if we put in jenkins it will not work if we hardcode.
		//So by System.getproprty("user.dir") will give this project path: C:\Users\satya\OneDrive\Desktop\Udemy_Selenium_Demo
		String downloadPath=System.getProperty("user.dir");
		System.out.println(downloadPath);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		/*
		 * Below three line code is just copied and we just put our download path in that code
		 * Basically what we are doing here wehen we download any file that time the will get download in downloads sections which is local.
		 * So, here we are setting our download path and for that we have to set properties to chrome.
		 */
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		/*
		 * We have used chromeoptions class to accept insecure certificates.
		 * Same way we will use it to set default download path.
		 * Here the object from above code we pass below; look the code.
		 */
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver=new ChromeDriver(options);
		
		
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
		Thread.sleep(3000);
		
		//To upload a file we used Runtime class where in that getRuntime is a class and under that exec method that will take the path of autoIT script.
		Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe");
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		driver.findElement(By.linkText("Download Now")).click();
		Thread.sleep(5000);
		//Till here we are performing selenium actions.
		
		/*Here we have File class in java where we can set download path.
		 * Now that file will take parameter of the file where it exists. We have to do a forward slash here remember.
		 *C:\Users\satya\OneDrive\Desktop\Udemy_Selenium_Demo ---> So under this project new file will get downloaded.Which is easy to access.
		 *NOw, with the exists we can check wether file is there or no.
		 *and after that with delete we can delete that file.
		 */
	
		File f=new File(downloadPath+"/converted.zip");
		if(f.exists())
		{
		Assert.assertTrue(f.exists());
		if(f.delete())
		System.out.println("file deleted");
		}
		

	}

}

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	/*
	 * Explicit wait: Unlike implicit wait applied to whole test steps, explicit just concentrate on particular step:
	 * We have to import the WebDriverWait class for that.
	 * After importing WebDriverWait class we have to pass driver and no of seconds as a parameter.
	 * Then with the object.until(ExpectedConditions.all methods will be available)
	 * 
	 * Syntax:
	 * 
	 * WebDriverWait Wait = new WebDriverWait(driver, 5);
	 * Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
	 * 
	 * Note:
	 * 
	 * WebElement = driver.findElement(By.cssSelector(".promoCode"))
	 * Locator = By.cssSelector(".promoCode")
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//Imported class and created object Wait for that class with driver and no of seconds as parameter.
		WebDriverWait Wait = new WebDriverWait(driver, 5);

		String ReqProduct[] = {"Beetroot", "Brocolli"};
		
		ProductMethod(driver,ReqProduct);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Here it will take some time to load, so explicit wait will work here.
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//Now we will get text of promo code after clicking on apply, it will take time to load.
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		String Code_Info = driver.findElement(By.cssSelector(".promoInfo")).getText();
		
		System.out.println(Code_Info);

	}
	
public static void ProductMethod(WebDriver driver, String ReqProduct[])
	{
		List<WebElement> AllProduct_Vegetable = driver.findElements(By.cssSelector("h4.product-name"));
		int NoOf_Items = AllProduct_Vegetable.size();
		System.out.println(NoOf_Items);
		
		for(int i = 0; i< NoOf_Items; i++)
		{
			
			String Product_Veggie[] = AllProduct_Vegetable.get(i).getText().split("-");
			String Formated_Product_Veggie = Product_Veggie[0].trim();
			System.out.println(Formated_Product_Veggie);
			
			
			List ReqProducts_List = Arrays.asList(ReqProduct);
			int j = 0;
			if(ReqProducts_List.contains(Formated_Product_Veggie))
			{
				
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				
				j++;
				if(j==ReqProduct.length)
				{
					break;
				}
				
			}	
		}
	}
}

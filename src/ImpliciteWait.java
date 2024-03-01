import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImpliciteWait {
	
	/*
	 * Implicit Wait: Implicit wait is that wait, which is being applied to whole code implicitly.
	 * In Implicit wait whatever time we have given to script to wait each step will going to wait till that time.
	 * 
	 * Pros: 
	 * The code will be look good.
	 * 
	 * Cons:
	 * Performance issue might get neglected, suppose if your one tes step want 3 sec to load, but other step should load asap.
	 * But when we apply Implicit wait the other step if are taking more time that will also gets neglected.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		
		//Here we have applied Implicit wait of 5 seconds it will wait for 5 seconds for each step.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String ReqProduct[] = {"Beetroot", "Brocolli"};
		
		ProductMethod(driver,ReqProduct);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Here it will take some time to load, so implicit wait will work here.
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//Now we will get text of promo code after clicking on apply, it will take time to load.
		
		String Code_Info = driver.findElement(By.cssSelector(".promoInfo")).getText();
		System.out.println(Code_Info);
		
		
		//Here i have took values from table to check whatever we selected is correct or no.
		List<WebElement> CartRows = driver.findElements(By.xpath("//table[@id='productCartTables']//tbody//tr"));
		System.out.println(CartRows.size());
		
		for(int j=1; j<=CartRows.size(); j++)
		{
			String ProductnName = driver.findElement(By.xpath("(//*[@id=\"productCartTables\"]//tbody//tr//td[2]//p)["+ j + "]")).getText();
			String ProNam_array[] = ProductnName.split("-");
			
			String ProNam_array_trim = ProNam_array[0].trim();
			System.out.println(ProNam_array_trim);
			
			List ReqProducts_List_1 = Arrays.asList(ReqProduct);
			
			if(ReqProducts_List_1.contains(ProNam_array_trim))
			{
				System.out.println("Passed");
				
			}
			
		}

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

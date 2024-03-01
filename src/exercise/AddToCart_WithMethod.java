package exercise;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart_WithMethod {
	
	/*
	 * Whatever code we had written in last classTest of AddToCart_WiyhOutMethod, we have added it to the new method ProductMethod.
	 * And we passed the parameter as WebDriver driver and array (if u use then n then only provide.)
	 * As we are using static keyword so, we will call method in main method w/o creating object and we will pass parameter.
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		Thread.sleep(2000);
		
		String ReqProduct[] = {"Beetroot", "Brocolli"};
		
		ProductMethod(driver,ReqProduct);
		
		
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

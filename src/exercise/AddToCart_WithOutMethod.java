 package exercise;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart_WithOutMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		Thread.sleep(2000);
		
		String ReqProduct[] = {"Beetroot", "Brocolli"};
		
		/*
		 * Things what we have to do:
		 * 1: Add any product
		 * 2: Try to use parent child xpath as text() will change from Add To Cart to Added.
		 * 3: Try to use for loop with array concept as well as index concept.
		 * 
		 * As we know all vegetables button will have same attribute so we will use index concept.
		 * We will retrive veggies name and once it matches to respective veggie go and click on that index.
		 */
		
		
		//Here we have retrived all vegetable names.
		List<WebElement> AllProduct_Vegetable = driver.findElements(By.cssSelector("h4.product-name"));
		int NoOf_Items = AllProduct_Vegetable.size();
		System.out.println(NoOf_Items);
		
		for(int i = 0; i< NoOf_Items; i++)
		{
			//Now here we alredy got all veggies name in AllProduct_Vegetable, so just get text from it with index and split it on basis of -
			//After splitting [0] = Brocolli  and [1] = - 1 Kg
			String Product_Veggie[] = AllProduct_Vegetable.get(i).getText().split("-");
			String Formated_Product_Veggie = Product_Veggie[0].trim();
			System.out.println(Formated_Product_Veggie);
			
			//Converting array to ArrayList for better use of methods.
			List ReqProducts_List = Arrays.asList(ReqProduct);
			int j = 0;
			if(ReqProducts_List.contains(Formated_Product_Veggie))
			{
				//when any method is not showing after dot try to use elements instead of element
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				
				//Now we have to add only two products so once those added break the loop to save time so we will do.
				//Declare one variable and increase it till the condition.
				j++;
				if(j==ReqProduct.length)
				{
					break;
				}
				
			}
			
			
		}

	}

	

}

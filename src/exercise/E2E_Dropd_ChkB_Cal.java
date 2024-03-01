package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class E2E_Dropd_ChkB_Cal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\satya\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//first select from city
		driver.findElement(By.cssSelector("span[id*='ainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[text()=' Mumbai (BOM)']")).click();
		String From_City = driver.findElement(By.xpath("//a[text()=' Mumbai (BOM)']")).getText();
		System.out.println(From_City);
		
		//Now select To city.
		
		/*
		Now select To city. Once we select From city To city window will get directly opened.
		So, no need to click on it again.
		If we use xpath //a[text()=" Pune (PNQ)"] : with this xpath we will get two matching nodes as "From and To city".
		As we want second so we can put like this : (//a[text()=" Pune (PNQ)"])[2] , it will second option only.
		
		We can also use parent child method.
		Write xpath for parent means whole ToCity window followed by pune xpath.
		//div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"]//a[text()=" Pune (PNQ)"]   
		
		First is whole parent xpath and second is child one.
		We can use both. index also and parent child combination also.
		*/
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Pune (PNQ)']")).click();
		String To_City = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Pune (PNQ)']")).getText();
		System.out.println(To_City);
		
		//Select calender date.
		/*
		 * Once To city selected calender will open automatically.
		 * As of now we will slect current date only.
		 * We will use cssselector with class.
		 * And we know selenium will not accept class with spaces. So we will put dot inplace of space.
		 */
		
		
		/*
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();
		
		
		String Date = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).getText();
		System.out.println(Date);
		*/
		
		//Now finally We will select Checkbox.
		
				/*
				 * We will select and cross verify wether its checked or not.
				 */
				
				driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();
				boolean result = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
				System.out.println(result);
		
		//NOw we will select passender detail either having adlt or child.
		
		/*
		 * Here we will select 5 Adult and 3 child.
		 * As we have to select 5 adult we will apply while or for loop.
		 * Bydefault 1 Adult is selected to iterate the loop accordingly.
		 */
		
		String Default_Adult = driver.findElement(By.xpath("(//div[@id='divpaxinfo'])[1]")).getText();
		System.out.println(Default_Adult);
		
		driver.findElement(By.xpath("(//div[@id='divpaxinfo'])[1]")).click();
		
		Thread.sleep(2000);
		
		int Adult = 1;
		
		while(Adult <= 5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			Adult++;
		}
		
		Thread.sleep(2000);
		
		int Child = 1;
		
		while(Child <= 3)
		{
			driver.findElement(By.id("hrefIncChd")).click();
			Child++;
		}
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption'][@value='Done']")).click();
		
		String Default_AdultChild = driver.findElement(By.xpath("(//div[@id='divpaxinfo'])[1]")).getText();
		System.out.println(Default_AdultChild);
		
		//Select Currency Dropdown.
		
		/*
		 * As we know this dropdown is Static dropdown with same number of option and after inspecting it have Select Tag.
		 * So, for static dropdown we will use, Select class.
		 * And to use Select class we know we have to store that dropdown main object in WebElemnt variable.
		 * To use Select Class we have to import it with ending Ui.
		 */
		
		WebElement Dropdowns = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select DropSel = new Select(Dropdowns);
		
		Thread.sleep(2000);
		
		DropSel.selectByIndex(3);
		
		String DropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText();
		System.out.println(DropDown);
		
		if(DropDown.contains("AED"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
			
		
		
		
		//We will click on Search button.
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		System.out.println("First Exercise Completed Successfully.");
	}

}

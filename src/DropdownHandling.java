import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import com.sun.tools.javac.util.List;



public class DropdownHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 1.	Handling static dropdown
			2.	Handling dynamic dropdown
			3.	Handling checkboxes
			4.	Handling Radio buttons 
			5.	Handling Text buttons
			6.	Handling Alerts Java popups
			7.	Selenium web driver form methods


				Handling static dropdown:

					Static dropdowns are those dropdowns where value under it will not change.
					Mostly the dropdown with “Select tag” is static dropdown.
					When the webelement dropdown has tag as "Select" then to select dropdown by script we have to import select class.
					We have to create an object for that Select class and throgh that object we will call all methids under Select class.
					

		 */
		
		//Static drodown:  Currency Dropdown
		
		//System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
	
		//Now if you see we have imported the select class also, eventhogh its showing an error.
		//Its because we have to give an webelement as a parameter of that dropdown for the Select class.	
		//Now we cant give the webelemnt directy, we have create an variable for that.
		//To do that, simply finf=d ele by.id. Assighn to one variable and pass that varibale as parameter.
		//Import this package as we are dealing with UI, so : import org.openqa.selenium.support.ui.Select;
		
		WebElement DropProperty = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select StaticDropdown = new Select(DropProperty);
		
		
		//NOw, with the use of this object we can perfoem lots of actions.
		
		StaticDropdown.selectByIndex(3);
		System.out.println(StaticDropdown.getFirstSelectedOption().getText());
		
		//This getFirstSelectedOption will give what option u have selected.
		
		StaticDropdown.selectByValue("AED");
		System.out.println(StaticDropdown.getFirstSelectedOption().getText());
		
		StaticDropdown.selectByVisibleText("INR");
		System.out.println(StaticDropdown.getFirstSelectedOption().getText());
		
		
		/*
		 * Here we will handle Passenger dropdown.
		 * 
		 * Here, if u see for this dropdown, Select tag is not there.So, we cant use Select class.
		 * And also on this dropdown we are performing different operation.
		 */
		
		driver.findElement(By.id("divpaxinfo")).click();
		
			Thread.sleep(2000L);      //Becoz browser will take time to load.
			
			//Now, if we have to select 5 adult, then we cant write step to click on + icon.
			//We can optimise the testcase by applying for loop or either whileloop.
			//Suppose u want know how many asults are selected by default and at the end of code also, then use gettext.
			
			String AdultValue = driver.findElement(By.id("divpaxinfo")).getText();
			System.out.println(AdultValue);
			
			int Adult = 1;
			
			while(Adult <= 4)
			{
			
					driver.findElement(By.id("hrefIncAdt")).click();
					Adult++;
		
			}
			
			String AdultValue1 = driver.findElement(By.id("divpaxinfo")).getText();
			System.out.println(AdultValue1);
			
			driver.findElement(By.id("btnclosepaxoption")).click();
			
			
			/*
			 * Handeling dyanamic dropdown:
			 * 
			 * Ex: Sometimes with selection of one dropdown only we will get second dropdown.
			 * And Until and unless that first dropdown got selected, we cannot select second dropdown.
			 * So, this are called dynamic dropdown.
			 * Most of the times we will have two xpath available on screen. And if we want to use the second one they do 
			 * only ine thing.
			 * 
			 * Suppose, Chennai is dropdown value which is avialable in two dropdown fiealds.
			 * And u know Selenium always starts inspecting from left corner first.
			 * 
			 * Si u can wrute the xpath as,
			 * 
			 *     //div[@id="Chennai"]
			 *     
			 *     If we give this xpath it will select first dropdown.But we want to select second, so give
			 *     
			 *     (//div[@id=""Chennai])[2]
			 *     
			 *     Now it will select value from second dropdown.(//a[@value="MAA"])[2]
			 */
			
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]")).click();
			
			driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
			
			/*
			 * Parent child relationship :
			 * Most of the times u see we used index 2 in above xpath,client may not like it.
			 * In that case, we will use parent child xpath.
			 * Ex: Parent xpath//child xpath.
			 * 
			 * Explained in word document.
			 */
			
			/*
			 * Autosuggestion field suggestion.
			 */
			
			driver.findElement(By.id("autosuggest")).sendKeys("ind");
			
			List <WebElement> Options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
			
			for(WebElement Option : Options) 	
			{			
				if(Option.getText().equalsIgnoreCase("India"))
				{
					Option.click();
					break;
				}
			}
			
			/*
			 * SElection of checkboxes,
			 * HOw to select, HOw to get the size of it, how to find wether the checkbox is selected or not.
			 */
			/*
			NOw if you see if we write an xpath with this id or css selector with thid id, it will be too long. id= ctl00_mainContent_chk_friendsandfamily
			So in that case we will use conatins.
			  By CssSelector    :                 input[id*='friendsandfamily']
			  
			  In Css Selector attribute* will act as a contains for cssselector
			  Same we can write it by xpath as : //input[contains(@id,'friendsandfamily')]
			*/
			
			//Step 2
			System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
			
			//Here we checked the checkbox.Step 1
			driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
			
			//BUt if we want know whether its checked or not then, use this.We will check before checking also. Step 3
			System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
			
			//Now suppose you want to know how many checkboxes are there then use size method.
			//BUt for that, we have to choose one common attribute of checkboxes which is same for all.
			//And to that we will apply size method.
			//Now for here for each checkbox type=checkbox is common so use it.
			
			System.out.println(driver.findElements(By.cssSelector("input[type*='checkbox']")).size());
			
			//NOw here if you see we have used findElements not findElement bcoz, here we want size. And also many will be there.
			//for getting size of table we will do the same.
			
			
	/*
	 * Handeling calender:
	 * Simply with the logic of click we can handle the calender.
	 * For selecting future date and some other date we will see in next lecture.
	 */
			
			/*
			 * Handeling Radio button.  
			 * We can handle radio button with click method.
			 * To check wether cclicked on no no, we can use isselected() method, as we previous;y used for checkboxex.
			 */
			
			/*
			 * Indentifying wether the element is enabled or disabled.
			 * Info is in word document.
			 * Ex: Depending on selection of round trip radio button property changes.
			 */
			
			
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));			
			System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

			if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			System.out.println("its enabled");
			//Assert.assertTrue(true);     we havent added TestNG jar so it will not work
			}else{
			//Assert.assertTrue(false);
			}			
	}

}

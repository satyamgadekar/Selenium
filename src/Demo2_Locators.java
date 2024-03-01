import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * Locators: Locators are basically nothing but the elements which are used to identify the position of webelement
		 * on browser.
		 * To inspect the element right click on the webelement and say inspect.
		 * Click on arrow shown on Inspects screen and inspect that element.
		 * Every webelement has tag and attribute like ID, Name, ClassName, LinkText, Xpath, CSS.
		 * 
		 * Now, in scripting:
		 * 1: driver will find the element on browser so, use elements for single webelement and elements like for table.
		 * 
		 * driver.findElement();
		 * 
		 * 2: Now throgh which we are going to find so put By. and it will give suggestion
		 * 
		 * driver.findElement(By.id(""))
		 * 
		 * 3: Now, put dot and perform any action that you want to perform.
		 * 
		 * driver.findElement(By.id("email")).sendKeys("I am Satyam");
		 * 
		 */
		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.salesforce.com/in/?ir=1");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"globalnavbar-header-container\"]/div[2]/div/div[6]/div/div/div[1]/a")).click();
		
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("Satyam");
		
		driver.findElement(By.name("pw")).click();
		driver.findElement(By.name("pw")).sendKeys("Satyam1234");
		
		String Text = driver.findElement(By.linkText("Forgot Your Password?")).getText();
		System.out.println(Text);
		
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		
		driver.wait(20);
		
		driver.close();
		
		
		/*
		 * Every object will not have ID, Name, ClassName.
		 * In that case we have to use Xpath/CSS selectors.
		 * Most of the times ID, ClassName may consist of alphanumeric values. In that case try to avoid using those.
		 * In selenium, selenium will not accept classname with blak space, it should be a word without spaces.(Compound classes cannot be accepted.)
		 * 
		 * For link 99% of time, we have to use LinkText attribute for easiness.
		 */
		
		
		/*
		 * Inspection of webelement start from top left corner of webpage.
		 * So, suppose if there are two fields with same attribute itwill get confuse.
		 * Ex: Salesforce login and password field.
		 */
		
		/*
		 * Xpath: 
		 * Xpath can be defined in n number of ways.
		 * Xpath can chang browser to browser.
		 * 1: Right click and say copy xpath of highlighted html code.
		 * 2: In old version of firefox, firepath is a pluggin, which will give direct xpath after inspect.But now it is not there.
		 * Double quote inside double quote are not accepted.
		 * Give single quote inside when outside is double inside or viceversa.
		 * Try to avoid full xpath(Absolute) try to use short(Relative xpath).
		 */
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
		
		/*
		 * CSS Selector:
		 * CSS can be defined in n number of ways like xpath.
		 * CSS can chang browser to browser.
		 * To identify CSS selector just right click and say copy CSS selector.
		 * There is no direct way to get CSS selector in Chrome, to get inspect the element.
		 * The CSS will be produced in navigation plane. Just highlight the element and get it.
		 * 
		 */
		
		driver.findElement(By.cssSelector("#email")).sendKeys("Satyam");
		
		/*
		 * Validating the accuracy accuracy and xpath from CSS Browser: Wriiten in word document. 
		 * 
		 */
		
		/*
		 * writing an xpath with parent child method: in word document.
		 */
		
	}

}

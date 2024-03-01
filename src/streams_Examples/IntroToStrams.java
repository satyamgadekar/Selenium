package streams_Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IntroToStrams {
	
	//Write an List; Take those names from list whose name start with "S" and take the count.

	/*
	 * Java Streams, Lambda Expressions for building optimized code:

		What are streams?
		Stram API is new feature available for JAVA 8
		By using selenium we can perform different aggregate operations on the data returned from collections by drastically reducing the complexity of the code.

		What is Lambda Expression?
		Lambda Expression introduce new arrow operator -> into java. It divides the lambda expressions into two parts:
		The left part specifies the parameter required by the expression, which could be empty if no parameters are required.
		The right side is the lambda body which specifies the action o lambada expression.
		
		The working of stream can be explained in three stages:
		1: Create a stream.
		2: Perform intermediate operations on initial stream to transform into intermediate stream and so on further intermediate operations 
		3: Perform terminal operations on the intermediate streams to get the final result.
		
		An important characteristic of intermediate operations is laziness.
		When executing this code snippet, nothing is printed to the console. That is because intermediate operations will only be executed 
		when a terminal operation is present.
		
		Note: The aggregate operations that we perform on the collection, array or any other data source do not change the data of the source, 
		they simply return a new stream.    


	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DesiredCapabilities CH = DesiredCapabilities.chrome();
		CH.acceptInsecureCerts();
		CH.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		CH.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions C = new ChromeOptions();
		C.merge(CH);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(C);
		
		
		

	}

}

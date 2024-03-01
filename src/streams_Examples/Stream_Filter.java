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

public class Stream_Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//If we will do this program of printing the name starting with "S" and giving count with Array.
		//Same programme with Steams.
		ArrayList<String> Names = new ArrayList<String>();
		Names.add("Satyam");
		Names.add("Namdev");
		Names.add("Vidya");
		Names.add("Shivam");
		Names.add("Sundaram");
		
		int Count = 0;
		
		for(int i=0; i<Names.size(); i++){
			String Name = Names.get(i);		
			if(Name.startsWith("S")){
				Count++;
				System.out.println(Name);			
			}
		}
		
		System.out.println("The number of words which starts with S are:" + Count);
		
		//We can convert Collections to stream with just .stram().
		//If we want to perform any operations on initial stream we can do it with filter thing; like filter there are many intermediate functions.
		//Intermediate stream will not return any thing unless and untill we complete it with terminal operation like count().
		//If intermediate stream returns true then and then only terminal operation will give nay value otherwise no.
		//We can directly create stream with just stream.of(); and perform any operation on it.
		
		
		
		//Now, here we have converted Names ArrayList to Stream.
		//Then we used intermediate function like filter(). Now, we know lambda expression.
		//Lambda expression consist of two parts left and right; now left is variable. As we have used "i" in for loop same here "s".
		//NOw this "s" varible will iterate parralally in stream not like "i". "i" will iterate sequentially one after other.
		//as "s" will iterate parallaly stream will execute fast and code will also, reduced.
		Long St_Name = Names.stream().filter(s -> s.startsWith("S")).count();
		System.out.println(St_Name);		
		
		//Suppose we have more opeartions to execute on intermediate stream then we can write on different line, as below.
		//As we see we are bydefault returning false so count will not give anything as we know. 
		Long St_Namee = Names.stream().filter(s -> 
		{
			
		s.startsWith("S");
		s.endsWith("m");
		return false;
				
		}).count();
		System.out.println(St_Namee);
		
		
		//Here i have created an direct stream and performed operations.
		Long ANames = Stream.of("Kaveramma", "Monica", "Ashfiya", "Anupama", "Asmita", "Satyam","Bhavya", "Aswathi","Bharath", "Arti").filter(s->s.startsWith("A")).count();
		System.out.println("The WAM team members starts with A : " + ANames);
		
		
		ArrayList<String> Values = new ArrayList<String>();
		Values.add("Aarya");
		Values.add("Deva");
		Values.add("Adinath");
		Values.add("Arush");
		Values.add("Param");
		
		Values.stream().filter(s -> s.equalsIgnoreCase("Deva")).forEach(s -> System.out.println(s));
		
		//Now if you see actually if we create list everytime we have to add which is timeconsuming; what we can do is create an array convert to arraylist.
		String Cities[] = {"Mumbai", "Pune", "Solapur", "Kolhapur" ,"Indapur"};
		
		List CitiesList = Arrays.asList(Cities);
		//We have converted Array to List in one line and we can perform all stream operations.
		
		Long CityCount = CitiesList.stream().filter(a -> ((String) a).endsWith("pur")).count();
		System.out.println("The city count is with converting Array to ArraList : " + CityCount);

	}

}

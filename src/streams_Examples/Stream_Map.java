package streams_Examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream_Map {
	
	//Now throgh map we can perfoem different operatiosn on stream data; whic can be direct stream data or filtered data.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Defined Array:
		String IT_Company[] = {"SLK","Tcs","Accenture","Infosys","Capgemini","Cognizent"};
		
		//Converted Array to arrayList:
		List<String> IT_Company_List = Arrays.asList(IT_Company);
		
		//Here we are printing the count which company start with C:
		Long IT_Company_List_Count = IT_Company_List.stream().filter(s-> s.startsWith("C")).count();
		System.out.println("The names of company which will start with C:" + IT_Company_List_Count);
		
		//Now suppose if you want to print only first company then we can use limit() terminal method like count().
		//Now to print the variable we will use foreach(); which is very important.
		
		
		//This will return only first value:
		IT_Company_List.stream().filter(s->s.length()>5).limit(1).forEach(s-> System.out.println("It will return only first value as we applied limit:" + s));
		
		//If we want to return second value:
		IT_Company_List.stream().filter(s->s.length()>5).limit(2).forEach(s-> System.out.println("With Limit 2 values are0:" + s));
		
		//Now suppose you want to convert the output got from intermediate stream to uppercase or to lowercase or any other thing.
		//For that we have map() function with that we can perform different operations.
		
		IT_Company_List.stream().filter(s->s.endsWith("s")).map(s->s.toUpperCase()).forEach(s-> System.out.println("It will return uppercase: " +s));
		
		
		//Most of the times interviewer will ask to sort the array; we can convert array to arrayList then to stream and sort it.
		IT_Company_List.stream().filter(s->s.startsWith("C")).sorted().map(s->s.toLowerCase()).forEach(s-> System.out.println(s));
		
		//WE can concanicate two stream to form new stream and perform different operations.
		
		String OldFrds[] = {"Rohit","Pavan","Abhishek","Deepak"};
		String NewFrds[] = {"Ambrish","Vikram","Suraj","Abhilash"};
		
		List<String> OldFrds_List = Arrays.asList(OldFrds);
		List<String> NewFrds_List = Arrays.asList(NewFrds);
		
		 Stream<String> AllFrds = Stream.concat(OldFrds_List.stream(), NewFrds_List.stream());
		 AllFrds.filter(s-> s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		 
		 //If we want to find any match is there or no which will return either true or false.
		 //NOw to perfoem an operation on new stram NewFrds we have to comment the above code as it performing some other operation so.
		 boolean Result = AllFrds.anyMatch(s-> s.equalsIgnoreCase("Abhilash"));
		 System.out.println("The result for any match is:" +Result);		
		
	}

}

package streams_Examples;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Collect {
	/*
	 * Most of the times we want to verify the things for that instead of printing values we can collect in list, set map.
	 * Because of this we can perform differnt validations on it.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//How to get different values from an array?  --> VIMP for interview
		//How to sort the values from an array?		--> VIMP for interview
		//How to get different values with sort?	--> VIMP for interview
		
		//All these interview questions we can solve by distinct() and sorted() function.
		
		Stream.of(1,2,3,2,3,5,6,5,7,7).distinct().sorted().forEach(s-> System.out.println("Values not in list:" + s));
		Stream.of(7,8,4,1,2,3,2,3,5,6,5,7,7).distinct().forEach(s-> System.out.println("Values not in list:" + s));
		
		//NOw instead of printing we can collect it to list.
		List<Integer> value_1 = Stream.of(1,2,3,2,3,5,6,5,7,7).distinct().sorted().collect(Collectors.toList());
		System.out.println("Values are in list:" + value_1);
		
		//Now as it in list we can get any value we want and also perform list operations.
		System.out.println(value_1.get(2));
		System.out.println(value_1.size());
		
		List Names_With_S = Stream.of("Satyam", "Ruturaj", "Shivam","Satyam", "Namdev", "Vidya", "Namdev").filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(Names_With_S);
		
		List Names_Distinct = Stream.of("Satyam", "Ruturaj", "Shivam","Satyam", "Namdev", "Vidya", "Namdev").distinct().collect(Collectors.toList());
		System.out.println(Names_Distinct);
		
		List Names_Distinct_Sorted = Stream.of("Satyam", "Ruturaj", "Shivam","Satyam", "Namdev", "Vidya", "Namdev").distinct().sorted().collect(Collectors.toList());
		System.out.println(Names_Distinct_Sorted);
	}

}

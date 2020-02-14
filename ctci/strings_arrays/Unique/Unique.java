import java.util.HashSet;
// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
public class Unique {
	public static void main(String[] args) {
		//Assume we always get the a valid input string

		// If we can use an additional data structure -> iterate the string and 
		// extract every character in a new data structure with unique entry
		// for every char i.e. if we consider the characters to be primite
		// chars from 0-256 then we can use a single array[256]. 
		char[] characters = new char[256];
		boolean unique = true;
		for(int stringIterator = 0; stringIterator < args[0].length(); stringIterator++) {
			char c = args[0].charAt(stringIterator);
			characters[c]++;
			if(characters[c] > 1) {
				unique = false;
				break;
			}
		}
		if(!unique)
			System.out.println("The string is not unique");
		else
			System.out.println("The string is unique");


		// Otherwise if we consider unicode a better solution is to use a hashset
		HashSet<Character> set = new HashSet();
		unique = true;
		for(int stringIterator = 0; stringIterator < args[0].length(); stringIterator++) {
			if(set.contains(args[0].charAt(stringIterator))) {
				unique = false;
				break;
			}
			set.add(args[0].charAt(stringIterator));
		}
		if(!unique)
			System.out.println("The string is not unique");
		else
			System.out.println("The string is unique");

		unique = true;
		// If we can't use aditional data structure we should double iterate through the string
		for(int stringIterator = 0; stringIterator < args[0].length(); stringIterator++) {
			for(int backIterator = stringIterator+1; backIterator < args[0].length(); backIterator++)
				if(args[0].charAt(stringIterator) == args[0].charAt(backIterator)){
					unique = false;
					break;
				}
		}	
		if(!unique)
			System.out.println("The string is not unique");
		else
			System.out.println("The string is unique");

	}
}
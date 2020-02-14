// 1.2 Check Permutation:
// Given two strings, write a method to decide if one is a permutation of the other.
// Example: baab and abab
import java.util.HashMap;
public class Permutation {
	public static void main(String[] args) {

		// Test first if they have the same number of chars
		if(args[0].length() != args[1].length()) {
			System.out.println("Strings are not a permutation of each other");
			return;
		}

		// We need to check if we have the same characters with the same frequency
		// We could use an aditional data structure that will map {character; frequency}
		// With no aditional data structure -> Iterate the first string and for each character iterate
		// the second string to find the same character. If found remove it, otherwise stop -> they're not permutation
		
		//First solution - use a hashmap
		HashMap<Character, Integer> chars = new HashMap();
		for(int stringIterator = 0; stringIterator < args[0].length(); stringIterator++) {
			chars.put(args[0].charAt(stringIterator), chars.getOrDefault(args[0].charAt(stringIterator), 0)+1);
			chars.put(args[1].charAt(stringIterator), chars.getOrDefault(args[1].charAt(stringIterator), 0)-1);
		}

		//Second solution do it in place by removing the characters in the second string
		boolean found = false;
		for(int firstStringIterator = 0; firstStringIterator < args[0].length(); firstStringIterator++) {
			found = false;
			for(int secondStringIterator = 0; secondStringIterator < args[1].length(); secondStringIterator++) {				
				if(args[0].charAt(firstStringIterator) == args[1].charAt(secondStringIterator)) {
					args[1] = args[1].substring(0,secondStringIterator)+args[1].substring(secondStringIterator+1, args[1].length());
					found = true;
					break;
				}				
			}
			if(!found) 
					break;
		}
		if(found && args[1].length() == 0) 
			System.out.println("Strings are a permutation of each other " );
		else
			System.out.println("Strings are not a permutation of each other");



	}
}

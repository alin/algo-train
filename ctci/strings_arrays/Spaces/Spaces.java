// Write a method to replace all spaces in a string with '%20'. You may assume that the string has 
// sufficient space at the end to hold the additional characters and that you are given the "true" 
// length of the string. (Note: if implementing in Java, please use a character array so that you 
// can perform this operation in place)
public class Spaces {

	public static void main(String[] args)	{
		// Make it big enough
		char[] string = new char[1000];
		args[0].getChars(0, args[0].length(), string, 0);

		// Mark the end of the string with a \0 in the array
		string[args[0].length()] = '\0';
		
		// Count the spaces
		int index = 0;
		int spacesCount = 0;
		while(string[index] != '\0') {
			if(string[index++] == ' ')
			spacesCount++;
		}

		// This is the new length of the string
		int reverseIndex = index + spacesCount*2;
		// Iterate backwards and move chars one by one starting at the end of the string
		// if there is a space add %20 instead of it
		while(index > 0) {
			char current = string[index];
			if(current != ' ')
				string[reverseIndex--] = current;
			else {
				string[reverseIndex--] = '0';
				string[reverseIndex--]='2';
				string[reverseIndex--]='%';
			}
			index --;
		}

		System.out.println(string);
	}
}
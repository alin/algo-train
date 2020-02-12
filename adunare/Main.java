import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Main {
	public static String[] readData() {
		try {
			FileReader inputReader = new FileReader("adunare.in");
			BufferedReader bufferedReader = new BufferedReader(inputReader);
			String a = bufferedReader.readLine();
			String b = bufferedReader.readLine();
			if(b.length() > a.length()) {
			return new String[] {b , a};
		} 
			return new String[] {a , b};
		} catch (Exception e) {
			System.out.println("File not found: ");
		}
		return null;
	}

	public static void writeData(ArrayList<Character> c) {
		BufferedWriter output = null;
        try {
            File file = new File("adunare.out");
            output = new BufferedWriter(new FileWriter(file));
            for(int i = c.size(); i > 0;)
				output.write(c.get(--i));
			output.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        } 
    }

    public static ArrayList<Character> sum(String[] numbers)
    {
		ArrayList<Character> c = new ArrayList<Character>(50);
		int dif = numbers[0].length()-numbers[1].length();
		int extra = 0;
		int iterator, sum, mod, j = 0;
		char v2, v1 = 0;

		for(iterator = numbers[0].length()-1; iterator >= 0; iterator--) {
			v1 = (char)(((Character)numbers[0].charAt(iterator)).charValue()- '0');
			v2 = iterator-dif >= 0 ? v2 = (char)(((Character)numbers[1].charAt(iterator-dif)).charValue()-'0') : 0;
			sum = v1 + v2 + extra;
			mod = sum % 10;
			extra = sum / 10;
			if(c.size() == j++)
				c.add((char)(mod+'0'));
			else
				c.set(j, (char)(mod+'0'));
		}

		if(extra != 0) {
			if(c.size() == j)
				c.add((char)(extra+'0'));
			else
				c.set(j++, (char)(extra+'0'));
		}
		return c;
    }

	public static void main(String[] args) {
		writeData(sum(readData()));
	}
}
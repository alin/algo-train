
import java.io.*;

public class Main {
	static int[] values;

	static void readAndWrite() {
		try {
		BufferedReader br = new BufferedReader(new FileReader("cifra.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("cifra.out"));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i<=t; i++) {
			String line = br.readLine();
			int where = (line.length()>2)? line.length()-2 : 0; 
			int n = Integer.parseInt(line.substring(where));
			bw.write(values[n]+"\n");
		}
		br.close();
		bw.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}

	}

	static int power(int val) {
		int x = (val >= 10) ? val % 10 : val;
		int pow = x;
		int n= val;
		while(--n > 0) {
			pow = pow * x;
			pow = (pow > 10) ? pow % 10 : pow;
		}
		return pow;
	}

	static void precompute() {
		values = new int[100];
		for(int i = 1; i < 100; i++) {
			values[i] = (power(i)+values[i-1])%10;
		}
	}

	public static void main(String[] args) {
		precompute();
		readAndWrite();
	}
}
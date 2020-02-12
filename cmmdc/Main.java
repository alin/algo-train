import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
	public static long[] readData() {
		try { BufferedReader br = new BufferedReader(new FileReader("cmmdc.in"));
			long a = Long.parseLong(br.readLine());
			long b = Long.parseLong(br.readLine());
			if(a < b) {
				a = a ^ b;
				b = a ^ b;
				a = a ^ b;
			}

			br.close();
			return new long[] {a, b};
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}

	public static void writeData(long number) {
		// System.out.println("cmmdc: " + number);
		try { BufferedWriter bw = new BufferedWriter(new FileWriter("cmmdc.out"));
			bw.write(number+"");
			bw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long cmmdc(long[] numbers) {
		long a = numbers[0];
		long b = numbers[1];
		long cat, rest = 1;
		//swap
		while(b != 0) {
			// System.out.println(a +" " + b);
			rest = a % b;
			a = b;
			b = rest;
		}

		if(a == 1) return 0;
		return a;
	}

	public static void main(String[] args) {
		writeData(cmmdc(readData()));
	}
}
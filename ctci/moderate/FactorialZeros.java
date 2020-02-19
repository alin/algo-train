//Calculate the number of zeros a factorial has
public class FactorialZeros {
	public static void main(String[] args) {
		// example
		// 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20*21*22*23*24*25*26
		// We can see that the number of zeroes is determined by
		// 2*5 products and 10s
		// We must find how many of these are 
		// 2s are plenty so we only need the 5s
		// For example in 50! we have: 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 -> 12 - 50/5 -> 10 + 1 extra for the 25 and 1 extra for 50 which is 25*2
		// and so on until 125 which is 5^3
		// So we must count the multiples of power of 5s that are in that range - how many multiples of 5, how many multiples of 25, etc.
		long n = Long.parseLong(args[0]);
		int count = 0;
		for(int i = 5; n / i > 0; i*=5) {
			count += n / i;
		}
		System.out.println(count);
	}
}
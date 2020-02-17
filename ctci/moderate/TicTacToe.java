// Design an algorithm to figure out if someone won a tictactoe game
public class TicTacToe {
	public static void main(String[] args) {
		int len = (int)Math.sqrt(args[0].length());
		int[][] matrix = new int[len][len];
		for(int i = 0; i < args[0].length(); i++) {
			if(args[0].charAt(i)=='x')
				matrix[i/len][i%len] = 1;
			else if(args[0].charAt(i) == '0')
				matrix[i/len][i%len] = -1;
			else matrix[i/len][i%len] = (len+1);
		}

		int sum;

		for(int i = 0; i < len; i++) {
			sum = 0;
			for(int j = 0; j < len; j++) {
				sum += matrix[i][j];
			}
			
			if(sum == len || sum == len*-1) {
				System.out.println("\nWe have a winner on row " + (i+1));
				return;
			}
		}

		for(int i = 0; i < len; i++) {
			sum = 0;
			for(int j = 0; j < len; j++)
				sum += matrix[j][i];
			if(sum == len || sum == len*-1) {
				System.out.println("\nWe have a winner on column " + (i+1));
				return;
			}
		}

		sum = 0;

		for(int i = 0; i < len; i++) {
			sum += matrix[i][i];
			if(sum == len || sum == len*-1) {
				System.out.println("\nWe have a winner on diagonal");
				return;
			}
		}
	}
}
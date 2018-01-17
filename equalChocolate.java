import java.util.Scanner;

public class equalChocolate {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int numColleagues = in.nextInt();
        int[] chocolate = new int[numColleagues];
        for (int i = 0; i < numColleagues; i++) {
        	int amount = in.nextInt();
        	min = Math.min(min, amount);
        	chocolate[i] = amount;
        }
        
        int moves = minMoves(chocolate, min, numColleagues);
        
        System.out.println(moves);
        
    }

	private static int minMoves(int[] chocolate, int min, int numColleagues) {
		int minMoves = Integer.MAX_VALUE;
		for (int base = 0; base <= min; base++) {
			int target = min - base;
			int moves = 0;
			for (int i = 0; i < numColleagues; i++) {
				int delta = chocolate[i] - target;
				// delta[i] = a[i]*5 + b[i]*2 + c[i]*1
				moves += (delta/5) + (delta%5)/2 + ((delta%5)%2);
			}
			minMoves = Math.min(minMoves, moves);
		}
		return minMoves;
	}
	
}
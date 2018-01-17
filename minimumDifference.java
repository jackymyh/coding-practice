import java.util.Arrays;
import java.util.Scanner;

public class minimumDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        System.out.println(minDiff(a, n));
    }

	private static int minDiff(int[] a, int length) {
		Arrays.sort(a);
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < length-1; i++) {
            minDiff = Math.min(minDiff, Math.abs(a[i] - a[i+1]));
        }
        
        return minDiff;
	}
}

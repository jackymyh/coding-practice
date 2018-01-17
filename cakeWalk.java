import java.util.Arrays;
import java.util.Scanner;

public class cakeWalk {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calories = new int[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        
        Arrays.sort(calories);
        
        long total = 0;
        for (int i = 0; i < n; i++) {
        	total += (long) (Math.pow(2, i) * calories[n - 1 - i]);
        }
        
        System.out.println(total);
    }
}

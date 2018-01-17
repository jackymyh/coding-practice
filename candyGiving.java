import java.util.Scanner;

public class candyGiving {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] rating = new int[num];
        for (int i = 0; i < num; i++) {
            rating[i] = in.nextInt();
        }
        
        int sum = minCandy(num, rating);
        
        System.out.println(sum);
    }

	private static int minCandy(int num, int[] rating) {
		int[] total = new int[num];
        
        for (int n = 1; n < num; n++) {
        	if (rating[n] > rating[n-1]) {
        		total[n] = total[n-1] + 1;
        	}
        }
        
        for (int m = num-2; m >= 0; m--) {
        	if (rating[m] > rating[m+1]) {
        		total[m] = Math.max(total[m], total[m+1] + 1);
        	}
        }
        
        int sum = 0;
        
        for (int candy : total) {
        	sum += candy;
        }
		return sum + num;
	}
}
import java.util.Arrays;
import java.util.Scanner;

public class radioTransmitter {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] x = new int[]{5,4,3,2,1};
        int n = x.length;
        
        int count = countTransmitter(n, k, x);

        System.out.println(count);
    }

	private static int countTransmitter(int n, int k, int[] houses) {
		Arrays.sort(houses);
        int count = 0;
        int i = 0;
        while(i < n) {
            count++;
            int start = houses[i] + k;
            while (i < n && houses[i] <= start) {
                i++;
            }
            //center location of the transmitter
            i--;
            int end = houses[i] + k;
            while (i < n && houses[i] <= end) {
                i++;
            }
        }
		return count;
	}
}
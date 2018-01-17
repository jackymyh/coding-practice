import java.util.HashMap;
import java.util.Scanner;

public class verticalSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = in.nextInt();
            int[] Y = new int[n];
            HashMap<Integer, Integer> count = new HashMap<>();
            
            // put height values into array Y and keep count of heights in hashmap
            for (int i = 0; i < n; i++) {
                int height = in.nextInt();
                Y[i] = height;
                if (count.containsKey(height)) {
                	count.put(height, count.get(height)+1);
                } else {
                	count.put(height, 1);
                }
            }
            
            countSticks(n, Y, count);
            
            double expected = sumExpectations(n, Y);
            
            System.out.printf("%.2f", expected);
        }
    }

	private static double sumExpectations(int n, int[] Y) {
		// summing total expectations by e = (n+1)/(k+1)
		double expected = 0;
		for (int i = 0; i < n; i++) {
			expected += ((n+1.0) / (Y[i]+1.0));
		}
		return expected;
	}

	private static void countSticks(int n, int[] Y, HashMap<Integer, Integer> count) {
		// calculate how many heights are greater or equal to Y[i] and put into Y[i]
		for (int i = 0; i < n; i++) {
			int target = Y[i];
			int total = 0;
			for (Integer height : count.keySet()) {
				if (height >= target) {
					total += count.get(height);
				}
			}
			//System.out.println(target + " : " + total);
			Y[i] = total;
		}
	}
}
public class knapSack {

	public static int maxValue(int capacity, int[] weight, int[] value, int items) {
		//input error
		if (weight.length != value.length) return -1;
		
		//base case
		if (capacity == 0 || items == 0) {
			return 0;
		}
		
		int[][] dp = new int[items + 1][capacity + 1];
		
		//build dp table
		for (int i = 0; i <= items; i++) {
			for (int c = 0; c <= capacity; c++) {
				if (c == 0 || i == 0) {
					dp[i][c] = 0;
				} else if (weight[i-1] <= c) {
					dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-weight[i-1]] + value[i-1]);
				} else {
					dp[i][c] = dp[i-1][c];
				}
			}
		}
		
		return dp[items][capacity];
		
//		//naive recursive solution
//		if (weight[items-1] > capacity) {
//			return maxValue(capacity, weight, value, items-1);
//		} else {
//			return Math.max(maxValue(capacity - weight[items-1], weight, value, items-1) + value[items-1], 
//					maxValue(capacity, weight, value, items-1));
//		}

	}
	
	public static void main(String[] args) {
		int[] val = new int[]{120, 100, 60, 170};
        int[] wt = new int[]{3, 2, 1, 4};
        int capacity = 5;
        int n = val.length;
        
        System.out.println(maxValue(capacity, wt, val, n)); // 230
	}

}
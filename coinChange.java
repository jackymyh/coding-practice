import java.util.Arrays;

public class coinChange {

    private static long getWays(long n, long[] c){
    	// Memoized DP solution
    	return dpTable(n, c, c.length);
    	
//    	// Naive recursive solution
//    	Arrays.sort(c);
//    	return countWays(n, c, 0);
    }
    
    private static long dpTable(long n, long[] c, int i) {
    	long[][] dp = new long[(int) (n+1)][i+1];
    	
    	for (int coin = 0; coin <= i; coin++) {
    		for (int total = 0; total <= n; total++) {
    			if (total == 0 || coin == 0) {
    				dp[total][coin] = 0;
    			} else if (c[coin-1] == total) {
    				dp[total][coin] = 1 + dp[total][coin-1];
    			} else if (c[coin-1] > total) {
    				dp[total][coin] = dp[total][coin-1];
    			} else {
    				dp[total][coin] = dp[(int) (total - c[coin-1])][coin] + dp[total][coin-1];
    			}
    		}
    	}
    	
    	return dp[(int)n][i];
    }
	
    private static long countWays(long n, long[] c, int i) {
		if (n == 0) return 1;
    	if (i >= c.length || c[i] > n) return 0;
    	
    	
    	return countWays(n - c[i], c, i) + countWays(n, c, i+1);
	}

    public static void main(String[] args) {
        int n = 10;
        long[] c = new long[]{2,5,3,6};
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        
        System.out.print(ways); // 5
    }
}

public class buySellStock {

	public static int maxProfit1(int[] prices) {
		if (prices.length == 0) return 0;

		int maxP = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min) {
				maxP = Math.max(maxP, prices[i] - min);
			} else {
				min = prices[i];
			}
		}

		return maxP;
	}

	public static int maxProfit2(int[] prices) {
		if (prices.length == 0) return 0;

		int maxP = 0;

		for (int i = 1; i < prices.length - 1; i++) {
			if (prices[i] < prices[i+1]) {
				maxP += prices[i+1] - prices[i];
			}
		}

		return maxP;
	}

	public static void main(String[] args) {

	}
}
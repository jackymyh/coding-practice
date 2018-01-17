public class sortSequence {
	private static int[] sortFrom(int[] nums) {
		int[] result = new int[2];
		result[0] = -1;
		int sortedMax = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < sortedMax) {
				result[1] = i;
				if (result[0] == -1) {
					int j = 1;
					while ((i >= j) && !(nums[i] > nums[i - j])) {
						j++;
					}
					result[0] = i - j + 1;
				} else {
					int k = 1;
					while ((result[0] >= k) && (nums[i] < nums[result[0] - k])) {
						k++;
					}
					result[0] = result[0] - k + 1;
				}
			} else {
				sortedMax = nums[i];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		
		int[] ans = sortFrom(nums);
		System.out.println(ans[0] + ", " + ans[1]);
	}
}
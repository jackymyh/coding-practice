import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
	private static List<List<Integer>> threeSumFind (int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i ++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int start = i + 1;
				int end = nums.length - 1;
				
				while (start < end) {
					if (nums[i] + nums[start] + nums[end] == 0) {
						results.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
					}
					
					if (nums[i] + nums[start] + nums[end] < 0) {
						int currStart = start;
						while (nums[currStart] == nums[start] && start < end) {
							start++;
						}
					} else {
						int currEnd = end;
						while (nums[currEnd] == nums[end] && start < end) {
							end--;
						}
					}
				}
			}
		}
		
		return results;
	}
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4, 3, 2, -5, -6, 5};
		
		System.out.println(threeSumFind(nums));
	}
}
import java.util.HashMap;

public class twoSum {
	private static void twoSumFind(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return;
		}
		
		HashMap<Integer, Integer> values = new HashMap<>();
		
		for (int num : nums) {
			int remain = target - num;
			if (values.containsKey(remain)) {
				System.out.println(num + ", " + remain);
				int count = values.get(remain);
				if (count == 1) {
					values.remove(remain);
				} else {
					count--;
					values.put(remain, count);
				}
			} else {
				if (values.containsKey(num)) {
					values.put(num, values.get(num) + 1);
				} else {
					values.put(num, 1);
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,1,2,3,3,1,2,5,4,1};
		twoSumFind(nums, 5);
	}
}
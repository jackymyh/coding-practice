import java.util.ArrayList;

public class windowSum {
	
	public static ArrayList<Integer> slidingSum(ArrayList<Integer> nums, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		int sum = 0;
		
		for (int i = 0; i < k; i++) {
			sum += nums.get(i);
		}
		result.add(sum);
		
		for (int i = k; i < nums.size(); i++) {
			sum -= nums.get(i - k);
			sum += nums.get(i);
			result.add(sum);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(5);
		nums.add(2);
		nums.add(4);
		nums.add(11);
		nums.add(74);
		
		ArrayList<Integer> result = slidingSum(nums, 3);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result);
		}
			
	}
}
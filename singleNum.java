public class singleNum {
	public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] test = {1,1,2,9,2,6,6}; // 9
		
		System.out.println(singleNumber(test));
	}
}
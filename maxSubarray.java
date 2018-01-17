public class maxSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int localMax = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
    
    public static void main(String[] args) {
    	int[] test = {-2,1,-3,4,-1,2,1,-5,4};
    	
    	System.out.println(maxSubArray(test));
    }
}
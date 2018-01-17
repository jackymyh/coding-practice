public class sumRange {
    int[] nums;
    int[] sum;
    
    public sumRange(int[] nums) {
        this.sum = new int [nums.length];
        this.nums = nums;
        
        if (nums.length != 0) sumArray();
    }
    
    public int getSumRange(int i, int j) {
        if (i == 0) return sum[j];
        
        return sum[j] - sum[i-1];
    }
    
    public void sumArray() {
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,0,3,-5,2,-1};
    	sumRange test = new sumRange(nums);
    	
    	for (int i = 0; i < nums.length; i++) {
    		System.out.println(test.sum[i]);
    	}
    	
    	System.out.println(test.getSumRange(2,3));
    }
    
}

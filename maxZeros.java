public class maxZeros {
	private static int max(boolean[] arr) {
		int result = 0;
		int localMax = 0;
		int globalMax = 0;
		int value = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == false) {
				result++;
				value = -1;
			} else {
				value = 1;
			}
			
			localMax = Math.max(value, localMax + value);
			globalMax = Math.max(localMax, globalMax);
		}
		
		return result + globalMax;
	}
	
	public static void main(String[] args) {
		boolean[] arr1 = {false, true, false, false, true, true, false};
		boolean[] arr2 = {false, false, false, true, false, true};
		
		System.out.println(max(arr1)); //6
		System.out.println(max(arr2)); //5
	}
}
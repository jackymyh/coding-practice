public class minJumps {
	private static int minJump(int[] arr, int start, int end) {
		if (start == end) return 0;
		if (arr[start] == 0) return Integer.MAX_VALUE;

		int[] jumps = new int[arr.length];
		
		jumps[0] = 0;
		
		for (int i = 1; i <= end; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j]) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				}
			}
		}
		
		return jumps[end];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		System.out.println(minJump(arr, 0, arr.length - 1));
	}
}
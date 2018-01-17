public class longestPalindrome {
    public static int longestPal(String s) {
        int[] count = new int[256];
        int single = 0;
        int pair = 0;
        char[] str = s.toCharArray();
        for (char c : str) {
            int index = (int)(c - 'A');
            count[index]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0) {
                pair += count[i];
            } else if (count[i] % 2 == 1 && single == 0) {
                pair += count[i] - 1;
                single = 1;
            } else {
                pair += count[i] - 1;
            }
        }
        return single + pair;
    }
    
    public static void main(String[] args) {
    	String s = "abccccdd"; // 7
    	
    	System.out.println(longestPal(s));
    }
}
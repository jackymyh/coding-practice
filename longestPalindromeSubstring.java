public class longestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        int size = s.length()-1, left = 0, right = 1;
        if (s.length() < 2) return s;
        
        while (size >= 1) {
            for (int i = 0; i + size < s.length(); i++) {
                if (isPal(s, i, i + size)) {
                    left = i;
                    right = i + size + 1;
                    return s.substring(left, right);
                }
            }
            size--;
        }
        
        return s.substring(left, right);
    }
    
    private static boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "daad";
		String s3 = "ababb";
		String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaa";
		String s5 = "asdfghgfdsa";
		
		System.out.println(longestPalindrome(s1)); //"a"
		System.out.println(longestPalindrome(s2)); //"daad"
		System.out.println(longestPalindrome(s3)); //"aba"
		System.out.println(longestPalindrome(s4)); //"aaaaaaaaaaaaaaaaaaaaaaaaa"
		System.out.println(longestPalindrome(s5)); //"asdfghgfdsa"
	}
}
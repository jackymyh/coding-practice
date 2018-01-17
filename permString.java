import java.util.HashMap;

public class permString {
	public static void main(String[] args) {
		String s1 = "aaaaa";
		String s2 = "ababa";
		String s3 = "abccdeeee";
		String s4 = "eeeabcecd";
		String s5 = "abcce";
		
		System.out.println(perm(s1, s2)); //F
		System.out.println(perm(s3, s4)); //T
		System.out.println(perm(s4, s5)); //F
	}
	
	public static boolean perm(String str, String str2) {
		HashMap<Character, Integer> count = new HashMap<>();
		if (str == null || str2 == null || str.length() != str2.length()) return false;
		for (char c : str.toCharArray()) {
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			} else {
				count.put(c, 1);
			}
		}
		
		for (int i = 0; i < str2.length(); i++) {
			char s = str2.charAt(i);
			if (count.containsKey(s)) {
				count.put(s, count.get(s) - 1);
				if (count.get(s) == 0) {
					count.remove(s);
				}
			} else {
				return false;
			}
		}
		return count.size() == 0;
	}

}
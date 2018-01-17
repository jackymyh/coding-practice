import java.util.HashMap;

public class compressString {
	private static String compress(String str) {
		if (str == null || str.length() <= 1) return str;
		
		HashMap<Character, Integer> letterCount = new HashMap<>();
		
		for (char c : str.toCharArray()) {
			int count = letterCount.getOrDefault(c, 0) + 1;
			letterCount.put(c, count);
		}
		
		//System.out.println(letterCount);
		
		StringBuilder compressedStr = new StringBuilder();
		
		for (char letter : letterCount.keySet()) {
			compressedStr.append(letter);
			compressedStr.append(letterCount.get(letter));
		}
		
		String result = compressedStr.toString();
		
		if (result.length() <= str.length()) return result;

		return str;
	}
	public static void main(String[] args) {
		String str1 = "";
		String str2 = "a";
		String str3 = "aaaabbbbcccd";
		String str4 = "abcd";
		
		System.out.println(compress(str1));
		System.out.println(compress(str2));
		System.out.println(compress(str3));
		System.out.println(compress(str4));
	}
}
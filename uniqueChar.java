import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class uniqueChar {
	private static List<Character> uniqueLetter(String str1, String str2) {
		List<Character> result = new ArrayList<>();
		
		HashMap<Character, Integer> letters = new HashMap<>();
		
		for (char c : str1.toCharArray()) {
			letters.putIfAbsent(c, 1);
		}
		
		for (char c : str2.toCharArray()) {
			int present = letters.getOrDefault(c, 2);
			if (present == 1) {
				letters.put(c, -1);
			} else if (present == 2) {
				letters.put(c, 2);
			} else {
				continue;
			}
		}
		
		for (char c : letters.keySet()) {
			if (letters.get(c) != -1) {
				result.add(c);
			}
		}
		
		Collections.sort(result);
		
		return result;
	}
	public static void main(String[] args) {
		String str1 = "characters";
		String str2 = "alphabets";
		
		List<Character> result = uniqueLetter(str1, str2);
		
		for (char c : result) {
			System.out.print(c + " ");
		}
	}
}
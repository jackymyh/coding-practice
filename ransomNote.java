import java.util.HashMap;

public class ransomNote {
    private static boolean canConstruct(String ransomNote, String magazine) {
    	if (ransomNote == null || ransomNote.length() == 0) return true;
    	if (ransomNote.length() > magazine.length() || magazine == null || magazine.length() == 0) return false;
    	
    	HashMap<Character, Integer> letterCount = new HashMap<>();

        for (char letter : magazine.toCharArray()) {
            if (letterCount.containsKey(letter)) {
            	letterCount.put(letter, letterCount.get(letter) + 1);
            } else {
            	letterCount.put(letter, 1);
            }
        }
        
        for (char letter : ransomNote.toCharArray()) {
        	if (!letterCount.containsKey(letter)) {
        		return false;
        	} else {
        		if (letterCount.get(letter) == 1) {
        			letterCount.remove(letter);
        		} else {
        			letterCount.put(letter, letterCount.get(letter) - 1);
        		}
        	}
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	String ransom = "this";
    	String magazine = "shit";
    	
    	System.out.println(canConstruct(ransom, magazine));
    }
}
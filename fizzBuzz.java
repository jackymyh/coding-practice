import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
	
    public static List<String> listFizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        if (n < 1) return result;
        
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	List<String> fizzBuzz = listFizzBuzz(15);
    	
    	System.out.println(fizzBuzz);
    }
}
import java.util.Deque;
import java.util.LinkedList;

public class parenthesisChecker {
	
	public static boolean parenCheck(String s) {

		Deque<Character> stack = new LinkedList<Character>();
		
		char[] parenString = s.toCharArray();
		
		for(int i = 0; i < parenString.length; i++) {
			if (parenString[i] == '[' || parenString[i] == '(' || parenString[i] == '{') {
				//push beginning parenthesis to stack
				stack.push(parenString[i]);
			} else {
				//check if anything in stack to compare
				if(!stack.isEmpty()) {
					char c = stack.pop();
					//check if correct pair
					if (!isPair(c, parenString[i])) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		//check if anything still in stack left unpaired
		if(!stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isPair(char c1, char c2) {
		if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		String s1 = "[()](){}[()]"; //true
		String s2 = "{}{()}{{}"; //false
		
		if (parenCheck(s2)) {
			System.out.println("Parenthesis is ok");
		} else {
			System.out.println("Parenthesis is not ok");
		}
	}
}
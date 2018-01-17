import java.math.BigInteger;

public class bigInteger {
	private static BigInteger factorial(int n) {
		if (n < 0) return null;
		
		BigInteger base = new BigInteger("1");
		
		for (int i = 1; i <= n; i++) {
			base = base.multiply(BigInteger.valueOf(i));
		}
		
		return base;
	}
	
	private static BigInteger modFib(int t1, int t2, int n) {
		BigInteger first = new BigInteger(Integer.toString(t1));
		BigInteger second = new BigInteger(Integer.toString(t2));
		
		for (int i = 3; i <= n; i++) {
			BigInteger temp = first.add(second.pow(2));
			first = second;
			second = temp;
		}
		
		return second;
	}
	
	public static void main(String[] args) {
		System.out.println("Factorial of -2: " + factorial(-2));
		System.out.println("Factorial of 0: " + factorial(0));
		System.out.println("Factorial of 1: " + factorial(1));
		System.out.println("Factorial of 2: " + factorial(2));
		System.out.println("Factorial of 10: " + factorial(10));
		System.out.println("Factorial of 25: " + factorial(25));
		
		System.out.println("6th term of modFib: " + modFib(0,1,6));
		System.out.println("10th term of modFib: " + modFib(0,1,10));
	}
}
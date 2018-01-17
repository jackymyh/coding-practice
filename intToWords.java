public class intToWords {
	private static String valueToWords(int value) {
		String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		StringBuilder result = new StringBuilder();
		
		//Hundreds place
		if (value >= 100) {
			result.append(ones[(value / 100) - 1] + " hundred ");
			value %= 100;
		}

		//Tens place
		if ((value < 20) && (value > 10)) {
			result.append(teens[(value % 10) - 1]);
			return result.toString();
		} else if (value == 10 || value >= 20) {
			result.append(tens[(value / 10) - 1] + " ");
			value %= 10;
		}

		//Ones place
		if (value >= 1 && value <= 9) {
			result.append(ones[value - 1]);
		}

		return result.toString();
	}

	private static String intToWords(int value) {
		if (value == 0) return "zero";
		
		String[] placements = {"million", "thousand"};
		
		StringBuilder result = new StringBuilder();
		
		if (value < 0) {
			result.append("negative ");
			value *= -1;
		}
		
		if (value >= 1000000) {
			result.append(valueToWords(value / 1000000) + " " + placements[0] + " ");
			value %= 1000000;
		}
		
		if (value >= 1000) {
			result.append(valueToWords(value / 1000) + " " + placements[1] + " ");
			value %= 1000;
		}
		
		//Hundreds place
		if (value < 1000) {
			result.append(valueToWords(value));
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToWords(-112302401));
	}
}
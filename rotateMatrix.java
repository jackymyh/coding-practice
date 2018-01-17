public class rotateMatrix {

	private static void rotate(int[][] matrix, boolean left) {
		if (left) {
			//Rotate matrix 90 degrees left
			transpose(matrix);
			swapRows(matrix);
		} else {
			//Rotate matrix 90 degrees right
			swapRows(matrix);
			transpose(matrix);
		}
	}
	
	private static void transpose(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				if (i != j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
	}
	
	private static void swapRows(int[][] matrix) {
		for (int i = 0; i < matrix.length/2; i++) {
			int[] temp = matrix[i];
			matrix[i] = matrix[matrix.length - 1 - i];
			matrix[matrix.length - 1 - i] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		int MATRIX_SIZE = 3;
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		int count = 0;
		
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				matrix[i][j] = count;
				count++;
			}
		}
		
		System.out.println("====================");
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				System.out.print("  " + matrix[i][j] + "  ");
			}
			System.out.println(" ");
		}
		rotate(matrix, true);
		System.out.println("====================");
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				System.out.print("  " + matrix[i][j] + "  ");
			}
			System.out.println(" ");
		}
		System.out.println("====================");
		
	}
}
public class migratoryBirds {

    static int mostBirds(int n, int[] ar) {
        int[] count = {0,0,0,0,0};
        
        for (int i = 0; i < n; i++) {
        	count[ar[i]-1]++;
        }
        
        int index = 0, max = 0;
        
        for (int j = 0; j < count.length; j++) {
        	if (count[j] > max) {
        		index = j;
        		max = count[j];
        	}
        }
        
        return index+1;
    }

    public static void main(String[] args) {
        int[] ar = {1,5,5,2,3,4,2,2,2,2,2,2,2,2,1,1,3,4,3,5,5,5};
        int result = mostBirds(ar.length, ar);
        System.out.println(result);
    }
}
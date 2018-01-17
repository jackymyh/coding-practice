import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class luckBalance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int contests = in.nextInt();
        int canLose = in.nextInt();
        
        int luckBalance = 0;
        
        List<Integer> important = new ArrayList<>();
        
        for (int i = 0; i < contests; i++) {
            int luck = in.nextInt();
            int importance = in.nextInt();
            if (importance == 1) {
                important.add(luck);
            } else {
                luckBalance += luck;
            }
        }
        
        Collections.sort(important, new Comparator<Integer>(){
        	public int compare(Integer a, Integer b) {
        		return b.compareTo(a);
        	}
        });
        //System.out.println("important: " + important);
        
        for (int contest : important) {
        	//System.out.println("Can Lose: " + canLose);
            if (canLose > 0) {
            	luckBalance += contest;
                //System.out.println("Add: " + contest);
                canLose--;
            } else {
            	luckBalance -= contest;
                //System.out.println("Subtract: " + contest);
            }
            //System.out.println("Luck Balance: " + luckBalance);
        }
        
        System.out.println(luckBalance);
    }
}
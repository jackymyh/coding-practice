import java.io.*;
import java.util.*;

public class maximumDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int tests = in.nextInt();
        int length = in.nextInt();
        int[] B = new int[length];
        
        for (int i  = 0; i < length; i++) {
            B[i] = in.nextInt();
        }
        
        int[] s1 = new int[length];
        int[] s2 = new int[length];
        
        for (int j = 1; j < length; j++) {
        	int loLo = 0;
        	int hiLo = Math.abs(B[j-1] - 1);
        	int loHi = Math.abs(1 - B[j]);
        	int hiHi = Math.abs(B[j-1] - B[j]);
        	
        	// choosing lower bound for A[i]
        	s1[j] = Math.max(s1[j-1] + loLo, s2[j-1] + hiLo);
        	// choosing higher bound for A[i]
        	s2[j] = Math.max(s2[j-1] + hiHi, s1[j-1] + loHi);
        } 
        
        int max = Math.max(s1[length-1], s2[length-1]);
        
        System.out.println(max);
    }
}
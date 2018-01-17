import java.util.Scanner;

public class reduceString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == (s.charAt(i+1))) {
                s = s.substring(0,i) + s.substring(i+2);
                i = -1;
            }
        }
        if (s.length() == 0) {
            System.out.print("Empty String");
        } else {
            System.out.print(s);
        }
    }
}
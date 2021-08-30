
/* Title: Java input formate error
coder:Pavan Chavan
date: 29/8/21 */
import java.util.Scanner;

public class JavaOutputFormate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x); // -15 is left aligh with 15 spacec on right, 03 is 3 digit must
                                                     // field with 0 %n is next line
        }
        System.out.println("================================");
        sc.close();
    }
}

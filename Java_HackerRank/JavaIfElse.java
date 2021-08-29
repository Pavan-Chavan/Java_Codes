/* Title: Java If else 
coder:Pavan Chavan
date: 29/8/21 */

import java.util.*;

public class JavaIfElse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (n % 2 == 0) {
            if (n >= 2 && n <= 5)
                System.out.println("Not Weird");
            else if (n >= 6 && n <= 20)
                System.out.println("Weird");
            else if (n >= 20)
                System.out.println("Not Weird");
        } else
            System.out.println("Weird");
        scanner.close();
    }
}

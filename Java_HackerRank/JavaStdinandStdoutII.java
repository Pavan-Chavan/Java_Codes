/* Title: Java Stdin and Stdout II
coder:Pavan Chavan
date: 29/8/21 */

import java.util.Scanner;
import java.lang.String;

public class JavaStdinandStdoutII {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine(); // this instruciton to clear keyboard buffer
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

        scan.close();
    }
}

/* Title: Java Loops
coder:Pavan Chavan
date: 29/8/21 */

import java.util.*;

class JavaLoopsII {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                System.out.print(a + ((int) Math.pow(2, j) * b) + " ");
                a = a + (int) Math.pow(2, j) * b;
            }
            System.out.println();
        }
        in.close();
    }
}

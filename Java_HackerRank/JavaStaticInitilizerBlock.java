/* Title: Java Static block initilizer 
coder:Pavan Chavan
date: 29/8/21 */

import java.util.*;

public class JavaStaticInitilizerBlock {

    static boolean flag = true;
    static int area, B, H;
    static {
        try {
            flag = true;
            Scanner sc = new Scanner(System.in);
            B = sc.nextInt();
            H = sc.nextInt();
            sc.close();
            if (B <= 0 || H <= 0) {
                flag = false;
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }// end of main

}// end of class

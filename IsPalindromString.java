// Title:- to find the given string is palindrom or not using preefine methods
// Name of coder:- Pavan Chavan
// Email:- pavan.21920161@viit.ac.in

import java.util.InputMismatchException;
import java.util.Scanner;

class isPalindromString
{
    public static void main(String[] args) {
        String S1;
        String s2;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter 1st String:");
            S1=sc.nextLine().trim();
            StringBuffer sb = new StringBuffer(S1);
            s2 = new String (sb.reverse());
            if(S1.equals(s2))
            {
                System.out.println("Given string is palimrom string...");
            }  
            else 
            {
                System.out.println("Given string is not palindrome string...");
            } 
        } catch (InputMismatchException Ime) {
            Ime.printStackTrace();
        }
    }
}
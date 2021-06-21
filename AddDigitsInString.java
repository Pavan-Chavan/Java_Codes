// Title:- to find the addition of numbers in string 
// Name of coder:- Pavan Chavan
// Email:- pavan.21920161@viit.ac.in

import java.util.Scanner;
import java.lang.System;

public class AddDigitsInString {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int sum=0;
        String s =null;
        try (sc) {                          // try with enhance resorse
            System.out.println("Enter a String:");
            if(s==null)
            s=sc.nextLine();
            for(int i=0;i<s.length();i++)
            {
                if(Character.isDigit(s.charAt(i)))
                sum=sum+Character.getNumericValue(s.charAt(i));
            }//end of for
        }//end of try 
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Addition of numbers in string is:"+sum);
    }
    
}


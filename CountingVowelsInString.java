// Title:- couting no of vowel in user enter string
// Name of coder:- Pavan Chavan
// Email:- pavan.21920161@viit.ac.in

import java.util.Scanner;
import java.lang.System;

public class CountingVowelsInString {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int count=0;
        String s =null;
        try (sc) {                          // try with enhance resorse
            System.out.println("Enter a String:");
            if(s==null)
            s=sc.nextLine();
            for(int i=0;i<s.length();i++)
            {
                switch(s.charAt(i))
                {
                    case 'a':
                    case 'A':   count++;
                    break;
                    case 'b':
                    case 'B':   count++;
                    break;
                    case 'c':
                    case 'C':   count++;
                    break;
                    case 'd':
                    case 'D':   count++;
                    break;
                    case 'e':
                    case 'E':   count++;
                }//end of switch
            }//end of for
        }//end of try 
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Numbers of vowels in strings are:"+count);
    }
    
}

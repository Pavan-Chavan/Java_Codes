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
                switch(s.charAt(i))
                {
                    case '1':   sum=sum+1;
                    break;
                    case '2':   sum=sum+2;
                    break;
                    case '3':  sum=sum+3;
                    break;
                    case '4':   sum=sum+4;
                    break;
                    case '5':   sum=sum+5;
                    break;
                    case '6':   sum=sum+6;
                    break;
                    case '7':   sum=sum+7;
                    break;
                    case '8':   sum=sum+8;
                    break;
                    case '9':   sum=sum+9;
                    break;

                }//end of switch
            }//end of for
        }//end of try 
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Addition of numbers in string is:"+sum);
    }
    
}


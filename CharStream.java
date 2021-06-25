

//Title :- Exaple of binary stream
//Coder Name:- Pavan Chavan
//email:- pavan.21920161@viit.ac.in

/*
(i)BufferedReader:
   =>BufferedReader class is from java.io package and which is used to read 
    Character Stream into JavaProgram.
    syntax: BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

(ii)FileReader:
  =>FileReader class is from java.io package and which is used to find the file
    and opens the file to read Character Stream.
    Syntax: FileReader fr = new FileReader("fPath&fName");

(iii)FileWriter:
  =>FileWriter class is from java.io package and which is used to create new file
    and opens the file to write Character Stream.
    syntax: FileWriter fr = new FileWriter("fPath&fName");
*/

import java.io.BufferedReader;
import java.io.*;

public class CharStream {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
            File f = new File("F:\\Pavan Chavan\\Core Java\\CODES\\Test.txt");
            //reading data from user through console printing it on file 
            FileWriter fw = new FileWriter(f);
            System.out.println("Enter the data (put @ at the end)");
            char ch;
            while ((ch=(char)br.read())!='@') {
                fw.write(ch);
            }//while
            fw.close();
            //reading data from file and printing it on console
            System.out.println("====Display from file====");
            FileReader fr = new FileReader(f);
            int ch1;
            while ((ch1=fr.read())!=-1) {
                System.out.print((char)ch1);                
            }//while

            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

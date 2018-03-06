/**
 * This Driver involves processing data 
 * from input files from input stream "ecoloi.txt"
 * <p>
 *  Date: March 30, 2017
 *</p>
 * @author Evan Pomponio
 * 
 */ 

import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class fileStreamDNA {     
   public static void main(String [ ] args) {
      Scanner inputStream=null;
      PrintWriter outputStream=null;
      try {
         inputStream= new Scanner ( new FileInputStream("ecoloi.txt"));//input
         outputStream = new PrintWriter( new FileOutputStream("DNA.txt"));
      }
      catch (FileNotFoundException e) {
         System.out.println("Problem opening files");
         System.exit(0);
      }
      String title;
      String nucleo;
      ArrayList<DNA> input=new ArrayList<DNA>();
      int count = 0; //variable used to add to ArrayList Input      
      while (inputStream.hasNextLine()) {  
         title=inputStream.nextLine();   
         nucleo=inputStream.nextLine();    
         input.add(new DNA());   
         input.get(count).setTitle(title);   
         input.get(count).setNucleo(nucleo);
         input.get(count).setFixedNucleo(nucleo);
         input.get(count).setCountNucleo();
         input.get(count).setMassPercents();   
         System.out.println(input.get(count));
         outputStream.println(input.get(count));    
         count++;   
      }
         
      System.out.println("Before Sort: \n" + input.get(0));
      System.out.println("Before Sort: \n" + input.get(input.size()-1));
      Collections.sort(input);
      System.out.println("After Sort: \n" + input.get(0));
      System.out.println("After Sort: \n" + input.get(input.size()-1));        
      inputStream.close( );
      outputStream.close( );
   }
}
 /*Output for test Invalid DNA String 
 ----jGRASP exec: java fileStreamDNA
  ----   at: Mar 30, 2017 9:56:04 AM
  ----jGRASP wedge: pid for process is 1072  pids for wedge are 1070 and 1071.
  ----jGRASP wedge: CLASSPATH is ":.:::/Applications/jGRASP.app/Contents/Resources/jgrasp/extensions/classes".
  ----jGRASP wedge: working directory is /Users/Evan/Desktop/All Java
  ----jGRASP wedge2: actual command sent [/Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home/bin/java fileStreamDNA].
 Invalid string
  ----jGRASP wedge: exit code for process is 0.
  ----jGRASP: operation complete.

*/




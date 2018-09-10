package autoShip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CountLines
{
   public static void main(String[] args)
   {
      Scanner inputStream = null;
      Scanner readIntoArray = null;
      PrintWriter outputStream = null;
      
   
   
      try
      {
         inputStream = new Scanner(new FileInputStream("stuff.txt"));
         readIntoArray = new Scanner(new FileInputStream("stuff.txt"));
         outputStream = new PrintWriter(new FileOutputStream("stuff.csv"));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Input error");
         System.exit(0);
      }
      
      String line = null;
      int count = 0;
      
      System.out.println("getting count");
      
      while(inputStream.hasNextLine())
      {
         line = inputStream.nextLine();
         count++;
      }
      
      System.out.println("the file has " + count + " many lines.");
      
      String[] lines = new String[count];
      
      System.out.println("making lines array");
      
      for (int index = 0; index < count; index++)
      {
         lines[index] = readIntoArray.nextLine();
         System.out.println("line " + index + " " + lines[index]);
      }
      
      
      
      inputStream.close();
      readIntoArray.close();
      outputStream.close();
   
   }

}

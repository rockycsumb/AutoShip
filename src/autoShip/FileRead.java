package autoShip;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileRead
{

   public static void main(String[] args)
   {
      System.out.println("reading from file");
      Scanner inputStream = null;
      PrintWriter outputStream = null;
      
      
      try
      {
         inputStream = new Scanner(new FileInputStream("stuff.txt"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
         System.exit(0);
      }
      
      String n1 = inputStream.nextLine();
      String n2 = inputStream.nextLine();
      String n3 = inputStream.nextLine();
      String n4 = inputStream.nextLine();
      
      try
      {
         outputStream = new PrintWriter(new FileOutputStream("stuff.csv", false));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("output not found");
         System.exit(0);
      }
      
      System.out.println("writing to file");
      outputStream.println(n1 + "," + n2);
      
      
      
      
      
      
      
      inputStream.close();
      outputStream.close();
    
   }

}

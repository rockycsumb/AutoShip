package autoShip;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class FileInputTest
{

   public FileInputTest()
   {
      // TODO Auto-generated constructor stub
   }
   
   public static void main(String[] args)
   {
      PrintWriter outPutStream = null;
      
      try
      {
         outPutStream = new PrintWriter(new FileOutputStream("stuff.txt", true));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Error");
         System.exit(0);
      }
      
      System.out.println("Writing to file");
      outPutStream.println("adding more stuff");
      outPutStream.println("andddddd adddddddddding more text");
      
      
      
      outPutStream.close();
      System.out.println("End program");
   }

}

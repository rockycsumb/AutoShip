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
         outPutStream = new PrintWriter(new FileOutputStream("stuff.txt", false));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Error");
         System.exit(0);
      }
      
      System.out.println("Writing to file");
      outPutStream.print("adding more stuff" + "," + "andddddd adddddddddding more text" );
     // outPutStream.print( + ",");
      
      
      
      outPutStream.close();
      System.out.println("End program");
   }

}

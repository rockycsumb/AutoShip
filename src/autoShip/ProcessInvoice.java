package autoShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

class ProcessInvoice implements ActionListener
{
   PrintWriter dataOutput = null;
   public static String[] lines;
   public static int count;
   ArrayList<String> listArray;

   InvoiceExtractor invoice;
   
   ProcessInvoice()
   {
      
      
   }
   
   public void actionPerformed(ActionEvent e)
   {
      lines = GuiAutoShip.inputTextArea.getText().split("\\n");
      
      count = lines.length;
      
      listArray = new ArrayList<String>(Arrays.asList((GuiAutoShip.inputTextArea.getText().split("\\n"))));
      
      //System.out.println("From Array list " + listArray.get(2) + " THe size is " + listArray.size());
      
      //System.out.println("the text contains " + count + " many lines");
      
      InvoiceSeparator separateInvoices = new InvoiceSeparator(listArray);
      
      listArray.removeAll(listArray);
      System.out.println("End of process" );
      
      
      
      /**
      for (int index = 0; index < count; index++)
      {
        //GuiAutoShip.outputTextArea.append("[ " + index +" ]" + " " + lines[index] +  "ending Invoice " + "\n");
        //System.out.println("[ " + index +" ]" + " " + lines[index] +  "\n");
        
      }
      **/
      
      try
      {
         dataOutput = new PrintWriter(new FileOutputStream("invoiceData.csv", false));
      }
      catch(FileNotFoundException c)
      {
         System.out.println("Error");
         System.exit(0);
      }
      /**
      for (int index = 0; index < count; index++)
      {
        dataOutput.print(lines[index]);    
      }
      **/
      // OPEN LOCATION OF CSV FILE
      /**  
      try
      {
         Desktop.getDesktop().open(new File("C:\\Users\\rocky.moreno\\Documents\\GitHub\\AutoShip"));
      } catch (IOException e1)
      {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
     **/
   }
}
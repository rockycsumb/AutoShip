package autoShip;

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
   
   ProcessInvoice()
   {
      
      
   }
   
   public void actionPerformed(ActionEvent e)
   {
      String[] lines = GuiAutoShip.inputTextArea.getText().split("\\n");
      //outputTextArea.setText(inputTextArea.getText());
      
      int count = lines.length;
      
      System.out.println("the text contains " + count + " many lines");
      
     
      for (int index = 0; index < count; index++)
      {
        GuiAutoShip.outputTextArea.append("Hello " + lines[index] +  "ending Invoice " + "\n");
        
      }
      
      try
      {
         dataOutput = new PrintWriter(new FileOutputStream("invoiceData.csv", false));
      }
      catch(FileNotFoundException c)
      {
         System.out.println("Error");
         System.exit(0);
      }
      
      for (int index = 0; index < count; index++)
      {
        dataOutput.print(lines[index]);    
      }
      
      
      try
      {
         Desktop.getDesktop().open(new File("C:\\Users\\rocky.moreno\\Documents\\GitHub\\AutoShip"));
      } catch (IOException e1)
      {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
     
   }
}
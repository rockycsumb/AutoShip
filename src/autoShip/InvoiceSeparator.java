package autoShip;
import java.util.ArrayList;

public class InvoiceSeparator
{
   boolean isValidDeliveryNumber = false;
   
   boolean commercialInvoiceFound = false;
   int invoiceStartIndex = 0;
   boolean invoiceStartFound = false;
   
   boolean ultimateDestinationFound = false;
   int invoiceEndIndex = 0; 
   boolean invoiceEndFound = false;
      
   public static int [][] indexes = new int[ProcessInvoice.count][2];
   int indexesRow = 0;
   int indexesCol = 0;
   
   boolean isEndOfArray = false;
   int index;
   public static int invoiceCount = 0;

   public InvoiceSeparator()
   {
      
      /***************************
      /  Separate Invoices       *
      /***************************/ 
      
      /**************************************/
      /* Invoice Extractor Algorithm LOOP   */
      /**************************************/
        
      for (index = 0; index < ProcessInvoice.count; index++)   
      {
            
            
          /*********************************/
          /* LOOK IF DELIVERY IS COMING    */
          /*********************************/
              
           if (ProcessInvoice.lines[index].equals("Commercial Invoice"))
           {
              commercialInvoiceFound = true;           
           }
          
           
           /******************************/
           /*      GET START INDEX       */
           /******************************/
               
           if (commercialInvoiceFound && 
               !invoiceStartFound
               )
           {           
              invoiceStartIndex = index;
              invoiceStartFound = true;          
           }
           
           /******************************/
           /*      GET END INDEX         */
           /******************************/
           if (  ProcessInvoice.lines[index].length() > 20 &&
                 ProcessInvoice.lines[index].substring(0, 20).equals("Ultimate Destination"))
           {
              ultimateDestinationFound = true;           
           }
           
           if(invoiceStartFound &&
                 ultimateDestinationFound)
           {
              invoiceEndIndex = index;
              //System.out.println("The start index " + invoiceStartIndex + " the ending " + invoiceEndIndex);
              
              //insert indexes into array
              indexes[indexesRow][indexesCol] = invoiceStartIndex;
              
              indexesCol++;
              
              indexes[indexesRow][indexesCol] = invoiceEndIndex;
              
              indexesRow++;
              indexesCol = 0;
              
              //Count how many invoices
              invoiceCount++;
              
              
              //reset flags
              commercialInvoiceFound = false;
              invoiceStartFound = false;
              ultimateDestinationFound = false;
           }
           
           if (ProcessInvoice.lines[index].length() <= 26 && ProcessInvoice.lines[index].length() > 12)
           {
              if (ProcessInvoice.lines[index].substring(0, 1).equals("8"))
              {
                 //System.out.println("from delivery check " + ProcessInvoice.lines[index].substring(0, 9));
              }
           }      
           
         } // END LOOP
         /****************************************/
         /*      END INVOICE EXTRACT LOOP        */
         /****************************************/
         
         // TESTING ARRAY
         /**
         int row, col;
         int startIndex = 0;
         int endIndex = 0;
         
         for(row = 0; row < invoiceCount; row++)
         {
            for(col = 0; col < 2; col++)
            {
               if (col == 0)
               {
                  startIndex = indexes[row][col];
                  //System.out.println("start index " + startIndex); 
               }
               else if (col == 1)
               {
                  endIndex = indexes[row][col];
                  //System.out.println("end index " + endIndex); 
               }
            }
            System.out.println("start index from array " + startIndex + " end index " + endIndex);
            
         }
         **/
         // For Testing to see Array
         /**
         for (int index = 0; index < ProcessInvoice.count; index++)
         {      
           System.out.println("[ " + index +" ]" + " " + ProcessInvoice.lines[index] +  "\n");       
         }
         **/
      }
         
  }



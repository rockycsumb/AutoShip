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

   int indexesRow = 0;
   
   public static ArrayList<Integer> startIndexArray = new ArrayList<Integer>();
   public static ArrayList<Integer> endIndexArray = new ArrayList<Integer>();
   
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
              //Testing
              //System.out.println("The start index " + invoiceStartIndex + " the ending " + invoiceEndIndex);

              insertIndexIntoArray(indexesRow, invoiceStartIndex, invoiceEndIndex);
              
              indexesRow++;
              
              //Count how many invoices
              invoiceCount++;
                           
              //reset flags
              commercialInvoiceFound = false;
              invoiceStartFound = false;
              ultimateDestinationFound = false;
           }
           
           //Testing
           /**
           if (ProcessInvoice.lines[index].length() <= 26 && ProcessInvoice.lines[index].length() > 12)
           {
              if (ProcessInvoice.lines[index].substring(0, 1).equals("8"))
              {
                 //System.out.println("from delivery check " + ProcessInvoice.lines[index].substring(0, 9));
              }
           }      
           **/
         } // END LOOP
         /****************************************/
         /*      END INVOICE EXTRACT LOOP        */
         /****************************************/
         
        // For Testing 
        //testArrayList();
         
      }
   
   public void insertIndexIntoArray(int index, int startIndex, int endIndex)
   {
      startIndexArray.add(index, startIndex);
      endIndexArray.add(index, endIndex);
   }
   
   public void testArrayList()
   {
   // TESTING ARRAY
      int row;
      
      for(row = 0; row < startIndexArray.size(); row++)
      {
       System.out.println("here is the start " + startIndexArray.get(row) + " here is the end " + endIndexArray.get(row));  
      }
      
   }
         
  }



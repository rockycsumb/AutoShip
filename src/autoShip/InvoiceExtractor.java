package autoShip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InvoiceExtractor
{   
   boolean isValidDeliveryNumber = false;
   
   boolean deliveryNumberFound = false;
   boolean poNumberFound = false;
   boolean addressFound = false;
   
   public static InvoiceSeparator Separate = new InvoiceSeparator();
   int deliveryNumber = 0;
   

   public InvoiceExtractor()
   {
      Scanner kbd = new Scanner(System.in);
      String userChoice = "n";
      
      //testArrayList();
      
      int sizeIndex;
      int invoiceIndex;
      
      // Iterate through Invoices
      for(sizeIndex = 0; sizeIndex < Separate.startIndexArray.size(); sizeIndex++)
      {
         
         for(invoiceIndex = Separate.startIndexArray.get(sizeIndex); invoiceIndex < Separate.endIndexArray.get(sizeIndex); invoiceIndex ++)
         {
            
            // Extract Delivery Number
            if (!deliveryNumberFound && !poNumberFound && !addressFound)
            {
               deliveryInfoCheck(ProcessInvoice.lines[invoiceIndex]);
            }
            
            
            // Extract PO number
            if(!poNumberFound && deliveryNumberFound && !addressFound)
            {
               setPONumber(ProcessInvoice.lines[invoiceIndex]);
            }
            
            // Extract Address
            if(!addressFound &&
                  poNumberFound &&
                  deliveryNumberFound)
            {
               analyzeAddress(ProcessInvoice.lines[invoiceIndex]);
            }
            
         }
         
         // Reset Flags
         deliveryNumberFound = false;
         poNumberFound = false;
         addressFound = false;

         
         
         //Next Invoice?
         //System.out.print("Next Invoice? ");
         //userChoice = kbd.next();       
      }
      
   }
      
   public InvoiceExtractor(ArrayList<Integer> startIndexArray, ArrayList<Integer> endIndexArray, ArrayList<String> lines)
   {
      Scanner kbd = new Scanner(System.in);
      String userChoice = "n";
      
      //testArrayList();
      
      int sizeIndex;
      int invoiceIndex;
      
      // Iterate through Invoices
      for(sizeIndex = 0; sizeIndex < startIndexArray.size(); sizeIndex++)
      {
         
         for(invoiceIndex = startIndexArray.get(sizeIndex); invoiceIndex < endIndexArray.get(sizeIndex); invoiceIndex ++)
         {
            
            // Extract Delivery Number
            if (!deliveryNumberFound && !poNumberFound && !addressFound)
            {
               
               deliveryInfoCheck(lines.get(invoiceIndex));
               
            }
            
            
            // Extract PO number
            if(!poNumberFound && deliveryNumberFound && !addressFound)
            {
               setPONumber(lines.get(invoiceIndex));
            }
            
            if(!addressFound &&
                  poNumberFound &&
                  deliveryNumberFound)
            {
               analyzeAddress(lines.get(invoiceIndex));
            }
            
         }
         
         // Reset Flags
         deliveryNumberFound = false;
         poNumberFound = false;
         addressFound = false;

         
         
         //Next Invoice?
         //System.out.print("Next Invoice? ");
         //userChoice = kbd.next();       
      }
      lines.removeAll(lines);
      startIndexArray.removeAll(startIndexArray);
      endIndexArray.removeAll(endIndexArray);
      
   }
   
   /***************************
   /  delivery Number Found   *
   /***************************/   
   boolean deliveryInfoCheck(String deliveryInfo)
   {
      //System.out.println("Something Here");
      if (deliveryInfo.length() <= 26 && deliveryInfo.length() > 12)
      {
         if (deliveryInfo.substring(0, 1).equals("8"))
         {
            //System.out.println("from delivery check " + deliveryInfo.substring(0, 9));
            deliveryNumber = Integer.valueOf(deliveryInfo.substring(0,9));
            System.out.println("Delivery " + deliveryNumber);
            deliveryNumberFound = true;
            return true;
         }      
      }
      return false;
   }
   
   
   /***************************
   /         PO NUMBER        *
   /***************************/
   
   boolean setPONumber(String poNumber)
   {
      int poNumberBegins, poNumberEnds = 0;
      
      if (poNumber.length() <= 26 && 
            poNumber.length() > 12 &&
            poNumber.substring(0,1).equals("8"))
      {
         poNumberBegins = poNumber.indexOf(" ");
         poNumberEnds = poNumber.indexOf(" ", poNumberBegins + 1);
         poNumber = poNumber.substring(poNumberBegins, poNumberEnds);
         poNumberFound = true;
         System.out.println("Po Number  " + poNumber);         
      }
      
      return false;
   }
   
   /*********************************
   /         Analyse Address        *
   /********************************/
   
   public boolean analyzeAddress(String addressInfo)
   {
      //Ship to is 0-14
      //ultimate consignee is 0-26
      
      if(addressInfo.length() < 28 && 
            addressInfo.length() > 19 &&
            addressInfo.substring(0,18).equals("Ultimate Consignee"))
      {
         System.out.println(addressInfo);
         addressFound = true;
      }
      else if(addressInfo.length() < 16 && 
            addressInfo.length() > 14 &&
            addressInfo.substring(0, 7).equals("Ship To"))
      {
         System.out.println(addressInfo);
         addressFound = true;
      }
      
      
      return false;
   }
   
   
   /***************************
   /       Test ArrayList     *
   /***************************/
   public void testArrayList() 
   {
      int row;
      System.out.println("From Invoice Extractor");
      for(row = 0; row < Separate.startIndexArray.size(); row++)
      {
       System.out.println("here is the start from invoice extract " + Separate.startIndexArray.get(row) + " here is the end " + Separate.endIndexArray.get(row));  
      }  
   }
}


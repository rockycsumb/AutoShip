package autoShip;
import java.util.Scanner;

public class InvoiceExtractor
{   
   boolean isValidDeliveryNumber = false;
   public static InvoiceSeparator Separate = new InvoiceSeparator();
   int deliveryNumber = 0;
   

   public InvoiceExtractor()
   {
      Scanner kbd = new Scanner(System.in);
      String userChoice = "n";
      
      //testArrayList();
      
      int sizeIndex;
      int invoiceIndex;

      for(sizeIndex = 0; sizeIndex < Separate.startIndexArray.size(); sizeIndex++)
      {
         
         for(invoiceIndex = Separate.startIndexArray.get(sizeIndex); invoiceIndex < Separate.endIndexArray.get(sizeIndex); invoiceIndex ++)
         {

           
            deliveryInfoCheck(ProcessInvoice.lines[invoiceIndex]);
            if(isValidDeliveryNumber)
            {
               setPONumber(ProcessInvoice.lines[invoiceIndex]);
            }
            
         }
         isValidDeliveryNumber = false;
         System.out.print("Next Invoice? ");
         userChoice = kbd.next();       
      }
      
   }
      
   
   /***************************
   /  CHECK IF IS A DELIVERY  *
   /***************************/   
   boolean deliveryInfoCheck(String deliveryInfo)
   {
      if (deliveryInfo.length() <= 26 && deliveryInfo.length() > 12)
      {
         if (deliveryInfo.substring(0, 1).equals("8"))
         {
            //System.out.println("from delivery check " + deliveryInfo.substring(0, 9));
            deliveryNumber = Integer.valueOf(deliveryInfo.substring(0,9));
            System.out.println("from delivery check " + deliveryNumber);
            isValidDeliveryNumber = true;
            return true;
         }      
      }
      return false;
   }
   
   
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
         System.out.println("Po Number  " + poNumber);
              
      }
      return false;
   }
   
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


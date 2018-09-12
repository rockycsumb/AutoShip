package autoShip;

public class InvoiceExtractor
{
   boolean deliveryInfoComing = false;
   boolean deliveryInfoFound = false;
   boolean isValidDeliveryNumber = false;
   
   int deliveryNumber = 0;
   int invoiceStartIndex = 0;
   int invoiceEndIndex = 0;
   
   boolean invoiceStartFound = false;
   boolean invoiceEndFound = false;
   
   int deliveryNumberHold = 0;
   int anotherDeliveryNumber = 0;

   public InvoiceExtractor()
   {
      /********************************
      / Invoice Extractor Algorithm   *
      /********************************/
      
      for (int index = 0; index < ProcessInvoice.count; index++)
      {
           
        if (ProcessInvoice.lines[index].equals("Commercial Invoice"))
        {
           deliveryInfoComing = true;
           
           //TESTING
           //System.out.println("line is this long " + ProcessInvoice.lines[10].length());
        }
        
        
        // CHECK IF IT IS REALLY A DELIVERY NUMBER // CHECKER
        
        if(deliveryInfoComing)
        {
           deliveryInfoCheck(ProcessInvoice.lines[index]);
           //ProcessInvoice.lines[index].length() == 26;
           //deliveryNumber = Integer.parseInt(ProcessInvoice.lines[index].substring(0, 9));
        }
        
        
        
        
        if (deliveryInfoComing == true && 
            isValidDeliveryNumber &&
            invoiceStartFound == false         
            )
        {
           //TESTING
           //System.out.println(ProcessInvoice.lines[index]);
           
           invoiceStartIndex = index;
           invoiceStartFound = true;
           
           // CHECK IF IT IS REALLY A DELIVERY NUMBER
           deliveryNumber = Integer.parseInt(ProcessInvoice.lines[index].substring(0, 9));
                 
           deliveryInfoComing = false;  
           //System.out.println("[ " + index +" ] " + " This is the delivery " + deliveryNumber);        
        
        }
               
        if (deliveryInfoComing == true && 
            isValidDeliveryNumber &&
            invoiceStartFound == true &&
            invoiceEndFound == false  
            )
        {
           // CHECK IF IT IS REALLY A DELIVERY NUMBER
           anotherDeliveryNumber = Integer.parseInt(ProcessInvoice.lines[index].substring(0, 9));
           
           if (deliveryNumber != anotherDeliveryNumber)
           {
              invoiceEndFound = true;
              invoiceEndIndex = index - 1;
              //System.out.println("Delivery: " + deliveryNumber + " Beg Index " + invoiceStartIndex + " End Index " + invoiceEndIndex);
              
              // CHECK IF IT IS REALLY A DELIVERY NUMBER
              deliveryNumber = anotherDeliveryNumber;
              
              //Reset Flags
              invoiceStartIndex = index;
              invoiceStartFound = true;
              deliveryInfoComing = false;
              invoiceEndIndex = 0;
              invoiceEndFound = false;
                                  
              //System.out.println("[ " + index +" ] " + " This is the delivery " + deliveryNumber);  
           }         
           
        }
           
        // One or Last invoice
        if (deliveryInfoComing == false && 
              invoiceStartFound == true && 
              index < ProcessInvoice.count &&
              isValidDeliveryNumber
            )
        {
          // CHECK IF IT IS REALLY A DELIVERY NUMBER
           
          deliveryNumber = Integer.parseInt(ProcessInvoice.lines[index].substring(0, 9));
          
          invoiceEndIndex = ProcessInvoice.count;
          System.out.println("Delivery: " + deliveryNumber + " Beg Index " + invoiceStartIndex + " End Index " + invoiceEndIndex);
          
          //TESTING
          //System.out.println("This is last delivery number recorded " + deliveryNumber);
        }
               
      }   
           
      // For Testing to see Array
      /**
      for (int index = 0; index < ProcessInvoice.count; index++)
      {      
        System.out.println("[ " + index +" ]" + " " + ProcessInvoice.lines[index] +  "\n");       
      }
      **/
   }
   
   boolean deliveryInfoCheck(String deliveryInfo)
   {
      if (deliveryInfo.length() == 26)
      {
         if (deliveryInfo.substring(0, 1).equals("8"))
         {
            System.out.println("from delivery check " + deliveryInfo.substring(0, 9));
         }
         
      }
      
      
      return true;
   }

}

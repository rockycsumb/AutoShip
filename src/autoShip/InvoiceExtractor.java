package autoShip;

public class InvoiceExtractor
{
   boolean deliveryInfoComing = false;
   boolean deliveryInfoFound = false;
   
   int deliveryNumber = 0;
   int invoiceStartIndex = 0;
   int invoiceEndIndex = 0;
   
   boolean invoiceStartFound = false;
   boolean invoiceEndFound = false;
   
   int deliveryNumberHold = 0;
   int anotherDeliveryNumber = 0;

   public InvoiceExtractor()
   {
      for (int index = 0; index < ProcessInvoice.count; index++)
      {
           
        if (ProcessInvoice.lines[index].equals("Commercial Invoice"))
        {
           deliveryInfoComing = true;
           //System.out.println("line is this long " + ProcessInvoice.lines[10].length());
        }
        
        
        if (deliveryInfoComing == true && 
            ProcessInvoice.lines[index].length() == 26 &&
            invoiceStartFound == false         
            )
        {
           //System.out.println(ProcessInvoice.lines[index]);
           //deliveryInfoFound = true;
           
           invoiceStartIndex = index;
           invoiceStartFound = true;
           
           // CHECK IF IT IS REALLY A DELIVERY NUMBER
           deliveryNumber = Integer.parseInt(ProcessInvoice.lines[index].substring(0, 9));
                 
           deliveryInfoComing = false;  
           System.out.println("[ " + index +" ] " + " This is the delivery " + deliveryNumber);        
        
        }
               
        if (deliveryInfoComing == true && 
            ProcessInvoice.lines[index].length() == 26 &&
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
              System.out.println("Delivery: " + deliveryNumber + " Beg Index " + invoiceStartIndex + " End Index " + invoiceEndIndex);
              
              // CHECK IF IT IS REALLY A DELIVERY NUMBER
              deliveryNumber = anotherDeliveryNumber;
              
              //Reset Flags
              invoiceStartIndex = index;
              invoiceStartFound = true;
              deliveryInfoComing = false;
              invoiceEndIndex = 0;
              invoiceEndFound = false;
                                  
              System.out.println("[ " + index +" ] " + " This is the delivery " + deliveryNumber);  
           }         
           
        }
           
        // One or Last invoice
        if (deliveryInfoComing == false && 
              invoiceStartFound == true && 
              index < ProcessInvoice.count &&
              ProcessInvoice.lines[index].length() == 26
            )
        {
          // CHECK IF IT IS REALLY A DELIVERY NUMBER
           
          deliveryNumber = Integer.parseInt(ProcessInvoice.lines[index].substring(0, 9));
          
          invoiceEndIndex = ProcessInvoice.count;
          System.out.println("Delivery: " + deliveryNumber + " Beg Index " + invoiceStartIndex + " End Index " + invoiceEndIndex);
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
   
   private boolean checkDelivery(String deliveryInfo)
   {
      
      return true;
   }

}

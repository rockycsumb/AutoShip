package autoShip;

public class InvoiceExtractor
{   
   boolean isValidDeliveryNumber = false;

   public InvoiceExtractor()
   {
      InvoiceSeparator separate = new InvoiceSeparator();
      
      /**
      int row, col;
      int startIndex = 0;
      int endIndex = 0;
      
      for(row = 0; row < separate.invoiceCount; row++)
      {
         for(col = 0; col < 2; col++)
         {
            if (col == 0)
            {
               startIndex = separate.indexes[row][col];
               //System.out.println("start index " + startIndex); 
            }
            else if (col == 1)
            {
               endIndex = separate.indexes[row][col];
               //System.out.println("end index " + endIndex); 
            }
         }
         System.out.println("start index from array " + startIndex + " end index " + endIndex);
         
      }
      **/
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
            isValidDeliveryNumber = true;
            return true;
         }      
      }
      return false;
   }
}


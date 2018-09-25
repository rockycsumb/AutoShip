package autoShip;

public class InvoiceExtractor
{   
   boolean isValidDeliveryNumber = false;

   public InvoiceExtractor()
   {
      InvoiceSeparator Separate = new InvoiceSeparator();
      testArrayList();
      
      
     
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
   
   
   public void testArrayList() 
   {
      InvoiceSeparator Separate = new InvoiceSeparator();
      int row;
      System.out.println("From Invoice Extractor");
      for(row = 0; row < Separate.startIndexArray.size(); row++)
      {
       System.out.println("here is the start " + Separate.startIndexArray.get(row) + " here is the end " + Separate.endIndexArray.get(row));  
      }  
   }
}


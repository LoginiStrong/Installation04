public class CheckOutLine
{
IntNode fHead = null;
IntNode fTail = null;
IntNode rHead = null;
IntNode rTail = null;
IntNode fast;
IntNode reg;
Customer c;
   public CheckOutLine()
   {
       
   }
   
   public void enqueue(String name, int items)
   {
      Customer c = new Customer(name, items);   
      if (items <= 15 && fHead == null)
      {
         fast = new IntNode(c);
         fHead = fast;
         fTail = fast; 
      }
      if (items <= 15 && fHead != null)
      {
         fast = new IntNode(c);
         fTail.setNext(c);
         fTail = fast; 
      }   
      if (items > 15 && rHead == null)
      {
         fast = new IntNode(c);
         fHead = fast;
         fTail = fast; 
      }
      if (items > 15 && rHead != null)
      {
         fast = new IntNode(c);
         fTail.setNext(c);
         fTail = fast; 
      } 
            
   }
   
   public String print()   
   {
      String builder = "";      
      IntNode  = head;      
      while(in != null)
      {         
         builder += in.getData()+" ";         
         in = in.getNext();      
      }
      return builder;   
   }
   
   public String toString()
   {
      return fast;
   }
   
}
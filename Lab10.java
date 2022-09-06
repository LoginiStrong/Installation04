
public class IntNode
{   
   private int data;
   private IntNode next;   
   public IntNode(int datax)   
   {      
      data = datax;   
   }    
   public int getData()   
   {      
      return data;   
   }   
   public void setData(int newdata)   
   {      
      data = newdata;   
   }   
   public IntNode getNext()   
   {
      return next;   
   }   
   public void setNext(IntNode newNext)   
   {      
      next = newNext;   
   }
 
 public class LinkedList
{
   private IntNode head;   
   public LinkedList()   
   {      
      head = null;   
   }   
   public void addToFront(int data)   
   {      
      IntNode in = new IntNode(data);      
      in.setNext(head);      
      head = in;   
   }   
   public void print()   
   {      
      IntNode in = head;      
      while(in != null)
      {         
         System.out.println(in.getData());         
         in = in.getNext();      
      }   
   }   
   public void addAtLocation(int location, int data)   
   {      
      if(location == 0) //first      
      {         
         addToFront(data);      
      }      
      else      
      {         
         IntNode in = new IntNode(data);         
         int currentLocation=1;         
         IntNode current = head;         
         while(currentLocation != location && current != null)         
         {            
            currentLocation++;            
            current = current.getNext();         
         }         
         if(current == null)            
         return;         
         in.setNext(current.getNext());         
         current.setNext(in);      
      }   
   }
   public boolean deleteAt(int i)   
   {      
      if(head == null)         
      return false;      
      if(i == 0)      
      {        
         head = head.getNext();          
         return true;      
      }      
      int counter = 1;      
      IntNode current = head.getNext();      
      IntNode prev = head;      
      while(counter != i && current != null)      
      {         
      prev = current;         
      current = current.getNext();         
      counter++;      
      }      
      if(current == null)         
      return false;      
      prev.setNext(current.getNext());      
      return true;   
      }  
   public static void main(String [] args)   
   {      
      LinkedList LL = new LinkedList();      
      LL.addToFront(5);      
      LL.addToFront(6);      
      LL.addToFront(7);      
      LL.addAtLocation(5,20);      
      LL.print();   
   }      
}
}
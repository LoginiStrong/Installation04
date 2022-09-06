public class LinkedList
{

//head object
   private IntNode head;

//constructor for the list   
   public LinkedList()   
   {      
      head = null;   
   } 
   
//method that adds a node to the front of the list   
   public void addToFront(int data)   
   {      
      IntNode in = new IntNode(data);      
      in.setNext(head);      
      head = in;
      System.out.println("Inserting a "+data);   
   } 
   
//method that prints the data from each node  
   public String print()   
   {
      String builder = "";      
      IntNode in = head;      
      while(in != null)
      {         
         builder += in.getData()+" ";         
         in = in.getNext();      
      }
      return builder;   
   } 
   
//method that adds a node to a certain location  
   public void addAtLocation(int location, int data)   
   {  
      System.out.println("Inserting "+data+" at place "+location+"!");    
      if(location <= 0)       
      {  
      
      //the reason why im not calling addtofront here is because the print statements get a little wack so this was easier       
         IntNode in = new IntNode(data);      
         in.setNext(head);
         head = in;            
      }      
      else      
      {         
         IntNode in = new IntNode(data);         
         int currentLocation=1;         
         IntNode current = head; 
         IntNode backup = current;     
         while(currentLocation != location && current != null)         
         {            
            currentLocation++; 
            backup = current;        
            current = current.getNext();         
         } 
                  
         if(current == null)
         {
            in.setNext(backup.getNext());         
            backup.setNext(in);
            return;   
         } 
         in.setNext(current.getNext());         
         current.setNext(in);
                 
              
      }   
   }
   
//method that deletes a node at a certain location
   public boolean deleteAt(int i)   
   {  
      System.out.println("Deleting at place "+i+"!");    
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
    
//method that deletes one node based on its data by returning after one operation
    public void deleteCert_Data (int i)
    {
    //relaying to the user what input we're deleting
      System.out.println("Deleting "+i);
      
      //returns to main if there is nothing in the list
      if (head == null)
      {
         return;
      }
      
      //throws the previous element into the garbage collector for the head equal to data entered in
      if (head.getData() == i)
      {
         head = head.getNext();
         return;
      }
      IntNode examine = head.getNext();
      IntNode prev = head;
      
      //throws the previous element into the garbage collector for further conditions
      while(examine != null)
      {  
         if(examine.getData() == i)
         {
            prev.setNext(examine.getNext());
            return; 
         }
         prev = examine;
         examine = examine.getNext();
        
      }
      
      //if we reach the end it doesn't delete anything and returns to the main
      if (examine == null)
      {
         return;
      }   
    }

//method that deletes all of a certain data by returning at the end of all operations
public void deleteAllCert_Data (int i)
    {
      //relaying to the user what inputs we're deleting
      System.out.println("Deleting all "+i+"s");
      
      //throws the previous element into the garbage collector for the head equal to data entered in
      if (head == null)
      {
         return;
      }
      
      //throws the previous element into the garbage collector for further conditions
      if (head.getData() == i)
      {
         head = head.getNext();
      }
      IntNode examine = head.getNext();
      IntNode prev = head;
      
      //throws the previous element into the garbage collector for further conditions
      while(examine != null)
      {  
         if(examine.getData() == i)
         {
            prev.setNext(examine.getNext());  
         }
         prev = examine;
         examine = examine.getNext();
        
      }
      
      //if we reach the end it doesn't delete anything and returns to the main
      if (examine == null)
      {
         return;
      }   
    }
    
//method that prints out the number of nodes in the list   
    public void lengthOfList()
    {
      IntNode current = head;
      int counter = 0;
      
      //adds one to counter every time a node is passed through
      while (current != null)
      {
         counter++;
         current = current.getNext();
      }
      
      //returns number with format
         System.out.println("Length of List: "+counter);
        
    }

//method that prints out the list in a specific format   
    public String toString ()
    {
      return "Printing the list: "+print();
    }
    
//the method that returns the last index of a node with certain data in it
   public void lastIndex(int data)
   {
   
   //variables that hold current index of found data and how many times we've passed through the list
      int checkCount = 0;
      int index = 0;
      
      //loop that goes through the entire list and set the index for data and current loop state accordingly 
      IntNode current = head;
      while (current != null)
      {
         if (current.getData() == data)
         {
            index = checkCount;
         }
         else 
         {
            index = -1;
         }
         current = current.getNext();
         checkCount++;
      }
      if (head.getData() == data)
      {
         index = 0;
      }
      System.out.println("Finding the last index of "+data+": "+index);
      return;
   
   }
    
//the main that runs the program   
    public static void main(String [] args)   
    {      
      LinkedList LL = new LinkedList(); 
      //printing the list
      LL.lengthOfList();
       
      //adding and printing    
      LL.addToFront(5);
      System.out.println(LL);      
      LL.addToFront(4);
      System.out.println(LL);      
      LL.addToFront(3);
      System.out.println(LL);
      LL.addToFront(2);
      System.out.println(LL);
      LL.addToFront(1);
      System.out.println(LL);
      LL.addToFront(5);
      System.out.println(LL);      
      LL.addToFront(4);
      System.out.println(LL);     
      LL.addToFront(3);
      System.out.println(LL);
      LL.addToFront(2);
      System.out.println(LL);
      LL.addToFront(1);
      System.out.println(LL);
      
      //deleting certain data
      LL.deleteCert_Data(1);
      System.out.println(LL);
      LL.deleteCert_Data(1);
      System.out.println(LL);
      
      //adding certain data to a location
      LL.addAtLocation(3,10);
      System.out.println(LL);
      LL.addAtLocation(-1,10);
      System.out.println(LL);
      
      //deleting at a certain position
      LL.deleteAt(3);
      System.out.println(LL);
      LL.deleteAt(0);
      System.out.println(LL);
      LL.deleteAt(7);
      System.out.println(LL); 
      
      //inserting data at a certain location
      LL.addAtLocation(0,10);
      System.out.println(LL);
      LL.addAtLocation(10,10);
      System.out.println(LL);
      
      //deleting at a certain position 
      LL.deleteAt(8);
      System.out.println(LL);   
          
      //print length again
      LL.lengthOfList();
      
      //print part 2 statements
      LL.addToFront(2);
      System.out.println(LL);
      LL.deleteAllCert_Data(2);
      System.out.println(LL);
      LL.lastIndex(4);
      LL.deleteAllCert_Data(4);
      System.out.println(LL);
      LL.addToFront(5);
      System.out.println(LL);
      LL.deleteAllCert_Data(5);
      System.out.println(LL);
      LL.lastIndex(3);
      LL.lastIndex(1);
      LL.addToFront(6);
      System.out.println(LL);
      LL.lastIndex(6);
      LL.lengthOfList();
      
       
   }    
       
}
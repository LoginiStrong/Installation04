public class Stack
{
   IntNode head;
      public Stack()
      {
         head = null;
      }
      
      public void push(int num)
      {
         IntNode in = new IntNode(num);
         in.setNext(head);
         head = in;
      }
      
      public void pop()
      {
         head = head.getNext();
      }
      
      public boolean isEmpty()
      {
         if(head == null)
         {
            return true;
         }
         return false;
      }
      
      public int peek()
      {
         return head.getData();
      }
      
      public String toString()
      {
         return "";
      }
      
      
}
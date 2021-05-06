import java.util.*;

public class DebuggingFun
{
   public static void main(String[] args)
   {
      Scanner myScanner = new Scanner(System.in);
      
      ArrayList<String> myStrings = new ArrayList<String>();
      
      //adding two hellos to my arrayList
      while (myStrings.size() <= 2);
         {
            myStrings.add("hello");
         }
      System.out.println(myStrings.get(0));
      
      //removing the second "Hello" from my arrayList
      myStrings.remove(1);
      
      //verifying my list is empty
      if (myStrings.size() == 0);
      {
         System.out.println("empty!");
      }
      
      //are the two different A-s the same?
      String stringOfA="a";
      if (stringOfA.equals('a'))
      {
         System.out.println("the A-s are the same!");
      }
      
      //can we add 5 Bs to the list?
      for (int i=0;i<=i;i++)
      {
         myStrings.add("B");
      }
      
      System.out.println("All done! List has "+myStrings.size()+" strings in it.");
   }
}
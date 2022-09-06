public class RecursionLab 
{
   public static void main(String[] args)   
   {
   //first 3 calls to check, step 1
      System.out.println("Step 1 start");      
      System.out.println(mystery(5));
      System.out.println(mystery(6));
      System.out.println(mystery(7));
      System.out.println("Step 1 end\n"); 
   
   //step 2 iterative calls 
      System.out.println("Start of iterative line");
      System.out.println(iterative(7));
      System.out.println(iterative(14));
      System.out.println(iterative(35));
      System.out.println(iterative(40));
      System.out.println(iterative(42));
      System.out.println(iterative(46));
      System.out.println("End of iterative line\n");
      
   //step 2 recursion calls  
      System.out.println("Start of recursion line");
      System.out.println(mystery(7));
      System.out.println(mystery(14));
      System.out.println(mystery(35));
      System.out.println(mystery(40));
      System.out.println(mystery(42));
      System.out.println(mystery(46));
      System.out.println("End of recursion line\n"); 
      
   //this is the instantiation and declaration of an array that the zerocounted method is called on and printed out
      int [] countedArray = {0, 0, 0, 7, 0, 3, 4};
      System.out.println(zeroCount(countedArray,0,6));
   }
   
   //recursion method
      public static int mystery (int num)
      {  
         if (num<=2)
         {    
            return 1;
         }
         else
         {    
            return mystery(num-1)+mystery(num-2);
         }
      }

   //iterative add method      
      public static int iterative (int num)
      {
      
      //variable that counts how many times we have passed through this method 
         int count = 0;
         
         //variables used to create our own fibonacci sequence
         int firstNum = 0;
         int secondNum = 1;
         int thirdNum = 0;
            while (count != num)
            {
               thirdNum = firstNum+secondNum;
               firstNum = secondNum;
               secondNum = thirdNum;
               count++;
            }
         return firstNum; 
      }
      
      /*recursion method that takes in an array, starting level of no counted zeros and the last index
      this method counts how many zeros are in the entered array by looping through the array
      with recursion and adding 1 to the numOfZeros everytime a zero is found. Finally that numOfZeros is returned to the main*/
      public static int zeroCount (int [] array, int numOfZeros, int endIndex )
      {
         
         
            if (array[endIndex] == 0)
            {
               numOfZeros++;
               if (endIndex == 0)
               {
                  return numOfZeros;
               }
               else
               {
                  return zeroCount(array, numOfZeros, endIndex-1);
               }
            }
            else 
            {
               return zeroCount(array, numOfZeros, endIndex-1);
            }
         
      }
}  

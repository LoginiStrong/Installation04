import java.util.*;
import java.io.*;
import java.text.*;

public class FileReadClient
{
   public static void main(String[] args)
   {
//variable for whole number
int N;

//try and catch that catch exception
try (Scanner scan = new Scanner(new File("midfile.txt")))
{
   N = scan.nextInt();
   
//variable of first number held to compare with the next numbers in the for loop   
   int firstNum = scan.nextInt();
   
//for loop that determines if the numbers aren't in ascending order
   for (int i = 0; i < N - 1; i++)
   {
      int nextNum = scan.nextInt(); 
      if (nextNum != firstNum+1)
      {
         System.out.println("Not in order");
         System.exit(0);
      }
      else
      firstNum = nextNum;
   }
   System.out.println("Numbers are in order");
   
   

}
catch (FileNotFoundException fnfe)
   {
      System.out.println("File does not exist!");
   } 
   
   
   }
}

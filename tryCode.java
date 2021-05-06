import java.util.*;
import java.io.*;
import java.text.*;

public class tryCode
{
public static void main(String [] args)
   {
try
{
   Scanner scan = new Scanner(new File("duck.txt"));
   int num1 = scan.nextInt();
   int num2 = scan.nextInt();
   String string1 = scan.next();
   System.out.println(num1+" "+num2+" "+string1);   
   
}
catch(FileNotFoundException fnfe)
{
   System.out.println("File does not exist!");
}

   }


}
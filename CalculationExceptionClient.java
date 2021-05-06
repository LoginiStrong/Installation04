/*This program allows the user to multiply or divide two integers. 
It uses try and catch statements to refrain from error.
By Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class CalculationExceptionClient
{
   public static void main(String [] args)
   {

//variables that the user will enter
String num1;
String num2;
boolean loop = false;
String operator;
//constructing a scanner and scanning the users input within a try
Scanner scan = new Scanner(System.in);
while (!loop)
{
   System.out.println("Enter two numbers and an operator");
   num1 = scan.next();
   num2 = scan.next();
   operator = scan.next();
   try 
   {
      int checkNum1 = Integer.parseInt(num1);
      int checkNum2 = Integer.parseInt(num2);
      if (operator.equals("/"))
         {  
            System.out.println("result: "+checkNum1/checkNum2);
            loop = true;
         }
      else if (operator.equals("*"))
         {
            System.out.println("result: "+checkNum1*checkNum2);
            loop = true;
         }
      else 
         {
            System.out.println("Operator entered was incorrect");
         }
   
   }

//catch statements
catch (NumberFormatException nfe)
{
   System.out.println("Input cannot be converted to ints.");
}
catch (ArithmeticException ae)
{
   System.out.println("Cannot divide by 0.");
}


}




   }
}
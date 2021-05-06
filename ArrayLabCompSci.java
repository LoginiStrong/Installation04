import java.util.*;
import java.io.*;
import java.text.*;

public class ArrayLabCompSci
{
public static void main(String[] args) throws IOException
   {
//Part 1
//Create an array of strings and get the user to input the strings
ArrayList<String> stringList = new ArrayList<String>();
System.out.println("Enter a list of strings followed by EXIT.");
Scanner scan = new Scanner(System.in);
String userString = scan.next();
   while (! userString.equals("EXIT"))
      { 
         stringList.add(userString);
         userString = scan.next();
      }
//Ask the user to remove the index and then remove with .remove
System.out.println("What index would you like to remove?");
int indexOfRemoval = scan.nextInt();
stringList.remove(indexOfRemoval);

//Print new list out with a for loop
   for (int i = 0; i < stringList.size(); i++)
      {
         System.out.println(stringList.get(i));
      }
//Part 2
//Create do while loop with menu and a switch statement
int choice;
   do
      {
         System.out.println("Menu:");
         System.out.println("1: Add to list ");
         System.out.println("2: Remove from list");
         System.out.println("3: clear list");
         System.out.println("4: remove all of a particular name");
         System.out.println("5: print list out");
         System.out.println("6: exit");
            while (! scan.hasNextInt())
               {
                  String throwaway = scan.next();
                  System.out.println("Please enter a number that's between 1 and 6.");
               }
         choice = scan.nextInt();
            switch (choice)
               {
//This case statement allows the user to add a string to the list
                  case 1:
                  System.out.println("What string would you like to add?");
                     while (scan.hasNextInt()||scan.hasNextDouble())
                        {
                           String throwaway = scan.next();
                           System.out.println("Please enter a string.");
                        } 
                  String addedString = scan.next();
                  stringList.add(addedString);
                  break;
//This case statement allows the user to remove a string in the list at a given index
                  case 2: 
                  System.out.println("What string would you like to remove (by index)?");
                     while (! scan.hasNextInt())
                        {
                           String throwaway = scan.next();
                           System.out.println("Please enter an integer.");
                        } 
                  int index = scan.nextInt();
                     while (index >= stringList.size() || index < 0)
                        {
                           System.out.println("Please enter an index between 0 and "+ (stringList.size()-1)+".");
                               while (! scan.hasNextInt())
                                 {
                                    String throwaway = scan.next();
                                    System.out.println("Please enter an integer.");
                                 }
                           index = scan.nextInt();
                        }
                  stringList.remove(index);
                  break;
//This case statement allows the user to remove every string in the list
                  case 3:
                  stringList.clear();
                  break;
//This case statement allows the user to remove strings of a specific name all at one time
                  case 4:
                  System.out.println("What string do you want removed?");
                     while (scan.hasNextInt()||scan.hasNextDouble())
                        {
                           String throwaway = scan.next();
                           System.out.println("Please enter a string.");
                        }
                  String stringForRemoval = scan.next();
                     for (int i = stringList.size()-1; i > -1; i--)
                        {
                           if (stringForRemoval.equals(stringList.get(i)))
                              {
                                 stringList.remove(i);
                              }
                        }
                  break;
//This case statement allows the user to print out every string currently in the list with their given indexes
                  case 5:
                  System.out.println("The list:");
                  for (int i = 0; i < stringList.size(); i++)
                     {
                        System.out.println(i+": "+stringList.get(i));
                     }
                  break;
//This code ends the program
                  case 6:
                  System.exit(0);
                  break;
                  default:
                  System.out.println("Please enter a number that's between 1 and 6.");
                  break;
               }
       } while (0==0);

           




   }
}
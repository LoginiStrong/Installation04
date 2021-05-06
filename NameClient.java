import java.util.*;
import java.io.*;
import java.text.*;

public class NameClient
{
   public static void main(String [] args)
      { 
      
//variable that keeps track of users choice in case statements and name of removal
int choice;
String nameRemove;

//scanner for user
Scanner scan = new Scanner(System.in);


//arraylist that will keep track of the names
ArrayList<String> nameList = new ArrayList<String>();

//adding first few names to the list 
nameList.add("Josue");
nameList.add("Leslie");
nameList.add("Brenden");
nameList.add("Leslie");
nameList.add("Steven");

//menu printed to the user inside a do while loop
   do
   {
      System.out.println("What do you wish to do?");
      System.out.println("1.Remove one copy of a name");
      System.out.println("2.Print out the number of letters in a name");
      System.out.println("3.quit");

//switch statements for choices
choice = scan.nextInt();
   switch (choice)
   {

//first case removes a name in the array by an index the user enters
      case 1:
      System.out.println("What name would you like to remove?");
      nameRemove = scan.next();
         for (int i = 0; i < nameList.size(); i++)
      {
         if (nameRemove.equals(nameList.get(i)))
         {
            nameList.remove(i);
            break;
         }
      }
      break;
      
//case to prints array with number of letters in front of each name 
      case 2:   
      for (int i = 0; i < nameList.size(); i++)
      {
         System.out.println(((nameList.get(i)).length())+" "+nameList.get(i));
      }
      break;

//case 3 terminates program
      case 3:
      System.exit(0);
      break;
   }
   
   
   } while (0 == 0);


      }
}
/*This client uses 2 classes that inherit from an abstract bird class.
both classes are then used in creating birds of type penguin and type hummingbird.
Certain methods are then called, and slightly differ in execution depending on
what object type they are. The user then decides what type of bird to add, and what they want to do with them.
by Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class ZooClient
{
   public static void main(String [] args)
   {
   
//scanner and variables
      ArrayList<Bird> birdList = new ArrayList<Bird>();   
      int choice;
      String birdChoice;     
      Scanner scan = new Scanner(System.in);

//do while loop that will hold the switch statement
         do
         {
         
//menu printout
         System.out.println("Which option do you wish to select?");
         System.out.println("0 - add new bird");
         System.out.println("1 - remove based on a call sign");
         System.out.println("2 - print all birds");
         System.out.println("3 - fly");
         System.out.println("4 - chirp");
         System.out.println("5 - eat");
         System.out.println("6 - swim");
         System.out.println("7 - tap dance penguins");
         System.out.println("8 - quit");
         choice = scan.nextInt();
         
//beginning of case statements
            switch (choice)
            {
            
//adds birds
               case 0: 
               System.out.println("Which would you like to add? (P = penguin and H = hummingbird)");
               birdChoice = scan.next();
                  if (birdChoice.equals("P"))
                  {  
                     System.out.println("Enter in a callsign and the number of meals previously eaten.");
                     String pSign = scan.next();
                     int pMeals = scan.nextInt();
                     Penguin b = new Penguin(pSign, true, pMeals);
                     birdList.add(b);
                  }
                  else if (birdChoice.equals("H"))
                  {
                     System.out.println("Enter in a name, callsign, and the number of meals previously eaten.");
                     String hName = scan.next();
                     String hSign = scan.next();
                     int hMeals = scan.nextInt();
                     HummingBird hB = new HummingBird(hName, hSign, false, hMeals);
                     birdList.add(hB); 
                  }
               break;

//removes bird based on callsign
               case 1:
               System.out.println("Which callsign would you like to remove?:");
               String removeSign = scan.next();
               for (int i = 0; i < birdList.size(); i++)
                     {
                        if (((birdList.get(i)).getSign()).equals(removeSign))
                        {
                           birdList.remove(i);
                        }
                         
                     }

               break;
//prints out birds
               case 2:
               for (int i = 0; i < birdList.size(); i++)
                      {
                         System.out.println(birdList.get(i));
                         System.out.println();
                      }
               break;
               
//prints out all animals flying
               case 3:
               for (int i = 0; i < birdList.size(); i++)
                      {
                         (birdList.get(i)).fly();
                      }
               break;         

//prints all chirps
               case 4:
               for (int i = 0; i < birdList.size(); i++)
                      {
                         (birdList.get(i)).chirp();
                      }
               break; 

//prints eating sounds and adds specified amount of meals
               case 5:
               for (int i = 0; i < birdList.size(); i++)
                      {
                         (birdList.get(i)).eat();
                      }
               break; 

//prints the birds swimming
              case 6:
              for (int i = 0; i < birdList.size(); i++)
                      {
                         (birdList.get(i)).swim();
                      }
              break; 

//makes all penguins tap dance
              case 7:
              for (int i = 0; i < birdList.size(); i++)
                      {
                         (birdList.get(i)).dance();
                      }
              break;   
              
//ends program
            case 8:
            System.exit(0);
            break;         

//end of loop                 
            }
         } while (0 == 0);     
      
      
      
   }
}

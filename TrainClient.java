/*This client pulls code from the Train and TrainSystem classes.
The program asks the user what direction they would like to move each 
train and then performs the operation, printing the string in the desired format.
The program terminates when both trains colide.
By Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class TrainClient
{
   public static void main(String [] args)
      {
//Variable that helps track whether train x or y is changing position
int trainTurn = 1;

//construction of objects
Scanner scan = new Scanner(System.in);
TrainSystem Track = new TrainSystem();

//loops and statements that take the users input for direction until either of the trains crash
System.out.println("===============");
System.out.println(Track);
System.out.println("===============");
   while (Track.crash())
      {
         if (trainTurn != 1 && trainTurn != 2)
            {
               trainTurn = 1;
            }
         if (trainTurn == 1)
            {
               System.out.println();
               System.out.println("Move the X train left (enter L) or right (enter R):");    
            }
         else if (trainTurn == 2)
            {
               System.out.println();
               System.out.println("Move the Y train left (enter L) or right (enter R):");
            }
               String direction = scan.next();
//makes sure the user's input is correct
               while (! direction.equals("R") && ! direction.equals("L"))
               {
                  System.out.println("Please enter L (for left) or R (for right)");
                  while (scan.hasNextInt()||scan.hasNextDouble())
                  {
                  String throwaway = scan.next();
                  System.out.println("Please enter a string");
                  }
                  direction = scan.next();
               }
         Track.moveTrain(trainTurn, direction);
         if (Track.crash())
         {
            System.out.println("===============");
            System.out.println(Track);
            System.out.println("===============");
         }
         else if (!Track.crash())
         {
            System.out.println("CRASH!!!");
            System.out.println("Moves before crash: "+Train.getMoves());
         }
         trainTurn++;
     
      }
   }
}
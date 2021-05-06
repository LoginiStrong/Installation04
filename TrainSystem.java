/*This class constructs the train system that links with the train class.
This class has a method that moves the trains positions, and a method
that prints out the train system itself. It also detects if the trains colide.
By Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class TrainSystem
{
//variable used to track the beginning of the toString method
private int start;

//Train objects    
Train xTrain;
Train yTrain;

public TrainSystem()
{
   xTrain = new Train(3);
   yTrain = new Train(8);
}
//Train position manipulation mehthod
   public int moveTrain (int trainTurn, String direction)
   {
         
      if (direction.equals("L"))
         {
            if (trainTurn == 1)
            {
            return xTrain.subPos();
            }
            else if (trainTurn == 2)
            {
            return yTrain.subPos();
            } 
         }
      else if (direction.equals("R"))
         {
            if (trainTurn == 1)
            {
            return xTrain.addPos();
            }
            else if (trainTurn == 2)
            {
            return yTrain.addPos();
            }
         }
         return xTrain.getPos();
   }

//toString method that prints out the main row of the train track
   public String toString()
   {
      String toReturn ="";
      int start = 0;
      if (xTrain.getPos() < yTrain.getPos())
      {
         while (start < xTrain.getPos())
         {
            toReturn += ("-");
            start++;
         }
         if (start == xTrain.getPos());
         {
            toReturn += ("X");
            start++;
         }
         while (start >= xTrain.getPos() && start < yTrain.getPos())
         {
            toReturn += ("-");
            start++;
         }
         if (start == yTrain.getPos())
         {
            toReturn += ("Y");
            start++;
         }
         while (start >= yTrain.getPos() && start <= 14)
         {
            toReturn += ("-");
            start++;
         }
     }
     else if (xTrain.getPos() > yTrain.getPos())
     {
          while (start < yTrain.getPos())
         {
            toReturn += ("-");
            start++;
         }
         if (start == yTrain.getPos());
         {
            toReturn += ("Y");
            start++;
         }
         while (start >= yTrain.getPos() && start < xTrain.getPos())
         {
            toReturn += ("-");
            start++;
         }
         if (start == xTrain.getPos())
         {
            toReturn += ("X");
            start++;
         }
         while (start >= xTrain.getPos() && start <= 14)
         {
            toReturn += ("-");
            start++;
         }
     }
     return toReturn;
}
//End of toString method ^^

//crash method
public boolean crash()
{
   if (yTrain.getPos() == (xTrain.getPos()))
      {
         return false;
      }
   else 
      return true;
}
 
  
}
         
      
  

/*This class holds a train constructor that creates a train at the entered position.
There are several methods that perform arithmetic on the position and there is also a static
method with a variable that counts how many moves to the position have occured
By Logan Strong */

import java.util.*;
import java.io.*;
import java.text.*;

public class Train
{
//varibales used across the companion classes
private int position;
private static int moves = 0;

//object constructor that creates the train
   public Train(int startPosition)
   {
      position = startPosition;
   }

//This method subtracts one from the position of the current train
   public int subPos()
      {
         moves++;
         position--;
         position = checkPos(position);
         return this.position;
      }

//This method adds one to the position of the current train      
   public int addPos()
      {
         moves++;
         position++;
         position = checkPos(position);
         return this.position;
      }
      
//This method returns the postion   
   public int getPos()
   {
      return checkPos(position);
   }

//This method checks if the position is correctly stated (in bounds)   
   public int checkPos (int position)
   {
      this.position = position;
      if (position < 0)
      {
         this.position = 14;
      }
      else if (position > 14)
      {
         this.position = 0;
      }
      return this.position;
  }
  
//This method returns how many moves there were before a crash
   public static int getMoves()
   {
      return moves;
   }
   




}
/*Class that creates constructors and methods for the TicTacToe client
Bye Logan Strong*/
import java.util.*;
import java.io.*;
import java.text.*;

public class TicTacToe
{
private int [] [] board;
private int turn = 1;
private int moves = 0;

//constructable 2Darray object
public TicTacToe()
   {
      board = new int [3] [3];    
   }
   
//method that counts moves and returns boolean   
public boolean hasFourMovesHaveBeenplayed()
   {
      if (moves == 4)
      {
         return true;
      }
      else 
      {
         moves++;
         return false;
      }
   }            
//method that returns who's turn it is
public int getCurrentPlayer()
   {  
      return turn;
   }

//method that gets a position on the board
public boolean play(int x, int y)
   {
      if (x > 2 || x < 0)
         {
            moves--;
            return false;
         }
      else if (y > 2 || y < 0)
         {
            moves--;
            return false;
         }
      else if (board[x][y] != 0)
         {
            moves--;
            return false;
         }
      else 
            board[x][y] = turn;
            return true;         
   }

//method that returns string board

public String getBoard()
   {
   int count = 0;
   String toReturn ="";
      for (int i = 0; i < 3; i++)
         {
            for (int j = 0; j < 3; j++)
               {
                   toReturn += (board[i][j]+" "); 
               }
               if (count != 2)
                  {
                     toReturn+=("\n");
                     count++;
                  }
         }
//changes player
      if (turn == 2)
      {
         turn = 1;
      }
      else if (turn == 1)
      {
         turn = 2;
      }
      return toReturn;
      
   }
   
   
   
} 
import java.util.*;
import java.io.*;
import java.text.*;

public class TicTacToeLabPartII
{
   public static void main(String [] args)
      { 
             
         Scanner scan = new Scanner(System.in);
         TicTacToe tic = new TicTacToe();
      
         while(!tic.hasFourMovesHaveBeenplayed())
         {
         
            System.out.println("Player "+tic.getCurrentPlayer()+ " please make your move:");
         
            int x = scan.nextInt();
            int y = scan.nextInt();
      
         
            if(tic.play(x,y))
            {
            //if the move was successful
            System.out.println("Current board is:");
            System.out.println(tic.getBoard());
            }
            else
            {
            //if the move was invalid
            
            System.out.println("Player "+tic.getCurrentPlayer()+ " please make a valid move.");
            }
      
      }
      System.out.println("Four moves have been played! Game over!");
   }
}
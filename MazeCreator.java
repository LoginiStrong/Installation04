import java.util.*;
import java.io.*;
import java.text.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;


public class MazeCreator extends Canvas
{
GraphicsContext gc = getGraphicsContext2D();
int [][] mazeArray = new int [21][21];
int xPos = 0;
int yPos = 0;
int count = 0;
int blueX = 0;
int blueY = 0;
FlowPane root = new FlowPane();
int moves = 0;
   
//constructor for the canvas (what the maze will be drawn on)
      public MazeCreator(FlowPane root)
      {
         this.root = root;
         setWidth(525);
         setHeight(525);
         draw(gc); 
         root.setOnKeyPressed(new KeyListenerDown());
      }

//method that draws the maze
      public void draw(GraphicsContext gc)
      {
         
      
//try and catch for file exception error
         try (Scanner scan = new Scanner(new File("mazeData.txt")))
         {

//nested for loop that reads in the contents of the array and draws them
            for (int i = 0; i < 21; i++)
            {
               for (int j = 0; j < 21; j++)
               {
                  mazeArray[i][j] = scan.nextInt();
                     if (mazeArray[i][j] == 1)
                     {
                        gc.setFill(Color.BLACK);
                        gc.fillRect(xPos, yPos, 25, 25);
                     }
                     else if (mazeArray[i][j] == 0)
                     {
                        if (count == 1)
                        {
                           gc.setFill(Color.WHITE);
                           gc.fillRect(xPos, yPos, 25, 25);
                        }
                        else if (count == 0)
                        {
                           gc.setFill(Color.CYAN);
                           gc.fillRect(xPos, yPos, 25, 25);
                           blueX = xPos;
                           blueY = yPos;
                           mazeArray[i][j] = 3;
                           count++;
                        }
                     }
                 xPos += 25;
               }
               xPos = 0;
               yPos += 25;
            }
         }
//catch statement with the try 
         catch (FileNotFoundException fnfe)
         {
            System.out.println("File does not exist");
         }
      }
      
//method for moving the blue square when an arrow key is pressed
   public class KeyListenerDown implements EventHandler<KeyEvent>
      {
         public void handle (KeyEvent event)
         {

//moves the blue square down with the down arrow key
            if (event.getCode() == KeyCode.DOWN)
            {
               gc.clearRect(blueX, blueY, 25, 25);
               for (int i = 0; i < 21; i++)
               {
                  for (int j = 0; j < 21; j++)
                  {
                     try
                     {
                        if (mazeArray[i][j] == 3 && mazeArray[i+1][j] == 0)
                        {
                           if (moves == 0)
                           {
                              mazeArray[i][j] = 0;  
                              mazeArray[i+1][j] = 3;       
                              blueY += 25;
                              moves++;
                           }                                   
                        }
                     }
                     catch (ArrayIndexOutOfBoundsException aioobe)
                     {
                        blueY += 25;
                        gc.setFill(Color.CYAN);
                        gc.fillRect(blueX, blueY, 25, 25);
                        System.out.println("You Win!!!");
                        System.exit(0);
                     }     
                  }         
               }
               moves = 0;
               gc.setFill(Color.CYAN);
               gc.fillRect(blueX, blueY, 25, 25);     
            }

//moves the blue square up with the up arrow key            
            if (event.getCode() == KeyCode.UP)
            {
               gc.clearRect(blueX, blueY, 25, 25);
               for (int i = 0; i < 21; i++)
               {
                  for (int j = 0; j < 21; j++)
                  {
                     try
                     {
                        if (mazeArray[i][j] == 3 && mazeArray[i-1][j] == 0)
                        {
                           if (moves == 0)
                           {
                              mazeArray[i][j] = 0;  
                              mazeArray[i-1][j] = 3;       
                              blueY -= 25;
                              moves++;
                           }                                   
                        }
                     }
                     catch (ArrayIndexOutOfBoundsException aioobe)
                     {
                     }        
                  }         
               }
               moves = 0;
               gc.setFill(Color.CYAN);
               gc.fillRect(blueX, blueY, 25, 25);     
            }

//moves the blue square left with the left arrow key      
            if (event.getCode() == KeyCode.LEFT)
            {
               gc.clearRect(blueX, blueY, 25, 25);
               for (int i = 0; i < 21; i++)
               {
                  for (int j = 0; j < 21; j++)
                  {
                     if (mazeArray[i][j] == 3 && mazeArray[i][j-1] == 0)
                     {
                        if (moves == 0)
                        {
                           mazeArray[i][j] = 0;  
                           mazeArray[i][j-1] = 3;       
                           blueX -= 25;
                           moves++;
                        }                                   
                     }     
                  }         
               }
               moves = 0;
               gc.setFill(Color.CYAN);
               gc.fillRect(blueX, blueY, 25, 25);     
            }

//moves the blue square right with the right arrow key            
            if (event.getCode() == KeyCode.RIGHT)
            {
               gc.clearRect(blueX, blueY, 25, 25);
               for (int i = 0; i < 21; i++)
               {
                  for (int j = 0; j < 21; j++)
                  {
                     if (mazeArray[i][j] == 3 && mazeArray[i][j+1] == 0)
                     {
                        if (moves == 0)
                        {
                           mazeArray[i][j] = 0;  
                           mazeArray[i][j+1] = 3;       
                           blueX += 25;
                           moves++;
                        }                                   
                     }     
                  }         
               }
               moves = 0;
               gc.setFill(Color.CYAN);
               gc.fillRect(blueX, blueY, 25, 25);     
            }
         
         }
      }
   
}
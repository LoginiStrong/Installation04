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

//These are the graphical objects used to construct thewindow and its contents
GraphicsContext gc = getGraphicsContext2D();
FlowPane root = new FlowPane();

//array that will hold the contents of the mazeData file
int [][] mazeArray = new int [21][21];

//variables that hold the beginning drawing position of the black and white squares
int xPos = 0;
int yPos = 0;

//variables that hold the blue square start drawing position
int blueX = 0;
int blueY = 0;

//counts the first 0 in the mazeData file and assigns a blue square to be drawn instead of a white square
int count = 0;

//varibale that makes sure the blue square only moves through one white square at a time
int moves = 0;
   
//constructor for the canvas (what the maze will be drawn on) that passes in a FlowPane named root to draw on
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
                        for (int k = 0; k < 21; k++)
                        {
                           if (mazeArray[20][k] == 3)
                           {
                              System.out.println("You Win!!!");
                           }
                        }
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
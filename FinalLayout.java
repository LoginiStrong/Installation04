import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;
import javafx.scene.layout.Region;


public class FinalLayout extends Application
{
   GridPane theGrid = new GridPane();
   FlowPane root = new FlowPane();
   
//button array to keep track of buttons pressed
Button[][] buttonArray = new Button[8][8];


   Label victoryLabel = new Label("Game is playing!                ");

   public void start(Stage stage)
   {

//start of my code with an array and a try and catch for reading the file into an array
int [][] binaryArray = new int [8][8];
   try (Scanner scan = new Scanner(new File("data.txt")))
   {
      for (int i = 0; i < 8; i++)
      {
         for(int j = 0; j < 8; j++)
         {
            binaryArray[i][j] = scan.nextInt();
         }
      }  
   }
   catch (FileNotFoundException fnfe)
   {
      System.out.println("File wasn't found");
   }
      
      for(int i=0;i<8;i++)
      {
         for(int j=0;j<8;j++)
         {
          
//setting the button at 2,2 green
               if (i == 2 && j == 2)
               {
                  Button greenB = new Button("   ");
                  
//adding the buttons to an array and setting a listener on it                   
                  greenB.setOnAction(new ButtonListener());
                  buttonArray[i][j] = greenB;
                  greenB.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                  theGrid.add(greenB,i,j);
               }
               else
               {
                  Button b = new Button("   ");

//adding the buttons to an array and setting a listener on it 
                  b.setOnAction(new ButtonListener());
                  buttonArray[i][j] = b;
                  b.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY))); 
                     if (binaryArray[j][i] == 0)
                     {
                        b.setVisible(false);
                     }   
                  theGrid.add(b,i,j);           
               }
//my added if statement that sets the button invisible if a zero was read in for its correlating position
               
         }
      }
  
  
      root.getChildren().add(theGrid);
      root.getChildren().add(victoryLabel);
   
   
      //if there are issues with the size due to a different OS, you may resize the scene, but no bigger than 500 by 500
      Scene scene = new Scene(root, 300, 300);
      stage.setScene(scene);
      stage.setTitle("Final Layout");
      stage.show();
   }

   public static void main(String[] args)
   {
      launch(args);
   }

//button listener that checks to see if the grren button should be moved  
   public class ButtonListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         Button input = (Button)(e.getSource());
            
                  if (input == buttonArray[1][1] || input == buttonArray[1][3] || input == buttonArray[3][1] || input == buttonArray[3][3])
                  {
                     input.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                     buttonArray[2][2].setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));    
                  }            
         
      }
   }
   
   
}
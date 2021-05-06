import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MiniGame extends Application
{
//variable that keeps track of invisible buttons
int invisibleButtonCount;

//2D array that holds the Buttons
Button[][] buttonArray = new Button[4][4];

//label at the start of the game that is later changed based on the count variable
Label beginGame = new Label("Welcome to the Game!");

//start of the stage
   public void start (Stage stage)   
      {
      
//borderpane
         BorderPane bp = new BorderPane();
         bp.setPrefSize(500,500);
 
//flowpane that contains the buttons        
         FlowPane fp = new FlowPane();
         for (int i = 0; i < 4; i++)
         {
            for (int j = 0; j< 4; j++)
            {
               Button b = new Button();
               b.setPrefSize(100,100);
               buttonArray [i][j] = b;
               b.setOnAction(new ButtonListener());
               fp.getChildren().add(b);
            }
         }
//hbox and its labeled contents           
         HBox titleH = new HBox();
         titleH.setPrefSize(800, 20);
         titleH.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
         titleH.getChildren().add(beginGame);
         titleH.getChildren();       

//left boundary with a blank vbox
         VBox lBound = new VBox();
         lBound.setPrefSize(50,50);
         lBound.getChildren();
         
//right boundary
         VBox rBound = new VBox();
         rBound.setPrefSize(40,50);
         rBound.getChildren();
         
//bottombound
         HBox bBound = new HBox();
         bBound.setPrefSize(800, 50);
         bBound.getChildren();              
         
//setting the panes and boxes around the border                 
         bp.setTop(titleH);
         bp.setCenter(fp);
         bp.setBottom(bBound);
         bp.setLeft(lBound);
         bp.setRight(rBound);
         
//code that creates the stage         
         Scene scene = new Scene(bp, 500, 500);      
         stage.setScene(scene);      
         stage.setTitle("Lab #7 Part III");      
         stage.show();
      }

public static void main(String[] args)   
   {      
      launch(args);
   }

//ButtonListener class that makes a button and surrounding button switch visibility   
   public class ButtonListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {  
      
//double for loop
      Button input = (Button)(e.getSource());
         for (int i = 0; i < 4; i++)
         {
            for (int j = 0; j < 4; j++)
            {
               if (input == buttonArray[i][j])
               {
                  buttonArray[i][j].setVisible(false);
                  invisibleButtonCount++;

//first piece of code that switches visibility
               try
               {
                  if (buttonArray[i-1][j].isVisible())
                  {
                     buttonArray[i-1][j].setVisible(false);
                     invisibleButtonCount++;
                  }
                  else
                  {
                     buttonArray[i-1][j].setVisible(true);
                     invisibleButtonCount--;
                  }
               }
               catch (Exception ee)
               {
               }

//second piece of code that switches visibility  
               try
               {                
                  if (buttonArray[i+1][j].isVisible())
                  {
                     buttonArray[i+1][j].setVisible(false);
                     invisibleButtonCount++;
                  }
                  else
                  {
                     buttonArray[i+1][j].setVisible(true);
                     invisibleButtonCount--;
                  }
               }
               catch (Exception ee)
               {
               }

//third piece of code that switches visibility
               try
               {
                  if (buttonArray[i][j-1].isVisible())
                  {
                     buttonArray[i][j-1].setVisible(false);
                     invisibleButtonCount++;
                  }
                  else
                  {
                     buttonArray[i][j-1].setVisible(true);
                     invisibleButtonCount--;
                  }
               }
               catch (Exception ee)
               {
               }
                  
//fourth piece of code that switches visibility
               try
               {
                  if (buttonArray[i][j+1].isVisible())
                  {
                     buttonArray[i][j+1].setVisible(false);
                     invisibleButtonCount++;
                  }
                  else
                  {
                     buttonArray[i][j+1].setVisible(true);
                     invisibleButtonCount--;
                  }
               }
               catch (Exception ee)
               {
               }
//^^ end of initial if statement and below is the text changing if all squares disappear 

              }
            }
          }
          if (invisibleButtonCount == 16)
          {
            beginGame.setText("You win!");
          }
//^^ end of for loops

        }
      }
//^^class endings

}
//^^program ending
         
          
     
 
   
     
   
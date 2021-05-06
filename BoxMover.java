import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseDragEvent;

public class BoxMover extends Application
{

//construcing our root and canvas objects outside of the inner classes
FlowPane root = new FlowPane();
Canvas canvas = new Canvas(500, 500);
GraphicsContext gc = canvas.getGraphicsContext2D();

//variables in charge of the squares beginning draw position
double xPos = 235;
double yPos = 200;

//class in charge of setting up the stage for display
   public void start(Stage stage)
   {

//adding our canvas and creating our black square in the center of it     
      root.getChildren().add(canvas);   
      gc.fillRect(xPos,yPos,25,25);
      root.getChildren();
      
//setting our MouseDragged listener to the canvas
      canvas.setOnMouseDragged(new MouseDraggedListener());
      
   
//code that displays the window     
      Scene scene = new Scene(root, 500, 500);      
      stage.setScene(scene);      
      stage.setTitle("Lab #8 Part I");      
      stage.show(); 
      
   }

//code that launches the program   
   public static void main(String[] args)   
   {      
      launch(args);
   }

//class that redraws the square to the users cursor when dragging the square   
   public class MouseDraggedListener implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent me)
      {

//if statements that check if the user clicks on the square       
         if (me.getX() >= xPos-2 && me.getX() <= xPos + 26)
         {
            if (me.getY() >= yPos-2 && me.getY() <= yPos + 26)
            {

//clearing the canvas and then realigning the x and y coordinates so we can redraw the square to the cursors current location            
               gc.clearRect(0,0,600,600);
               xPos = me.getX()-13;
               yPos = me.getY()-13;
               gc.fillRect(xPos,yPos,25,25);
               
            }
         }
      
      }
   }
   
   
}
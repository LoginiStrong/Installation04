import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class LoadBar extends Canvas
{

//construction of objects outside the classes
GraphicsContext gc = getGraphicsContext2D();
AnimationHandler ta = new AnimationHandler();
FlowPane root = new FlowPane();

//variable in charge of the width for the red bar
private int barFill;

/*class that takes in the root from the client and sets a keypressed listener to it,
as well as calling the draw method*/
   public LoadBar (FlowPane root)
   {
      this.root = root;
      setWidth(800);
      setHeight(200);
      draw(gc);
      root.setOnKeyPressed(new KeyListenerDown());
   }

/*draw method that starts the animation handler as well as creating the
two inner rectangles that the loading bar will be drawn on top of*/
   public void draw (GraphicsContext gc)
   {
      ta.start();
      gc.clearRect(0,0,800,200);
      gc.setFill(Color.BLACK);
      gc.fillRect(0,0,800,200);
      gc.setFill(Color.WHITE);
      gc.fillRect(120,50,550,50);
      gc.setFill(Color.DARKBLUE);
      gc.fillRect(125,55,540,40); 
   }

//class that redraws the red loading bar's length at intervals of one, if the bar reaches 530 it resets
   public class AnimationHandler extends AnimationTimer
      {
         public void handle(long currentTimeInNanoSeconds)
         {   
               if (barFill == 530 )
               {
                  gc.clearRect(130, 60, 530, 30);
                  gc.setFill(Color.DARKBLUE);
                  gc.fillRect(125,55,540,40);
                  barFill = 0;   
               } 
               else
               {
                  barFill++;
               }
               gc.setFill(Color.RED);
               gc.fillRect(130,60,barFill,30);
         }
      }

//class that stops or starts the animation timer based on key input      
      public class KeyListenerDown implements EventHandler<KeyEvent>
      {
         public void handle (KeyEvent event)
         {
            if (event.getCode() == KeyCode.A)
            {
               ta.stop();
            }
            if (event.getCode() == KeyCode.S)
            {
               ta.start();
            }
         
         }
      }  
}
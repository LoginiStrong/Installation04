import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import java.util.*;
import java.awt.*;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;


public class CheckerboardSlot extends Canvas
{
//variable that holds the color
   private Color gOrY;

//constructor that takes in a color and creates a slot of that color   
   public CheckerboardSlot(Color gOrY)
   {
      this.gOrY = gOrY;
      setWidth(100);
      setHeight(100);
      GraphicsContext gc = getGraphicsContext2D();
      draw(gc);
   }

//method that fills the slot with the color entered  
   public void draw (GraphicsContext gc)
   {
      gc.setFill(gOrY);
      gc.fillRect(0,0,100,100);
   }


}
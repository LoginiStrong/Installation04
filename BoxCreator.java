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

public class BoxCreator extends Canvas
{
 public BoxCreator()
   {
      setWidth(55);
      setHeight(340);
      GraphicsContext gc = getGraphicsContext2D();
      draw(gc);
   }
   
   public void draw (GraphicsContext gc)
   {
      gc.fillRect(0,0,55,340);
   }






}
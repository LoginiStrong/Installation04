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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BasePaint extends Canvas
{

   private String shapeType;
   private int xPos;
   private int yPos;
   private int radOrSize;
   private double r;
   private double g;
   private double b;
   private Color fileColor;
   
   public BasePaint (String shapeType, int xPos, int yPos, int radOrSize, double r, double g, double b )
   {
      this.shapeType = shapeType;
      this.xPos = xPos;
      this.yPos = yPos;
      this.radOrSize = radOrSize;
      this.r = r;
      this.g = g;
      this.b = b;
      Color fileColor = new Color(r, g, b, 1);
      GraphicsContext gc = getGraphicsContext2D();
      draw(gc);
   }
   
   public void draw (GraphicsContext gc)
   {
      if (shapeType.equals("circle"))
      {
         Circle circle = new Circle(xPos, yPos, radOrSize);
         gc.setFill(fileColor);
      }
      else if (shapeType.equals("square"))
      {
         Rectangle square = new Rectangle(xPos, yPos, radOrSize, radOrSize);
         gc.setFill(fileColor);
      
      }
      
   }


}
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

public class FullBoard extends Application
{
   public void start (Stage stage)   
   {      
      FlowPane root = new FlowPane();
      Label l = new Label ("Hello World");
      l.setTextFill(Color.BLACK);
      root.getChildren().add(l);      
      Scene scene = new Scene(root, 400, 200);      
      stage.setScene(scene);      
      stage.setTitle("My First Cool Application No XML");      
      stage.show();   
   }
   
   public static void main(String[] args)   
   {      
      launch(args);
   }
}
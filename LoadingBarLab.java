import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public LoadingBarLab extends Application
{
   public void start(Stage stage)
   {
      FlowPane root = new FlowPane;
      
      
      
      
      Scene scene = new Scene(root, 800, 200);      
      stage.setScene(scene);      
      stage.setTitle("Lab #8 Part I");      
      stage.show();
   }
   
   
   public static void main(String[] args)   
   {      
      launch(args);
   }
   
   
}
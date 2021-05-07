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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Application;

public class MazeRunner extends Application
{

//code that sets up the window and its contents
   public void start(Stage stage)
   {
      FlowPane root = new FlowPane();
      MazeCreator canvas = new MazeCreator(root);
      root.getChildren().add(canvas);
   
   
   
   
//code in charge of the window itself being displayed
      Scene scene = new Scene(root, 525, 525);      
      stage.setScene(scene);      
      stage.setTitle("Project MazeRunner");      
      stage.show();
      canvas.requestFocus();
   }

//code that launches the program
   public static void main(String[] args)   
   {      
      launch(args);
   }



   
}
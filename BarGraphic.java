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
import javafx.animation.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class BarGraphic extends Application
{

//class in charge of setting up the stage
   public void start(Stage stage)
   {

/*creating a root and passing that root into our LoadBar constructor
so that we may create the canvas we want with our listeners*/
      FlowPane root = new FlowPane();
      LoadBar bar = new LoadBar(root);
      root.getChildren().add(bar);
        
      
      
      
      Scene scene = new Scene(root, 800, 195);      
      stage.setScene(scene);      
      stage.setTitle("Lab #8 Part I");      
      stage.show();

//requesting focus on the canvas so it displays the animation      
      bar.requestFocus(); 
   }
    
   
//code in charge of launching the program   
   public static void main(String[] args)   
   {      
      launch(args);
   }
  
} 
   

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;



public class Menu extends Application
{

StackPane root = new StackPane();




public void start (Stage stage)
   { 

//Rectangle rect = new Rectangle(10, 15);
      //Font font = Font.font(30);
      
      
   
   //}
      
      
      
      root.setOnKeyPressed(new KeyListenerDown());
      //initialize the scene with the root flowpane
      Scene scene = new Scene(root, 525, 525);
      stage.setScene(scene);
      stage.setTitle("BorderPane");
      stage.show();
      root.requestFocus();
   }   
      
      public static void main(String[] args)
   {
      launch(args);
   }
   
    public class KeyListenerDown implements EventHandler<KeyEvent>  
   {
      public void handle(KeyEvent event) 
      {
         if (event.getCode() == KeyCode.ESCAPE)
         {
            MenuMaker make = new MenuMaker(root);
         }
         
      }
   }

}
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

public class MenuMaker 
{
   public MenuMaker (StackPane r)
   {
Button resume = new Button("Resume");
      
      Button save = new Button("Save");
      //start.setFont(font);
      
      Button load = new Button("Load");
      //end.setFont(font);
      
      Button restartA = new Button("Restart Area");
      
      Button restartL = new Button("Restart Level");
      
      Button end = new Button("Exit");
      
      VBox vbox = new VBox (0, resume, save, load, restartA, restartL, end);
      vbox.setTranslateX(20);
      vbox.setTranslateY(20);
      r.getChildren().add(vbox);
      }
}
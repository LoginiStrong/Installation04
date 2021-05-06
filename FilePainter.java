import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.text.*;
import java.util.*;
import java.io.*;

public class FilePainter extends Application
{

//code that sets the stage
   public void start (Stage stage)   
   {

//VBox and canvas components constructed
      VBox root = new VBox(); 
      Canvas canvas = new Canvas(600, 600);
      GraphicsContext gc = canvas.getGraphicsContext2D();

//scanner to read users input created and used to get the fileName
      Scanner user = new Scanner(System.in);
      String fileName = user.next();   

//try statement that meets up with the fnfe catch statement       
try (Scanner scan = new Scanner(new File(fileName))) 
{

//loop that continues until nothing is left in the file to read
   while (scan.hasNext())
   {

//variables gathered from one line of the text file, they are then used to create the shape and its color
      String shape = scan.next();
      int x = scan.nextInt();
      int y = scan.nextInt();
      int size = scan.nextInt();
      double r = scan.nextDouble();
      double g = scan.nextDouble();
      double b = scan.nextDouble();
      Color fileColor = new Color(r, g, b, 1);
   
//command that sets the current color to the files color     
      gc.setFill(fileColor);
      
//else if statements that check to see if a circle or square are being created
      if (shape.equals("circle"))
      {
         gc.fillOval(x, y, size, size);
         root.getChildren();
      }
      else if (shape.equals("square"))
      {
         gc.fillRect(x, y, size, size);
         root.getChildren();
      }  
   }

//adding files creations to the canvas
   root.getChildren().add(canvas);  
     
   
}

//catch statement that catches file not found error
catch (FileNotFoundException fnfe)
   {
      System.out.println("File does not exist!");
   } 

//code that displays the scene   
      Scene scene = new Scene(root, 500, 500);      
      stage.setScene(scene);      
      stage.setTitle("Lab #6 Part I");      
      stage.show(); 

  
   }

//code that launches the program   
   public static void main(String[] args)   
   {      
      launch(args);
   }
}
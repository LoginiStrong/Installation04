import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class FullBoard extends Application
{

//setting the stage
   public void start (Stage stage)   
   { 
//creating our FlowPane     
      FlowPane root = new FlowPane();

//a loop that keeps track of what color CheckerboardSlot is constructed      
         for (int i = 0; i <42; i++)
         {
            if (i%2 == 1)
            {
               root.getChildren().add(new CheckerboardSlot(Color.YELLOW));
            }
            else
            {
               root.getChildren().add(new CheckerboardSlot(Color.GREEN));
            }
              
         }
      
//code that displays the scene           
      Scene scene = new Scene(root, 706, 600);      
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
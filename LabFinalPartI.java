import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.event.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;



public class LabFinalPartI extends Application
{
   public void start (Stage stage)   
   {

//main borderpane for the display
      BorderPane root = new BorderPane();
      
//Hbox pane that holds current dice label and adds it to the root      
      HBox currentDie = new HBox();
      Label cDieLabel = new Label("Current Dice\n     Result:");
      currentDie.getChildren().add(cDieLabel);
      currentDie.setAlignment(Pos.TOP_CENTER);
      root.setTop(currentDie);

//VBox that holds the first column of buttons on the left side of the borderpane
      VBox firstColumn = new VBox();
      Button four = new Button("4");
      four.setPrefSize(80, 80);
      Button six = new Button("6");
      six.setPrefSize(80, 80);
      Button eight = new Button("8");
      eight.setPrefSize(80, 80);
      Button ten = new Button("10");
      ten.setPrefSize(80, 80);
      firstColumn.setPrefSize(100, 500);
      firstColumn.getChildren().add(four);
      firstColumn.getChildren().add(six);
      firstColumn.getChildren().add(eight);
      firstColumn.getChildren().add(ten);
      root.setLeft(firstColumn);
      
//VBox that holds the second column of buttons on the left side of the borderpane
      VBox secColumn = new VBox();
      Button twelve = new Button("12");
      twelve.setPrefSize(80, 80);
      Button twenty = new Button("20");
      twenty.setPrefSize(80, 80);
      Button hundred = new Button("100");
      hundred.setPrefSize(80, 80);
      secColumn.setPrefSize(100, 500);
      secColumn.getChildren().add(twelve);
      secColumn.getChildren().add(twenty);
      secColumn.getChildren().add(hundred);
      root.setCenter(secColumn);
            
//Radio buttons on set to the right of the borderpane on a VBox

      ToggleGroup group = new ToggleGroup();
      RadioButton normDie = new RadioButton("Normal Dice ");
      RadioButton op1Die = new RadioButton("Op1 Dice ");
      RadioButton op2Die = new RadioButton("Op2 Dice "); 
      normDie.setToggleGroup(group);
      op1Die.setToggleGroup(group);
      op2Die.setToggleGroup(group);
      VBox rightV = new VBox();
      rightV.getChildren().add(normDie);
      rightV.getChildren().add(op1Die);
      rightV.getChildren().add(op2Die);
      root.setRight(rightV);
      
       
//code that displays the scene
      Scene scene = new Scene(root, 500, 500);      
      stage.setScene(scene);      
      stage.setTitle("The Final");      
      stage.show();
   }
   public static void main(String[] args)   
   {      
      launch(args);
   }
   
}
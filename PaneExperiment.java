import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class PaneExperiment extends Application
{

//code that sets the stage
   public void start (Stage stage)   
   {  
//BorderPane that surrounds the other panes
      BorderPane bp = new BorderPane();
      bp.setPrefSize(500,250);
      
//HBox at the top of the window     
      HBox topH = new HBox();
      Label topL = new Label("Top Label");
      topL.setTextFill(Color.BLUE);
      topH.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
      topH.getChildren().add(topL);
      bp.setTop(topH);
      
//HBox at the bottom of the window
      HBox botH = new HBox();
      Label botL = new Label("Bottom Label");
      botL.setTextFill(Color.ORANGE);
      botH.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
      botH.getChildren().add(botL);
      bp.setBottom(botH);
      
//VBox on the left of the window
      VBox leftV = new VBox();
      leftV.setPrefSize(100,250);
      Label leftL = new Label("Left Label");
      leftL.setTextFill(Color.WHITE); 
      leftV.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
      leftV.getChildren().add(leftL);
      bp.setLeft(leftV);
      
//VBox on the right of the window
      VBox rightV = new VBox();
      rightV.setPrefSize(100,250);
      Label rightL = new Label("Right Label");
      rightL.setTextFill(Color.WHITE);
      rightV.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
      rightV.getChildren().add(rightL);
      bp.setRight(rightV);

//FlowPane 1
      FlowPane fP1 = new FlowPane();
      fP1.setPrefSize(100,250);
      Label fP1_L = new Label("Top left"+"\n"+"Flow Pane label");
      fP1_L.setTextFill(Color.BLACK);
      fP1.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
      fP1.getChildren().add(fP1_L);
      leftV.getChildren().add(fP1);
      
//FlowPane 2
      FlowPane fP2 = new FlowPane();
      fP2.setPrefSize(100,250);
      Label fP2_L = new Label("Upper left"+"\n"+"Flow Pane label");
      fP2_L.setTextFill(Color.TOMATO);
      fP2.setBackground(new Background(new BackgroundFill(Color.TEAL, CornerRadii.EMPTY, Insets.EMPTY)));
      fP2.getChildren().add(fP2_L);
      leftV.getChildren().add(fP2);

//FlowPane 3     
      FlowPane fP3 = new FlowPane();
      fP3.setPrefSize(100,250);
      Label fP3_L = new Label("Middle left"+"\n"+"Flow Pane label");
      fP3_L.setTextFill(Color.RED);
      fP3.setBackground(new Background(new BackgroundFill(Color.LIME, CornerRadii.EMPTY, Insets.EMPTY)));
      fP3.getChildren().add(fP3_L);
      leftV.getChildren().add(fP3);
     
//FlowPane 4
      FlowPane fP4 = new FlowPane();
      fP4.setPrefSize(100,250);
      Label fP4_L = new Label("Lower left"+"\n"+"Flow Pane label");
      fP4_L.setTextFill(Color.TURQUOISE);
      fP4.setBackground(new Background(new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
      fP4.getChildren().add(fP4_L);
      leftV.getChildren().add(fP4);

//FlowPane 5 
      FlowPane fP5 = new FlowPane();
      fP5.setPrefSize(100,250);
      Label fP5_L = new Label("Bottom left"+"\n"+"Flow Pane label");
      fP5_L.setTextFill(Color.MIDNIGHTBLUE);
      fP5.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
      fP5.getChildren().add(fP5_L);
      leftV.getChildren().add(fP5);

//FlowPane 6
      FlowPane fP6 = new FlowPane();
      fP6.setPrefSize(100,250);
      Label fP6_L = new Label("Top right"+"\n"+"Flow Pane label");
      fP6_L.setTextFill(Color.CORAL);
      fP6.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
      fP6.getChildren().add(fP6_L);
      rightV.getChildren().add(fP6);
      
//FlowPane 7
      FlowPane fP7 = new FlowPane();
      fP7.setPrefSize(100,250);
      Label fP7_L = new Label("Upper right"+"\n"+"Flow Pane label");
      fP7_L.setTextFill(Color.DARKVIOLET);
      fP7.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
      fP7.getChildren().add(fP7_L);
      rightV.getChildren().add(fP7);
      
//FlowPane 8
      FlowPane fP8 = new FlowPane();
      fP8.setPrefSize(100,250);
      Label fP8_L = new Label("Middle right"+"\n"+"Flow Pane label");
      fP8_L.setTextFill(Color.FUCHSIA);
      fP8.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
      fP8.getChildren().add(fP8_L);
      rightV.getChildren().add(fP8);
      
//FlowPane 9
      FlowPane fP9 = new FlowPane();
      fP9.setPrefSize(100,250);
      Label fP9_L = new Label("Lower right"+"\n"+"Flow Pane label");
      fP9_L.setTextFill(Color.THISTLE);
      fP9.setBackground(new Background(new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
      fP9.getChildren().add(fP9_L);
      rightV.getChildren().add(fP9);
      
//FlowPane 10
      FlowPane fP10 = new FlowPane();
      fP10.setPrefSize(100,250);
      Label fP10_L = new Label("Lower right"+"\n"+"Flow Pane label");
      fP10_L.setTextFill(Color.MINTCREAM);
      fP10.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
      fP10.getChildren().add(fP10_L);
      rightV.getChildren().add(fP10);
      


//code that displays the scene
      Scene scene = new Scene(bp, 500, 250);      
      stage.setScene(scene);      
      stage.setTitle("Lab #6 Part II");      
      stage.show();
   }
   
//code that launches the program
 public static void main(String[] args)   
  {      
     launch(args);
  }
}

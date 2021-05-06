import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.event.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;

public class ComboBoxLab extends Application
{

//variable that keeps track of the y pos for the lines (rectangles)
int y = 20;
int thickness = 1;
int gap = 0;

/*objects in charge of the window displayed and its main contents
These things are created outside of both class, because both use them*/

//textfield
TextField textBox = new TextField("Enter an A or an I");

//radio buttons
ToggleGroup group = new ToggleGroup();
RadioButton noSpace = new RadioButton("No spaces");
RadioButton space = new RadioButton("1 space");

//checkbox
CheckBox thick = new CheckBox("Thick");

//combobox
ComboBox componentPicker = new ComboBox();

//graphics
FlowPane root = new FlowPane();
Canvas canvas = new Canvas(400, 300);
GraphicsContext gc = canvas.getGraphicsContext2D();

//labels for space between buttons
Label label = new Label("  ");
Label label2 = new Label("  ");
Label label3 = new Label("  ");

/*class in charge of creating the scene and calls the code 
in the ComboListener*/
      public void start (Stage stage)   
      {
      noSpace.setToggleGroup(group);
      space.setToggleGroup(group);
      componentPicker.getItems().add("10");
      componentPicker.getItems().add("50");
      componentPicker.getItems().add("100");
      
//code that sets the default setting to ten lines and no spaces
      componentPicker.setValue("10");
         for (int i = 0; i < 10; i++)
         {  
            gc.fillRect(0, y, 100, 1);
            root.getChildren();
            y += 11;
         }
      noSpace.setSelected(true);
         

//code in charge of creating the listener and setting focus on the action
      componentPicker.setOnAction(new ComboBoxListener());
      root.getChildren().add(componentPicker);
      root.getChildren().add(label);
      
//code in charge of creating the checkbox and setting focus on the action
      thick.setOnAction(new CheckBoxListener());
      root.getChildren().add(thick);
      root.getChildren().add(label2);

//radio button for no space
      noSpace.setOnAction(new RadioButtonListener());
      root.getChildren().add(noSpace);
      root.getChildren().add(label3);

//radio button for spaces
      space.setOnAction(new RadioButtonListener());
      root.getChildren().add(space);

//textfield box
      textBox.setOnAction(new TextFieldListener());
      root.getChildren().add(textBox);
      
      
//code that displays the scene and its contents      
      root.getChildren().add(canvas);
      Scene scene = new Scene(root, 400, 300);      
      stage.setScene(scene);      
      stage.setTitle("Lab #7 Part I & II");      
      stage.show(); 
   }
   
//code that launches the program
   public static void main(String[] args)   
   {      
      launch(args);
   }

//class in charge of the listeners events and actions through case statments
   public class ComboBoxListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         switch ((String)componentPicker.getValue())
         {

//statement that makes 10 lines with 10 white spaces when the user selects 10
            case "10":
               y = 20;
               gc.clearRect(0, 0, 300, 400);
               for (int i = 0; i < 10; i++)
               {  
                  gc.fillRect(0, y, 50, thickness);
                  gc.fillRect(50+gap, y, 50, thickness);
                  root.getChildren();
                  y += 11;
               }
               break;
               
//statement that makes 50 lines with 2 white spaces when the user selects 50
            case "50":
               y = 20;
               gc.clearRect(0, 0, 300, 400);
               for (int i = 0; i < 50; i++)
               {  
                  gc.fillRect(0, y, 50, thickness);
                  gc.fillRect(50+gap, y, 50, thickness);
                  root.getChildren();
                  y += 3;
               }
               break;
               
//statement that makes 100 lines with 1 white space when the user selects 100
            case "100":
               y = 20;
               gc.clearRect(0, 0, 300, 400);
               for (int i = 0; i < 100; i++)
               {  
                  gc.fillRect(0, y, 50, thickness);
                  gc.fillRect(50+gap, y, 50, thickness);
                  root.getChildren();
                  y += 2;
               }
               break;
         }
      }
   }
   
//checkbox creation
   public class CheckBoxListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         if (thick.isSelected())
         {
            thickness = 2;
         } 
         else if (! thick.isSelected())
         {
            thickness = 1;
         } 
            switch ((String)componentPicker.getValue())
            {

//statement that makes 20 lines with 10 white spaces when the user selects 10
               case "10":
                  y = 20;
                  gc.clearRect(0, 0, 300, 400);
                  for (int i = 0; i < 10; i++)
                  {  
                     gc.fillRect(0, y, 50, thickness);
                     gc.fillRect(50+gap, y, 50, thickness);
                     root.getChildren();
                     y += 11;
                  }
                  break;
               
//statement that makes 100 lines with 2 white spaces when the user selects 50
               case "50":
                  y = 20;
                  gc.clearRect(0, 0, 300, 400);
                  for (int i = 0; i < 50; i++)
                  {  
                     gc.fillRect(0, y, 50, thickness);
                     gc.fillRect(50+gap, y, 50, thickness);
                     root.getChildren();
                     y += 3;
                  }
                  break;
               
//statement that makes 200 lines with no white space when the user selects 100
               case "100":
                  y = 20;
                  gc.clearRect(0, 0, 300, 400);
                  for (int i = 0; i < 100; i++)
                  {  
                     gc.fillRect(0, y, 50, thickness);
                     gc.fillRect(50+gap, y, 50, thickness);
                     root.getChildren();
                     y += 2;
                  }
                  break;
            }
       }
   }
   
//class and its variables in charge of spacing between each line segments
public class RadioButtonListener implements EventHandler<ActionEvent>
   {
      public void handle (ActionEvent e)
      {
         if (space.isSelected())
         {
            gap = 20; 
         }
         else if (noSpace.isSelected())
         {
            gap = 0;
         }
            switch ((String)componentPicker.getValue())
            {

//drawing the gap when selected
               case "10":
                  y = 20;
                  gc.clearRect(0, 0, 300, 400);
                  for (int i = 0; i < 10; i++)
                  {  
                     gc.fillRect(0, y, 50, thickness);
                     gc.fillRect(50+gap, y, 50, thickness);
                     root.getChildren();
                     y += 11;
                  }
                  break;
               
//drawing the gap when selected
               case "50":
                  y = 20;
                  gc.clearRect(0, 0, 300, 400);
                  for (int i = 0; i < 50; i++)
                  {  
                     gc.fillRect(0, y, 50, thickness);
                     gc.fillRect(50+gap, y, 50, thickness);
                     root.getChildren();
                     y += 3;
                  }
                  break;
               
//drawing the gap when selected
               case "100":
                  y = 20;
                  gc.clearRect(0, 0, 300, 400);
                  for (int i = 0; i < 100; i++)
                  {  
                     gc.fillRect(0, y, 50, thickness);
                     gc.fillRect(50+gap, y, 50, thickness);
                     root.getChildren();
                     y += 2;
                  }
                  break;
         }
      }
   }  
            
//class in charge of the textfield
public class TextFieldListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {

//if user chooses A the settings change to 100, thick, and spaced
         String choice = textBox.getText();
         if (choice.equals("A"))
         {
            componentPicker.setValue("100");
            thick.setSelected(true); 
            space.setSelected(true);
            y = 20;
            thickness = 2;
            gap = 20;
            gc.clearRect(0, 0, 300, 400);
            for (int i = 0; i < 100; i++)
            {  
               gc.fillRect(0, y, 50, thickness);
               gc.fillRect(50+gap, y, 50, thickness);
               root.getChildren();
               y += 2;
            }
            
         }

//if the user select I the setting revert back to their default conditions
         else if (choice.equals("I"))
         {
            componentPicker.setValue("10");
            thick.setSelected(false); 
            noSpace.setSelected(true);
            y = 20;
            thickness = 1;
            gap = 0;
            gc.clearRect(0, 0, 300, 400);
            for (int i = 0; i < 10; i++)
            {  
               gc.fillRect(0, y, 50, thickness);
               gc.fillRect(50+gap, y, 50, thickness);
               root.getChildren();
               y += 11;
            } 
         }
      }
   }
         


}
 
                   

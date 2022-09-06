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
import java.io.*;
import java.text.*;
import java.util.*;

public class PracticeFinal extends Application
{

int value0 = 0;
int value1 = 0;
int value2 = 0;
int value3 = 0;
int value4 = 0;

//first toggle group with radio buttons
   ToggleGroup group = new ToggleGroup();
   RadioButton bad = new RadioButton("Bad ");
   RadioButton semibad = new RadioButton("Semi-Bad ");
   RadioButton average = new RadioButton("Average ");
   RadioButton good = new RadioButton("Good ");
   RadioButton excellent = new RadioButton("Excellent ");
   
//second toggle group with radio buttons
   ToggleGroup group1 = new ToggleGroup();
   RadioButton bad1 = new RadioButton("Bad ");
   RadioButton semibad1 = new RadioButton("Semi-Bad ");
   RadioButton average1 = new RadioButton("Average ");
   RadioButton good1 = new RadioButton("Good ");
   RadioButton excellent1 = new RadioButton("Excellent ");

//third toggle group with radio buttons
   ToggleGroup group2 = new ToggleGroup();
   RadioButton bad2 = new RadioButton("Bad ");
   RadioButton semibad2 = new RadioButton("Semi-Bad ");
   RadioButton average2 = new RadioButton("Average ");
   RadioButton good2 = new RadioButton("Good ");
   RadioButton excellent2 = new RadioButton("Excellent ");

//fourth toggle group with radio buttons
   ToggleGroup group3 = new ToggleGroup();
   RadioButton bad3 = new RadioButton("Bad ");
   RadioButton semibad3 = new RadioButton("Semi-Bad ");
   RadioButton average3 = new RadioButton("Average ");
   RadioButton good3 = new RadioButton("Good ");
   RadioButton excellent3 = new RadioButton("Excellent ");   
   
//fourth toggle group with radio buttons
   ToggleGroup group4 = new ToggleGroup();
   RadioButton bad4 = new RadioButton("Bad ");
   RadioButton semibad4 = new RadioButton("Semi-Bad ");
   RadioButton average4 = new RadioButton("Average ");
   RadioButton good4 = new RadioButton("Good ");
   RadioButton excellent4 = new RadioButton("Excellent ");
      
//buttons for save and reset
   Button save = new Button("Save");
   Button result = new Button("Results");
   
   public void start (Stage stage)   
   {
   
   save.setOnAction(new ButtonListener());
   result.setOnAction(new ButtonListener());

//first
   bad.setToggleGroup(group);
   semibad.setToggleGroup(group);
   average.setToggleGroup(group);
   good.setToggleGroup(group);
   excellent.setToggleGroup(group);
   
//second
   bad1.setToggleGroup(group1);
   semibad1.setToggleGroup(group1);
   average1.setToggleGroup(group1);
   good1.setToggleGroup(group1);
   excellent1.setToggleGroup(group1);
   
//third
   bad2.setToggleGroup(group2);
   semibad2.setToggleGroup(group2);
   average2.setToggleGroup(group2);
   good2.setToggleGroup(group2);
   excellent2.setToggleGroup(group2);
   
//fourth
   bad3.setToggleGroup(group3);
   semibad3.setToggleGroup(group3);
   average3.setToggleGroup(group3);
   good3.setToggleGroup(group3);
   excellent3.setToggleGroup(group3);
   
//fifth
   bad4.setToggleGroup(group4);
   semibad4.setToggleGroup(group4);
   average4.setToggleGroup(group4);
   good4.setToggleGroup(group4);
   excellent4.setToggleGroup(group4);
   
//first
   bad.setOnAction(new RadioButtonListener());
   semibad.setOnAction(new RadioButtonListener());
   average.setOnAction(new RadioButtonListener());
   good.setOnAction(new RadioButtonListener());
   excellent.setOnAction(new RadioButtonListener());
   
//second
   bad1.setOnAction(new RadioButtonListener());
   semibad1.setOnAction(new RadioButtonListener());
   average1.setOnAction(new RadioButtonListener());
   good1.setOnAction(new RadioButtonListener());
   excellent1.setOnAction(new RadioButtonListener());
   
//third
   bad2.setOnAction(new RadioButtonListener());
   semibad2.setOnAction(new RadioButtonListener());
   average2.setOnAction(new RadioButtonListener());
   good2.setOnAction(new RadioButtonListener());
   excellent2.setOnAction(new RadioButtonListener());
   
//fourth
   bad3.setOnAction(new RadioButtonListener());
   semibad3.setOnAction(new RadioButtonListener());
   average3.setOnAction(new RadioButtonListener());
   good3.setOnAction(new RadioButtonListener());
   excellent3.setOnAction(new RadioButtonListener());
   
//fifth
   bad4.setOnAction(new RadioButtonListener());
   semibad4.setOnAction(new RadioButtonListener());
   average4.setOnAction(new RadioButtonListener());
   good4.setOnAction(new RadioButtonListener());
   excellent4.setOnAction(new RadioButtonListener());     
   
  
   
      VBox root = new VBox();
      
//top hbox
      HBox topH = new HBox();
      topH.setPrefSize(500, 80); 
      root.getChildren().add(topH);
   
//first question hbox
      HBox firstQ = new HBox();
      Label q0 = new Label("              Question 0   ");
      firstQ.setPrefSize(500, 50);
      firstQ.getChildren().add(q0);
      firstQ.getChildren().add(bad);
      firstQ.getChildren().add(semibad);
      firstQ.getChildren().add(average);
      firstQ.getChildren().add(good);
      firstQ.getChildren().add(excellent);
      root.getChildren().add(firstQ);
      
//second hbox
      HBox secQ = new HBox();
      Label q1 = new Label("              Question 1   ");
      secQ.setPrefSize(500, 50);
      secQ.getChildren().add(q1);
      secQ.getChildren().add(bad1);
      secQ.getChildren().add(semibad1);
      secQ.getChildren().add(average1);
      secQ.getChildren().add(good1);
      secQ.getChildren().add(excellent1);
      root.getChildren().add(secQ);
      
//third hbox
      HBox thirdQ = new HBox();
      Label q2 = new Label("              Question 2   ");
      thirdQ.setPrefSize(500, 50);
      thirdQ.getChildren().add(q2);
      thirdQ.getChildren().add(bad2);
      thirdQ.getChildren().add(semibad2);
      thirdQ.getChildren().add(average2);
      thirdQ.getChildren().add(good2);
      thirdQ.getChildren().add(excellent2);
      root.getChildren().add(thirdQ);
      
//fourth hbox
      HBox fourthQ = new HBox();
      Label q3 = new Label("              Question 3   ");
      fourthQ.setPrefSize(500, 50);
      fourthQ.getChildren().add(q3);
      fourthQ.getChildren().add(bad3);
      fourthQ.getChildren().add(semibad3);
      fourthQ.getChildren().add(average3);
      fourthQ.getChildren().add(good3);
      fourthQ.getChildren().add(excellent3);
      root.getChildren().add(fourthQ);

//fifth hbox
      HBox fifthQ = new HBox();
      Label q4 = new Label("              Question 4   ");
      fifthQ.setPrefSize(500, 50);
      fifthQ.getChildren().add(q4);
      fifthQ.getChildren().add(bad4);
      fifthQ.getChildren().add(semibad4);
      fifthQ.getChildren().add(average4);
      fifthQ.getChildren().add(good4);
      fifthQ.getChildren().add(excellent4);
      root.getChildren().add(fifthQ);   

//lower hbox
      HBox lowerH = new HBox();
      lowerH.setPrefSize(500, 30);
      root.getChildren().add(lowerH); 

//VBox
      HBox botH = new HBox();
      botH.setPrefSize(100, 50);
      botH.getChildren().add(save);
      botH.getChildren().add(result);
      botH.setAlignment(Pos.TOP_CENTER);
      root.getChildren().add(botH);
      
      
       
      
   
      Scene scene = new Scene(root, 500, 500);      
      stage.setScene(scene);      
      stage.setTitle("FinalPractice");      
      stage.show();
   }
   public static void main(String[] args)   
   {      
      launch(args);
   }

//RadioButton Listener
   public class RadioButtonListener implements EventHandler<ActionEvent>
   {
      public void handle (ActionEvent e)
      {
      //for first button group
         if (bad.isSelected())
         {
            value0 = 1;
         }
         if (semibad.isSelected())
         {
            value0 = 2;
         }
         if (average.isSelected())
         {
            value0 = 3;
         }
         if (good.isSelected())
         {
            value0 = 4;
         }
         if (excellent.isSelected())
         {
            value0 = 5;
         }
     //for second button group
         if (bad1.isSelected())
         {
            value1 = 1;
         }
         if (semibad1.isSelected())
         {
            value1 = 2;
         }
         if (average1.isSelected())
         {
            value1 = 3;
         }
         if (good1.isSelected())
         {
            value1 = 4;
         }
         if (excellent1.isSelected())
         {
            value1 = 5;
         }
     //for third button group
         if (bad2.isSelected())
         {
            value2 = 1;
         }
         if (semibad2.isSelected())
         {
            value2 = 2;
         }
         if (average2.isSelected())
         {
            value2 = 3;
         }
         if (good2.isSelected())
         {
            value2 = 4;
         }
         if (excellent2.isSelected())
         {
            value2 = 5;
         }
    //for fourth button group
         if (bad3.isSelected())
         {
            value3 = 1;
         }
         if (semibad3.isSelected())
         {
            value3 = 2;
         }
         if (average3.isSelected())
         {
            value3 = 3;
         }
         if (good3.isSelected())
         {
            value3 = 4;
         }
         if (excellent3.isSelected())
         {
            value3 = 5;
         }   
     //for fifth button group
         if (bad4.isSelected())
         {
            value4 = 1;
         }
         if (semibad4.isSelected())
         {
            value4 = 2;
         }
         if (average4.isSelected())
         {
            value4 = 3;
         }
         if (good4.isSelected())
         {
            value4 = 4;
         }
         if (excellent4.isSelected())
         {
            value4 = 5;
         }            
      }
   }

   public class ButtonListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         if(e.getSource() == save)
         {
            try
            {
               FileOutputStream fos = new FileOutputStream("final.txt", true);
               PrintWriter pw = new PrintWriter(fos);
               pw.println(value0+" "+value1+" "+value2+" "+value3+" "+value4);
               pw.close();
            }
            catch (FileNotFoundException fnfe)
            {
               System.out.println("File not found");
            }
         }
         
         if(e.getSource() == result)
         {
         
            try (Scanner scan = new Scanner(new File("final.txt")))
            {
               
               int rows = 1;
               int count = 0;
               while (scan.hasNextInt())
               {
                  if (count == 5)
                  {
                     rows++;
                     count = 0;
                  }
                  count++;
               }
               int [][] numArray = new int [rows][5];
               
               for(int i = 0; i < rows; i++)
               {
                  for(int j = 0; j < 5; j++)
                  {
                     numArray[i][j] = scan.nextInt();
                  }
               }
            
            
            int firstNum = 0;
            int secNum = 0;
            int thirdNum = 0;
            int fourthNum = 0;
            int fifthNum = 0;
            for(int i = 0; i < rows; i++)
               {
                  firstNum = numArray[i][0] + firstNum;
                  secNum = numArray[i][1] + secNum;
                  thirdNum = numArray[i][2] + thirdNum;
                  fourthNum = numArray[i][3] + fourthNum; 
                  fifthNum = numArray[i][4] + fifthNum;  
               }
           System.out.println(firstNum);
           }
           catch (FileNotFoundException fnfe)
            {
               System.out.println("File not found");
            } 
                 
         }
      }
   }   

     

}
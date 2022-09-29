import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.image.Image; 
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import java.util.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.*;
import java.io.*;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.animation.*;
import javafx.scene.input.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class TrapZack extends Application{

  //Variables holding the offsets of the level
  int levelOffsetX = 100;
  int levelOffsetY = 100;
  
  //Player x and y positions
  int Px = 0;
  int Py = 0;
  //boolean holding when the player is first drawn
  boolean drewPlayer = false;
  //variables holding directional access
  boolean canMoveLeft = true;
  boolean canMoveRight = true;
  boolean canMoveUp = true;
  boolean canMoveDown = true;
  //variable to count the current frame rotation
  int frameCount = 0;
  
  //ContraptionZacLevel L1;
  ContraptionZacLevel L1 = new ContraptionZacLevel("Assets/Level1.txt");
   
  StackPane root = new StackPane();
  Canvas canvas = new Canvas(800, 800);
  GraphicsContext gc = canvas.getGraphicsContext2D();
  
  AnimationTimer ta;
  

  //assets for pause menu
  int numberOfSaves = 0;
  TextInputDialog td = new TextInputDialog();
  boolean gamePaused = false;
  boolean titleMenu = true;
  Button resume = new Button("Resume");
  
  Button save = new Button("Save");
  
  Button load = new Button("Load");
  
  Button restartA = new Button("Restart Area");
  Button restartL = new Button("Restart Level");
  
  Button end = new Button("Exit");
  
  VBox vbox = new VBox (0, resume, save, load, restartA, restartL, end);
  
  
  
  //title menu
  TextInputDialog ld = new TextInputDialog();
  Button newGame = new Button("New Game");
  Button loadGame = new Button("Load Game");
  Font comic = new Font("Comic Sans MS", 50);
  Font font = new Font(20);
  Label title = new Label("Contraption Zack");
  VBox titleBox = new VBox(200, title, newGame, loadGame);
  
  //assets for load menu
  Button save1 = new Button("");
  Button save2 = new Button("");
  Button save3 = new Button("");
  Button save4 = new Button("");
  Button save5 = new Button("");
  
  VBox saveBox = new VBox(0, save1, save2, save3, save4, save5);
  
  //game
  Image Water = new Image("Assets/Water.png", false);
  Image Player1 = new Image("Assets/Boat1.png", false);
  Image Player2 = new Image("Assets/Boat2.png", false);
  Image Arrow = new Image("Assets/Arrow.png", false);
  Image PlayerImage = Player1;
   
   public void start(Stage stage){
   
      //escape menu
      
      save1.setOnAction(new ButtonListener());
      save2.setOnAction(new ButtonListener());
      save3.setOnAction(new ButtonListener());
      save4.setOnAction(new ButtonListener());
      save5.setOnAction(new ButtonListener());
      //saveBox.setAlignment(Pos.TOP_CENTER);
      //save1.setMinWidth(100);
      
      resume.setMinWidth(100);
      save.setMinWidth(100);
      load.setMinWidth(100);
      restartA.setMinWidth(100);
      restartL.setMinWidth(100);
      end.setMinWidth(100);
      
      save.setOnAction(new ButtonListener());
      load.setOnAction(new ButtonListener());
      resume.setOnAction(new ButtonListener());
      end.setOnAction(new ButtonListener());
      restartA.setOnAction(new ButtonListener());
      restartL.setOnAction(new ButtonListener());
      root.setOnKeyPressed(new KeyListenerDown());
      
      
      
   
      Scene scene = new Scene(root, 800, 800);      
      root.getChildren().add(canvas);
            
      //title
      title.setFont(comic);
      newGame.setFont(comic);
      loadGame.setFont(comic);
      //vbox.setAlignment(Pos.CENTER); 
      newGame.setOnAction(new ButtonListener());
      loadGame.setOnAction(new ButtonListener());
      titleBox.setAlignment(Pos.CENTER);
      root.getChildren().add(titleBox);
      
            
      //default javafx stuff
      stage.setScene(scene);      
      stage.setTitle("Square");      
      stage.show();
      
      //Keyboard lisetner
      
      
      //request focus for canvas
      canvas.requestFocus();
      //titleBox.requestFocus();
      newGame.requestFocus();
   }
   
   //main
   public static void main(String[] args){ 
      launch(args); 
   }
   
   
   //animation
   public class AnimationHandler extends AnimationTimer{
      public void handle(long currentTimeInNanoSeconds){
         draw(gc);
      }   
   }
   
   //draw player movement and stuff
   public void draw(GraphicsContext gc){
      root.setStyle("-fx-background-color: yellow");

      //if not in the title screen
      if(titleMenu == false){
         //load the first level, get the data from the text file
         String[][] data = L1.getData();
         //get the dimensions of the text for the for loops
         int x = L1.getX();
         int y = L1.getY();
         
         //go through the array
         for (int i = 0; i < x; i++)
         {
            for (int j = 0; j < y; j++)
            {
               //generic water tile
               if (data[i][j].equals("T1"))
               {
                  gc.drawImage(Water, levelOffsetX + i*64, levelOffsetY + j*64);
               }
               //Exit Arrow Tile
               else if (data[i][j].equals("XT1"))
               {
                  gc.drawImage(Water, levelOffsetX + i*64, levelOffsetY + j*64);
                  gc.drawImage(Arrow, levelOffsetX + i*64, levelOffsetY + j*64);
               }
               //Player Tile
               //else if (data[i][j].equals("PT1"))
               //{
                  //gc.drawImage(Water, levelOffsetX + i*64, levelOffsetY + j*64);
                  //set the player position, only once
                  if (!drewPlayer)
                  {
                     Px = levelOffsetX + L1.getPx()*64;
                     Py = levelOffsetY + L1.getPy()*64;
                     //boolean to hold if the player's position has been set yet
                     drewPlayer = true;
                  }
               //}
            }
         }
         
         //check bounds left
         //if the player is trying to move outside the array
         if ((Px - 48 - levelOffsetX)/64 <= -1)
            canMoveLeft = false;
         else
         {
            //if the players left is NOT a walkable tile
            if ((!data[(Px - 48 - levelOffsetX)/64][(Py - levelOffsetY)/64].equals("T1")) && (!data[(Px - 48 - levelOffsetX)/64][(Py - levelOffsetY)/64].equals("T1")) && (!data[(Px - 48 - levelOffsetX)/64][(Py - levelOffsetY)/64].equals("XT1")))
               canMoveLeft = false;
            //if the players left is a walkable tile
            else 
               canMoveLeft = true;
         }
            
         //check bounds right
         //if the player is trying to move outside the array
         if ((Px + 48  - levelOffsetX)/64 >= x)
            canMoveRight = false;
         else
         {
            //if the players right is NOT a walkable tile
            if ((!data[(Px + 48 - levelOffsetX)/64][(Py - levelOffsetY)/64].equals("T1")) && (!data[(Px + 48 - levelOffsetX)/64][(Py - levelOffsetY)/64].equals("T1")) && (!data[(Px + 48 - levelOffsetX)/64][(Py - levelOffsetY)/64].equals("XT1")))
               canMoveRight = false;
            //if the players right is a walkable tile
            else 
               canMoveRight = true;
         }
         
         //check bounds up
         //if the player is trying to move outside the array
         if ((Py - 59 - levelOffsetY)/64 <= -1)
            canMoveUp = false;
         else
         {
            //if the players up is NOT a walkable tile
            if ((!data[(Px - levelOffsetX)/64][(Py - 59 - levelOffsetY)/64].equals("T1")) && (!data[(Px - levelOffsetX)/64][(Py - 59 - levelOffsetY)/64].equals("T1")) && (!data[(Px - levelOffsetX)/64][(Py - 59 - levelOffsetY)/64].equals("XT1")))
               canMoveUp = false;
            //if the players up is a walkable tile
            else 
               canMoveUp = true;
         }
            
         //check bounds Down
         //if the player is trying to move outside the array
         if ((Py + 64  - levelOffsetY)/64 >= y)
            canMoveDown = false;
         else
         {
            //if the players down is NOT a walkable tile
            if ((!data[(Px - levelOffsetX)/64][(Py + 64 - levelOffsetY)/64].equals("T1")) && (!data[(Px - levelOffsetX)/64][(Py + 64 - levelOffsetY)/64].equals("T1")) && (!data[(Px - levelOffsetX)/64][(Py + 64 - levelOffsetY)/64].equals("XT1")))
               canMoveDown = false;
            //if the players down is a walkable tile
            else 
               canMoveDown = true;
         }

         //deal with objects
         L1.getObjects();
      }
      
      //count every five frames, swap image every cycle
      frameCount++;
      if (frameCount > 4)
      {
         frameCount = 0;
         if (PlayerImage == Player1)
            PlayerImage = Player2;
         else if (PlayerImage == Player2)
            PlayerImage = Player1;
      }
      //Draw player at its current position over the background
      gc.drawImage(PlayerImage, Px, Py);
      

   }
   
   
   public class KeyListenerDown implements EventHandler<KeyEvent>  
   {
   
      public void handle(KeyEvent event) 
      {
         //Escape menu
         if (event.getCode() == KeyCode.ESCAPE && gamePaused == false && titleMenu == false)
         {
            gamePaused = true;
            root.getChildren().add(vbox);
            resume.requestFocus();
            
         }
         else if (event.getCode() == KeyCode.ESCAPE && gamePaused)
         {
            gamePaused = false;
            root.getChildren().remove(vbox);
            root.requestFocus();
         }
         
         //Player Movement
         if (!gamePaused)
         {
            //Left
            if (event.getCode() == KeyCode.A)
            {
               if (canMoveLeft)
                  Px--;
            }
            //Right
            if (event.getCode() == KeyCode.D)
            {
               if (canMoveRight)
                  Px++;
            }
            //Up
            if (event.getCode() == KeyCode.W)
            {
               if (canMoveUp)
                  Py--;
            }
            //Down
            if (event.getCode() == KeyCode.S)
            {
               if (canMoveDown)
                  Py++;
            }
         }
         
         
      }
   }
   
   public class ButtonListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {  
         if (e.getSource() == end)
         {
            System.exit(0);
         }
         else if (e.getSource() == resume)
         {
            gamePaused = false;
            root.getChildren().remove(vbox);
            root.requestFocus();
         }
         else if (e.getSource() == save)
         {
            L1.setPx((Px/64)-1);
            L1.setPy((Py/64)-1);
            td.setContentText("Type in the name for your saved game");
            td.showAndWait();
            String name = td.getEditor().getText();
            L1.saveLevel("SaveGames/" + name + ".txt");
            
            
            switch (numberOfSaves)
            {
               case 0:
                  save1.setText(name);
                  numberOfSaves++;
                  break;
               case 1:
                  save2.setText(name);
                  numberOfSaves++;
                  break;
               case 2:
                  save3.setText(name);
                  numberOfSaves++;
                  break;
               case 3:
                  save4.setText(name);
                  numberOfSaves++;
                  break;
               case 4:
                  save5.setText(name);
                  numberOfSaves++;
                  break;
            
            }
            
            gamePaused = false;
            root.getChildren().remove(vbox);
            root.requestFocus();
            
         }
        
         else if (e.getSource() == restartA)
         {
            drewPlayer = false;
            gamePaused = false;
            L1 = new ContraptionZacLevel("Assets/Level1.txt");
            root.getChildren().remove(vbox);
            root.requestFocus();
            
         }
         else if (e.getSource() == restartL)
         {
            drewPlayer = false;
            gamePaused = false;
            L1 = new ContraptionZacLevel("Assets/Level1.txt");
            root.getChildren().remove(vbox);
            root.requestFocus();
         }
         
         if (e.getSource() == newGame)
         {
            titleMenu = false;
            root.getChildren().remove(titleBox);
            //vbox.setAlignment(Pos.TOP_LEFT);
            
            //ContraptionZacLevel L1 = new ContraptionZacLevel("Assets/Level1.txt");
            
            //create and start animation handler
            ta = new AnimationHandler();
            ta.start();


            root.requestFocus();
            
            
         }
         
         if (e.getSource() == loadGame)
         {
            titleMenu = false;
            //add code to load a saved file
            root.getChildren().remove(titleBox);
            FlowPane saveList = new FlowPane();
            saveList.setAlignment(Pos.CENTER_LEFT);
            
            File directoryPath = new File("SaveGames/");
            //List of all files and directories
            String saves[] = directoryPath.list();
            for (int i=0; i<saves.length; i++) 
            {
               
               Label l = new Label(saves[i]);
               l.setFont(font);
               saveList.getChildren().add(l);
               l = new Label("      ");
               saveList.getChildren().add(l);
               
            }
            root.getChildren().add(saveList);
            ld.setContentText("Type in the saved game you want to load");
            ld.showAndWait();
            String chosenSave = ld.getEditor().getText();
            L1 = new ContraptionZacLevel("SaveGames/"+chosenSave);
            root.getChildren().remove(saveList);
            //drewPlayer = false;
            //gamePaused = false;
            ta = new AnimationHandler();
            ta.start();
            root.requestFocus();
            
         }
         
         if (e.getSource() == load)
         {
            //resume.setText("Changed");
            root.getChildren().remove(vbox);
            root.getChildren().add(saveBox);
            save1.requestFocus();
            //System.out.println(save1.getText());
            //System.out.println(save1.getText().equals(""));      
         }
         
         //loading the saves
         if (e.getSource() == save1 && !save1.getText().equals(""))
         {
                  System.out.println(save1.getText());
                  L1 = new ContraptionZacLevel("SaveGames/"+save1.getText()+".txt");
                  root.getChildren().remove(saveBox);
                  drewPlayer = false;
                  gamePaused = false;
                  root.requestFocus();
         }
         if (e.getSource() == save2 && !save2.getText().equals(""))
         {
                  System.out.println(save1.getText());
                  L1 = new ContraptionZacLevel("SaveGames/"+save2.getText()+".txt");
                  root.getChildren().remove(saveBox);
                  drewPlayer = false;
                  gamePaused = false;
                  root.requestFocus();
         }
         if (e.getSource() == save3 && !save3.getText().equals(""))
         {
                  System.out.println(save1.getText());
                  L1 = new ContraptionZacLevel("SaveGames/"+save3.getText()+".txt");
                  root.getChildren().remove(saveBox);
                  drewPlayer = false;
                  gamePaused = false;
                  root.requestFocus();
         }
         if (e.getSource() == save4 && !save4.getText().equals(""))
         {
                  System.out.println(save1.getText());
                  L1 = new ContraptionZacLevel("SaveGames/"+save4.getText()+".txt");
                  root.getChildren().remove(saveBox);
                  drewPlayer = false;
                  gamePaused = false;
                  root.requestFocus();
         }
         if (e.getSource() == save5 && !save5.getText().equals(""))
         {
                  System.out.println(save1.getText());
                  L1 = new ContraptionZacLevel("SaveGames/"+save5.getText()+".txt");
                  root.getChildren().remove(saveBox);
                  drewPlayer = false;
                  gamePaused = false;
                  root.requestFocus();
         }
         //
         
         
         
      }
   }
   
   

}
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import java.io.*;

public class ProjectProgram
{
   Scanner scan;
   
   
   ByteLine commands = new ByteLine();
   
   //this method should read in the program file from the file. You may assume the file is in a good format
   public ProjectProgram(String filename)
   {
      try
      {
         File file = new File("testfile.txt");
         scan = new Scanner(file);
      
         while (scan.hasNext())
         {
            commands.addLine(scan.nextLine());
         }
      
      }
      catch(FileNotFoundException e)
      {
            System.out.println("File not found");
      }
   }
   
   //this method should print out the program in a readable format. The reason you want to print out a program is to verify you read it in right
   public void print()
   {
      commands.print();
   }
   
   
   //this method will only be called once, whenever the program is going to start, right before the first frame.
   public void beginStart()
   {

      setStartTime(); //this line of code has to be here.
   }

   
   //this is part 2
   //this method should run the program that you have stored somewhere else. Each time run is called, it starts with a blank canvas and starts running from the top of the main
   public void run(ProjectCanvas theCanvas)
   {
      commands.run();
      //runs the program here.   
   }
   
   

   
   //these are for the time command in the bytecode.
   double startTime;
   public void setStartTime()
   {
      startTime = System.currentTimeMillis();
   }
   
   //this method returns the current time as a float.
   public double getTime()
   {
      return System.currentTimeMillis() - startTime;
   }
}
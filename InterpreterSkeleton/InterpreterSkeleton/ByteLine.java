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


public class ByteLine
{
   private ArrayList<String> commands = new ArrayList<String>();//arraylist that holds each line of the file in individual indexes
   String currentCommand;//variable that holds the current line we're at
   String delims = "[ ]+";//variable for getting rid of the whitespaces in a line
   private int index = 0;//used as the current index we are at in the array
   
   public ByteLine()
   {
      
   }
   
   public void addLine(String line)//appends the line currently read by the scanner to the arraylist
   {
      commands.add(line);
   }
   
   public void print()//prints each line of the arraylist with a for loop and printwriter
   {
      try
      {
         PrintWriter out = new PrintWriter("output.txt");
         
         for (int i = 0; i < commands.size(); i++)
         {
            out.println(commands.get(i));
         }
         out.close();
         
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
      }  
   }
   
   public void run()
   {
      while (index != commands.size())
      {
         
         currentCommand = commands.get(index);//gets the line at current index
         
         if (!currentCommand.isBlank())
         {
            String[] tokens = currentCommand.split(delims);//
            System.out.println(tokens[0]);
            index++;
         }
         else
         {
            index++;
         }
      
      
      } 
      
      
   }
   
   
}
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
   String[] tokens;
   
   
   
   public ByteLine()
   {
      
   }
   
   public int size()
   {
      return commands.size();
   }
   
   public String get(int element)
   {
      return commands.get(element);
   }
   
   public void addLine(String line)//appends the line currently read by the scanner to the arraylist
   {
         if (!line.isEmpty())
         {
            commands.add(line);
         }
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
   
   public int getArgAmount(int com)//gets the amount of arguments in a current line
   {
   
      currentCommand = commands.get(com);
      if (!currentCommand.isBlank())
         {
            tokens = currentCommand.split(delims);//puts each term in the line into it's own index in an array
            return tokens.length;
         }
         else
         {
            return 0;
         }
   }
   
   
   public String getArgAtLine(int line, int arg)//acts like a 2d array, the first dimension being the line number, the second being the argument number
   {
         currentCommand = commands.get(line);//gets the line at current index
         
         if (!currentCommand.isBlank())
         {
            tokens = currentCommand.split(delims);//puts each term in the line into it's own index in an array
            return tokens[arg];
         }
      else
      {
         return "test";
      }
   }
   
   
   public void run()//was for first part
   {
      while (index != commands.size())
      {
         
         currentCommand = commands.get(index);//gets the line at current index
         
         if (!currentCommand.isBlank())
         {
            tokens = currentCommand.split(delims);//puts each term in the line into it's own index in an array
            for (int i = 0; i < tokens.length; i++)
            {
               System.out.print(tokens[i] + " ");
            }
            System.out.println();
            index++;
         }
         else
         {
            index++;
         }
      }   
   } 
}
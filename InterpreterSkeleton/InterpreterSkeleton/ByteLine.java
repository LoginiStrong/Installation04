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
   ArrayList<String> commands = new ArrayList<String>();
   
   public ByteLine()
   {
      
   }
   
   public void addLine(String line)
   {
      commands.add(line);
   }
   
   public void print()
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
   
   
   
   
}
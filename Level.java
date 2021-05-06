import java.util.*;
import java.io.*;
import java.text.*;

public class Level
{

//variables to tell how much data will be in the arrays
private int rows;
private int columns;
private int entries;
private int count = 0;

//variables related to creating arrays and keeping track of their contents 
private int x;
private int y;
private String name;

//constructed arrays
private int [][] fileArray;
ArrayList<Entry> eList = new ArrayList<Entry>();

public Level (String fileName)
{

//try and catch statements with all required code inside
try (Scanner scan = new Scanner(new File(fileName)))
{
   
//read in the the list into the array
   rows = scan.nextInt();
   columns = scan.nextInt();
   fileArray = new int [rows][columns];
      for (int i = 0; i < rows; i++)
      {
         for (int j = 0; j < columns; j++)
         {
            fileArray[i][j] = scan.nextInt(); 
         }
      }

//reading entries into the arraylist
   entries = scan.nextInt();
      while (count < entries)
      {
         x = scan.nextInt();
         y = scan.nextInt();
         name = scan.next();
         Entry e = new Entry(x, y, name);
         eList.add(e); 
         count++;
      }
   
}

//catch statement
   catch (FileNotFoundException fnfe)
   {
      System.out.println("File does not exist!");
   }

}

//addOne method that prints its contents to a new file
  public void addOne(String fileName)
  {
      try (Scanner scan = new Scanner(new File(fileName)))
      {
         rows = scan.nextInt();
         columns = scan.nextInt();
         
//contsructed objects that allow the program to write to a new file
         FileOutputStream fos = new FileOutputStream ("output.txt", false);
         PrintWriter pw = new PrintWriter(fos);
         
//same kind of format used in reading the array, except now it prints to the new array each time
         pw.print(rows+" "+columns+"\n"); 
         for (int i = 0; i < rows; i++)
         {
            for (int j = 0; j < columns; j++)
               {
                  fileArray[i][j] = scan.nextInt()+1;
                  pw.print(fileArray[i][j]+" "); 
               }
            pw.print("\n");
         }
         pw.print(entries+"\n");
         for (int i = 0; i < entries; i++)
         {
            pw.println(eList.get(i));
         }

         pw.close();
      }
      
//catch statement
catch (FileNotFoundException fnfe)
   {
      System.out.println("File does not exist!");
   }
 }




//toString method
      public String toString()
      {
      String returnString ="";
      returnString += rows+" "+columns+"\n";
         for (int i = 0; i < rows; i++)
         {
            for (int j = 0; j < columns; j++)
            {
               returnString += fileArray[i][j]+" ";
            }
         returnString += "\n";
         }
      for (int i = 0; i < entries; i++)
      {
         returnString += eList.get(i)+"\n";
      }
      return returnString;
      }  



    
}




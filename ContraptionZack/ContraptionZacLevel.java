import java.util.*;
import java.io.*;
import java.io.FileWriter;

public class ContraptionZacLevel
{
   String[][] data;
   String[][] objects;
   int x;
   int y;
   int Px;
   int Py;
   int nextFile;
   int numObjects;
   
   public String name;
   
   public ContraptionZacLevel(String filename)
   {
      name = filename;
   
      try
      {
         Scanner scan = new Scanner(new File(filename));
         
         //remove "Layout" string
         scan.next();
         
         Px = scan.nextInt();
         Py = scan.nextInt();
         
         //remove "Layout" string
         scan.next();
         
         //get next file to load
         nextFile = scan.nextInt();
         
         
         //get width and length of array
         y = scan.nextInt();
         x = scan.nextInt();
         
         //get layout
         data = new String[x][y];
         
         for(int i=0;i<y;i++)
         {
            for(int j=0;j<x;j++)
            {
               data[j][i] = scan.next();
            }
         }
         
                  
         //get objects
         scan.next();
                  
         numObjects = scan.nextInt();
         
         objects = new String[numObjects][2];
         
         for(int i = 0; i < numObjects; i++){
            objects[i][0] = scan.next();
            objects[i][1] = scan.next();
         }
      }
      catch(Exception e)
      {
      
      }
   }
   
   public String[][] getData()
   {
      return data;
   }
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public String[][] getObjects()
   {
      return objects;
   }

   public int getPy()
   {
      return Py;
   }
   
   public int getPx()
   {
      return Px;
   }
   
   public void setPy(int posY)
   {
      Py = posY;
   }
   
   public void setPx(int posX)
   {
      Px = posX;
   }
   
   public void saveLevel(String saveName)
   {
      try
         {
         //creates a file writer and rewrites every data member to a save file named by the user
            Scanner read = new Scanner(new File(name));
            FileWriter myWriter = new FileWriter(saveName);
            myWriter.write("PlayerPosition\n");
            myWriter.write(Px + " " + Py + "\n");
            myWriter.write("Layout\n");
            myWriter.write(nextFile + "\n");
            myWriter.write(y + " " + x + "\n");
            
            for(int i=0;i<y;i++)
            {
               for(int j=0;j<x;j++)
               {
                  myWriter.write(data[j][i] + " ");
               }
                myWriter.write("\n");
            }
            
            myWriter.write("Objects\n");
            myWriter.write(numObjects + "\n");
            
            for(int i = 0; i < numObjects; i++)
            {
               myWriter.write(objects[i][0]);
               myWriter.write(objects[i][1]);
               myWriter.write("\n");
            }
            myWriter.close(); 
         }
     catch (IOException e) 
         {
            System.out.println("An error occurred.");
         }
   }
   
   public int getNext(){
      return nextFile;
   }
}
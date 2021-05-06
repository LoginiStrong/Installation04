import java.util.*;
import java.io.*;
import java.text.*;

public class Entry
{
//variables
private int x;
private int y;
private String name;


//constructor for entries   
   public Entry (int x, int y, String name)
   {
      this.x = x;
      this.y = y;
      this.name = name;
   }

//accessors for x, y, and name  
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public String getName()
   {
      return name;
   }

   public String toString()
   {
      return getX()+" "+getY()+" "+getName();
   }

}  

import java.util.*;
import java.io.*;
import java.text.*;


public class CalcEx
{
//variables
private int number;

//class constructor
   public CalcEx ()
   {
      number = 0;
   }
   
   public void addNum()
   {
      number++;
   }
   
   public void subNum()
   {
      number--;
   }
   
   public String toString()
   {
      return ""+number;
   }
}
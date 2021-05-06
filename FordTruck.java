import java.util.*;
import java.io.*;
import java.text.*;

public class FordTruck extends Car
{

//variable for new constructor
private int haulingCapacity;

//new constructor including the new variable
   public FordTruck(String name, float speed, int haulingCapacity)
   {
      super(name, speed, haulingCapacity);
      this.haulingCapacity = haulingCapacity;
   }
  
//overrided drive method 
   public void drive()
   {
      speed++;
   }

//toString method   
   public String toString()
   {
      return "Name: "+name+"\nSpeed: "+speed+"\nHauling Capacity: "+haulingCapacity;
   }
}
   
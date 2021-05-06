import java.util.*;
import java.io.*;
import java.text.*;

public class HummingBird extends Bird
{
//variables
String name;

   public HummingBird(String name, String callsign, boolean canSwim, int mealsEaten)
   {
      super(callsign, canSwim, mealsEaten);
      this.name = name; 
      canSwim = false; 
   }


//defining abstract methods
   public void fly()//fly
   {
      System.out.println(name+" is flying high!!!");
   }
   
   public void swim()//swim
   {
     System.out.println("HummingBirds cannot swim");
   }
   
   public void eat()//eat
   {
      addMeal();
      System.out.println("yum");
   }
    
   public void chirp()//chirp
   {
       System.out.println(name+" chirps!");
   }
   
//to String method
   public String toString()
   {
      return "Name: "+name+"\nMeals Eaten: "+getMeals()+"\nCan Swim: "+getSwim()+"\nCallsign: "+getSign();
   }

//extraneous dance method
   public void dance()
   {
   }

}
      
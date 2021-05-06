import java.util.*;
import java.io.*;
import java.text.*;

public class Penguin extends Bird
{

//constructor
   public Penguin (String callsign, boolean canSwim, int mealsEaten)
   {
      super(callsign, canSwim, mealsEaten);
      canSwim = true;
   }

//overides of the abstract methods
  public void fly()//fly
   {
      System.out.println("Penguins cannot fly");
   }
   
   public void swim()//swim
   {
     System.out.println("Swimming Penguin!");
   }
   
   public void eat()//eat
   {
      add3Meal();
      System.out.println("nom nom nom");
   }
    
   public void chirp()//chirp
   {
      System.out.println("Penguin Chirping!");
   }

//toString method   
   public String toString()
   {
      return "Penguin: "+"\nMeals Eaten: "+getMeals()+"\nCan Swim: "+getSwim()+"\nCallsign: "+getSign();
   }

//tapdance method
   public void dance()
   {
      System.out.println("Tap Dancing Penguin!");
   }


}   
   
import java.util.*;
import java.io.*;
import java.text.*;

public abstract class Bird
{

//class variables
private String callsign;
private boolean canSwim;
private int mealsEaten;

//constructor for Bird
   public Bird (String callsign, boolean canSwim, int mealsEaten)
   {
      this.callsign = callsign;
      this.canSwim = canSwim;
      this.mealsEaten = mealsEaten;
   }

//abstract methods
   public abstract void fly();//fly
   
   public abstract void chirp();//chirp
   
   public abstract void eat();//eat
   
   public abstract void swim();//swim

//accessor methods
   public int getMeals()
   {
      return mealsEaten;
   }
   
   public boolean getSwim()
   {
      return canSwim;
   }
   
   public String getSign()
   {
      return callsign;
   }

//mutator method
   public int addMeal()
   {
      mealsEaten++;
      return mealsEaten;
   }
   
   public int add3Meal()
   {
      mealsEaten += 3;
      return mealsEaten;
   }

//tapdance abstract method
   public abstract void dance();

   
      
}
    

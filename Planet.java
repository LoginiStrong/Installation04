import java.util.*;
import java.io.*;
import java.text.*;
//class that extends the moon class
public class Planet extends Moon
{

//variables for planet class

private int population;

//constructor that includes a new parameter of population
   public Planet (String name, boolean isGas, double diameter, int population)
   {
      super (name, isGas, diameter);
     
      this.population = population;
   }

//accessor for poulation
public int getPopulation()
{
   return population;
}

//set population method
public int setPopulation(int population)
{
   this.population = population;
   return population;
}


//equals method for planet and moon objects
public boolean equals (Object o)
   {
      if (! (o instanceof Planet))
      {
         return false;
      }
      else
      {
       Planet objP = (Planet) o;
         if (getName().equals(objP.getName()))
         {
            if (getIfGas() == objP.getIfGas())
            {
               if (getDiameter() == objP.getDiameter())
               {
                  if(population == objP.getPopulation())
                  {
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }

//method that checks if population is below 500
public boolean isPopulationEndangered()
{
   if (population <= 500)
   {
      return true;
   }
   else
   return false;
}

//toString method
public String toString()
{
   if (getIfGas() == true)
   {
      return getName()+" is a ball of Gas with "+ population + " people.";
   }
   else if (getIfGas() == false)
   {
      return  getName() + " is a normal planet with a population of " + population + " people and a diameter of "+ getDiameter() + ".";
   }
   return "";
}




}
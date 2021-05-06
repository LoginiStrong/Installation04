/*This class holds constructors and methods that modify temperature inputs 
from a temperature client
Bye Logan Strong*/
import java.util.*;
import java.io.*;
import java.text.*;

public class TemperatureGauge
{
private double temperature;

//constructor that base is 0
   public TemperatureGauge() 
      {
         temperature = 0;
      }
      
//constructor double
   public TemperatureGauge(double startTemp)
      {
        setTempInF(startTemp);
      }
      
//return TempIntF as double
   public double getTempInF()
      {
         return temperature;
      }  
      
//convert temp to C and return
   public double getTempInC()
      {  
         double formula = 5.0/9.0;
         double difference = temperature - 32.0;
         return difference*formula;
      }
      
//sets code to new values that are within range
   public double setTempInF (double temperature)
      {
         this.temperature = temperature;
         if (temperature <= -30.0)
            {
               this.temperature = -30.0;
            }
         else if (temperature >= 180.0)
            {
               this.temperature = 180.0;
            }
         return this.temperature;  
      }
   
}
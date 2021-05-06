/*This client constructs objects and calls methods from a temperature class,
it then prints outputs of the modifications of inputted temperature
Bye Logan Strong*/
import java.util.*;
import java.io.*;
import java.text.*;

public class ClassLab
{
public static void main(String[] args) 
   {
//constructor with no arguements
TemperatureGauge num1 = new TemperatureGauge();

//print default F and C value
System.out.println(num1.getTempInF());
System.out.println(num1.getTempInC());

//constructor with 120 arguement
TemperatureGauge num2 = new TemperatureGauge(120);

//print out 120 arguement in F and C values
System.out.println(num2.getTempInF()); 
System.out.println(num2.getTempInC());

//set the first object to -80 and 180 and print them
System.out.println(num1.setTempInF(-80));  
System.out.println(num1.setTempInF(180)); 

//set temp to 59.5 and convert it to C  
num1.setTempInF(59.5);
System.out.println(num1.getTempInC());

//set each object equal to eachother
num2 = num1;

//set num2 eqaul to 33 and convert it to C
num2.setTempInF(33);
System.out.println(num1.getTempInC());  
   }
}
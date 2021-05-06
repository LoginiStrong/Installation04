/*This program holds a class that takes in person objects.
These objects are then printed out in a certain format using a
toString method. They are also compared to eachother to see if they're 
equal using our own .equals method
By Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class Person
{
//variables in the class that we can perform operations on
private String name;
private int age;
private int ID;
private static int count = 0;

//taking in variables from the client and converting them to this class's variables
   public Person (String nameIn, int ageIn, int IDIn)
      {
         name = nameIn;
         age = ageIn;
         ID = IDIn;
         count++;
      }
      
//equals method
   public boolean equals (Object o)
      {
         if (! (o instanceof Person))
            return false;
         else
         {
            Person objPerson = (Person) o;
               if (name.equals(objPerson.name)&& age ==(objPerson.age)&& ID ==(objPerson.ID))
               {
                  return true;
               }
               else
               return false;
         }
      }
      
//toString method that prints out all the information
   public String toString()
      {
         return "Age: "+age+"\nName: "+name+"\nID: "+ID;
      }

//static method that pulls the number of persons put into the system
   public static int getCount()
      {
         return count;
      }      
} 
                     
            
               
         
         
         
         
      
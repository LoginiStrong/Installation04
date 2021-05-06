/*This is the client that runs alongside the Person class. THis
main creates objects and compares them to eachother using methods from the Person class.
By Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class PersonClient
{
   public static void main(String [] args)
      { 

//constructing Persons
Person p1 = new Person ("Lauren", 19, 1001);
Person p2 = new Person ("Matthew", 18, 1002);
Person p3 = new Person ("Matthew", 18, 1002);
Person p4 = p3;

//printing out number of people
System.out.println("Number of people: "+Person.getCount());

//printing  out Persons in the desired format
System.out.println();
System.out.println(p1);
System.out.println();
System.out.println(p2);
System.out.println(p3);
System.out.println();

//checking equality with if statements
if (p2.equals(p3))
{
   System.out.println("p2 and p3 are .equals");
}
if (p1.equals(p2))
{
   System.out.println("p1 and p2 are .equals");
}
if (p1 == p2)
{
   System.out.println("p1 and p2 are ==");
}
if (p2 == p3)
{
   System.out.println("p2 and p3 are ==");
}
if (p3 == p4)
{
   System.out.println("p3 and p4 are ==");
}






      }
}
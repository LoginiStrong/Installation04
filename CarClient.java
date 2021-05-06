/*This client constructs a car with a name, speed, and hauling capacity.
It then uses a drive method that adds speed and prints out the object
all of these methods take in an abstract and inherited class.
by Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class CarClient
{
   public static void main(String [] args)
      {

FordTruck truck1 = new FordTruck("Explorer", 0, 100);
truck1.drive();
System.out.println(truck1);
System.out.println();
truck1.drive();
System.out.println(truck1);
      }
}
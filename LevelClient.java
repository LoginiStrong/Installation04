/*This client uses two other the Level and Entry classes
that allow it to read a file, print its contents to the user, 
and add one to the inner elements of the array and creating 
a new output file that holds those elements.
By Logan Strong*/

import java.util.*;
import java.io.*;
import java.text.*;

public class LevelClient
{
   public static void main(String [] args)
   {
   
//hardcoded file name
String fileName = "test.txt";

//constructed object that makes its own instance of the file
Level userLvl = new Level(fileName);

//commands that print the file and rewrite the file
System.out.println(userLvl);
userLvl.addOne(fileName);
   
   
   
   
   
   }
}

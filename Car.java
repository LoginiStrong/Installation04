import java.util.*;
import java.io.*;
import java.text.*;

public abstract class Car
{

//variables
protected float speed;
protected String name;

//car constructor
public Car(String name, float speed, int haulingCapacity)
{
   this.speed = speed;
   this.name = name; 
}


//abstract method
public abstract void drive();
}
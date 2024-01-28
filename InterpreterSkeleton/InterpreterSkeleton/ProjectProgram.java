import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import java.io.*;

public class ProjectProgram
{
   Scanner scan;
   boolean inFunction = false;//is checked to see if we are in a function other than main
   ArrayList<Register> globals = new ArrayList<Register>();
   HashMap<String,HashMap<String,Register>> functionRegisters = new HashMap<String,HashMap<String,Register>>();//holds the regmap that corresponds to the right function
   ArrayList<ByteLine> functions = new ArrayList<ByteLine>();//since each function is in a byteline this is how we access each function
   ByteLine commands;//object that stores each function and has accessors to get an arg at a certain line
   
   
   //this method should read in the program file from the file. You may assume the file is in a good format
   public ProjectProgram(String filename)
   {
      try
      {
         File file = new File(filename);
         scan = new Scanner(file);
      
         while (scan.hasNext())//reads whole file
         {
            if (scan.hasNext("function"))//if it reads function it stores all the lines in a byteline object till endfunction
            {
                  ByteLine commands = new ByteLine();
                  while (!scan.hasNext("endfunction"))
                  {
                     commands.addLine(scan.nextLine());
                  }
                  commands.addLine(scan.nextLine());
                  functions.add(commands);
                  HashMap<String,Register> tempMap = tempMap = new HashMap<String,Register>();
                  functionRegisters.put(commands.getArgAtLine(0,1),tempMap);
            }
            else if (scan.hasNext("globalfloat"))//if it reads global it stores that register in a globally accessible list and map
            {
               String tempGlobal = scan.nextLine();
               int sign = tempGlobal.indexOf('$');
               String sub = tempGlobal.substring(sign);
               Register reg = new Register(sub, 0, false);
               globals.add(reg);
               globalMap.put(reg.getName(), reg);
            
            }
            
         }
      
      }
      catch(FileNotFoundException e)
      {
            System.out.println("File not found");
      }
      //runCommands = commands.getCommands();
   }
   
   //this method should print out the program in a readable format. The reason you want to print out a program is to verify you read it in right
   public void print()
   {
      for (int i = 0; i < functions.size(); i++)
      {
         functions.get(i).print();
      }
   }
   
   
   
   //this method will only be called once, whenever the program is going to start, right before the first frame.
   public void beginStart()
   {
      for(int i=0;i<globals.size();i++)
      {
         //this creates the globals with the names of globals.get(i) as floats. In my register class, the first arg is the name, the second arg is the value, and the third arg is isBool
         globalMap.put(globals.get(i).getName(),globals.get(i));
      }
      setStartTime(); //this line of code has to be here.
   }

   //this map stores the global registers
   HashMap<String,Register> globalMap = new HashMap<String,Register>();
   
   //this is part 2
   //this method should run the program that you have stored somewhere else. Each time run is called, it starts with a blank canvas and starts running from the top of the main
   public void run(ProjectCanvas theCanvas)
   {
      
      //find the main function and run it.
      for(int i=0;i< functions.size();i++)
      {
         //functions.get(i) is the ith function
         //functions.get(i).get(0) is the first command in the function
         //functions.get(i).get(0).getArg(0) is the first argument, i.e., the function name
         if(functions.get(i).getArgAtLine(0,1).equals("main"))
         {
            //calls the private run function.
            runPriv(functions.get(i),theCanvas,null);
         }
      }
         
   }
    
   //run private
   public void runPriv(ByteLine theFunction, ProjectCanvas theCanvas, ArrayList<Register> params)
   {
      //this map is used to store this function's registers (this is for static scoping, dynamic scoping would have passed in the regMap into the function).
      
      HashMap<String,Register> regMap=null;
      regMap = functionRegisters.get(theFunction.getArgAtLine(0,1));//gets the correct register map for the current function
      
      for (int i = 0; i < globals.size(); i++)
      {
         regMap.put(globals.get(i).getName(),globals.get(i));//adds globals to this functions reg map
      }
      
      int i = 0;//index variable for the for loop
      HashMap<String,Integer> labels = new HashMap<String,Integer>();
      
      
      for (i = 0; i < theFunction.size(); i++)//loops through the current function and checks every if statement against the line
      {
         String firstArg = theFunction.getArgAtLine(i,0);
         if (firstArg.equals("function") && !theFunction.getArgAtLine(i,1).equals("main"))//runs this if it isnt the main function
         {                                                                          //it takes care of the passed in parameters
            inFunction = false;
            for (int j = 0; j < params.size(); j++)
            {
               params.get(j).setName(theFunction.getArgAtLine(i,3+j));
               regMap.put(params.get(j).getName(),params.get(j));
            }
         }
         
         if (firstArg.equals("print"))
         {
            if (regMap.get(theFunction.getArgAtLine(i,1)).isBool() == false)
            {
               System.out.println(regMap.get(theFunction.getArgAtLine(i,1)).getValue());
            }
            else 
            {
               System.out.println(regMap.get(theFunction.getArgAtLine(i,1)).getBool());
            }
         }
         
         if (firstArg.equals("float"))
         {
            Register reg = new Register(theFunction.getArgAtLine(i,1),0,false);
            regMap.put(reg.getName(), reg);
         }
         
         if (firstArg.equals("time"))
         {
            regMap.get(theFunction.getArgAtLine(i,1)).setValue((float) getTime());
         }
         
         if (firstArg.equals("bool"))
         {
            Register reg = new Register(theFunction.getArgAtLine(i,1),0,true);
            regMap.put(reg.getName(), reg);
         }
         
         if (firstArg.equals("=") && theFunction.getArgAtLine(i,2).startsWith("$"))
         {
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(regMap.get(theFunction.getArgAtLine(i,2)).getValue());
         }
         else if (firstArg.equals("="))
         {
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(Float.parseFloat(theFunction.getArgAtLine(i,2)));
         }
         
         if (firstArg.equals("+"))
         {
            float add1 = regMap.get(theFunction.getArgAtLine(i,2)).getValue();
            float add2 = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(add1 + add2);
         }
         
         if (firstArg.equals("-"))
         {
            float temp1 = regMap.get(theFunction.getArgAtLine(i,2)).getValue();
            float temp2 = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(temp1 - temp2);
         }
         
         if (firstArg.equals("*"))
         {
            float temp1 = regMap.get(theFunction.getArgAtLine(i,2)).getValue();
            float temp2 = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(temp1 * temp2);
         }
         
         if (firstArg.equals("/"))
         {
            float temp1 = regMap.get(theFunction.getArgAtLine(i,2)).getValue();
            float temp2 = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(temp1 / temp2);
         }
         
         if (firstArg.equals("%"))
         {
            float temp1 = regMap.get(theFunction.getArgAtLine(i,2)).getValue();
            float temp2 = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(temp1 % temp2);
         }
         
         if (firstArg.equals("||"))
         {
            if (regMap.get(theFunction.getArgAtLine(i,2)).getBool() == true || regMap.get(theFunction.getArgAtLine(i,3)).getBool() == true)
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(1);
            }
            else
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(0);
            }
         }
         
         if (firstArg.equals("&&"))
         {
            if (regMap.get(theFunction.getArgAtLine(i,2)).getBool() == true && regMap.get(theFunction.getArgAtLine(i,3)).getBool() == true)
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(1);
            }
            else
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(0);
            }
         }
         
         if (firstArg.equals("!"))
         {
            boolean temp = regMap.get(theFunction.getArgAtLine(i,1)).getBool();
            if (!temp == false)
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(0);
            }
            else
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(1);
            }
         }
         
         if (firstArg.equals(">"))
         {
            if (regMap.get(theFunction.getArgAtLine(i,2)).getValue() > regMap.get(theFunction.getArgAtLine(i,3)).getValue())
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(1);
            }
            else
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(0);
            }
         }
         
         if (firstArg.equals(">="))
         {
            if (regMap.get(theFunction.getArgAtLine(i,2)).getValue() >= regMap.get(theFunction.getArgAtLine(i,3)).getValue())
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(1);
            }
            else
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(0);
            }
         }
         
         if (firstArg.equals("=="))
         {
            if (regMap.get(theFunction.getArgAtLine(i,2)).getValue() == regMap.get(theFunction.getArgAtLine(i,3)).getValue())
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(1);
            }
            else
            {
               regMap.get(theFunction.getArgAtLine(i,1)).setValue(0);
            }
         }
         
         if (firstArg.equals("label"))
         {
            labels.put(theFunction.getArgAtLine(i,1), i);
         }
         
         if (firstArg.equals("jump"))
         {
            i = labels.get(theFunction.getArgAtLine(i,1));
         }
         
         if (firstArg.equals("jumpif"))
         {
            if (regMap.get(theFunction.getArgAtLine(i,2)).getBool() == true)
            {
               i = labels.get(theFunction.getArgAtLine(i,1));
            }
         }
         
         if (firstArg.equals("callfunction"))
         {
            if (theFunction.getArgAtLine(i,1).equals("drawsquare"))
            {
                  float rc = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
                  float gc = regMap.get(theFunction.getArgAtLine(i,4)).getValue();
                  float bc = regMap.get(theFunction.getArgAtLine(i,5)).getValue();
                  float xc = regMap.get(theFunction.getArgAtLine(i,6)).getValue();
                  float yc = regMap.get(theFunction.getArgAtLine(i,7)).getValue();
                  float xsc = regMap.get(theFunction.getArgAtLine(i,8)).getValue();
                  float ysc = regMap.get(theFunction.getArgAtLine(i,9)).getValue();
                  theCanvas.drawRect(rc,gc,bc,xc,yc,xsc,ysc);
            }
            else 
            {
               for (int j = 0; j < functions.size(); j++)//this is for running custom function code
               {
                  if (functions.get(j).getArgAtLine(0,1).equals(theFunction.getArgAtLine(i,1)))
                  {
                     params = new ArrayList<Register>();
                     for (int k = 3; k < theFunction.getArgAmount(i)-1; k++)
                     {  
                        params.add(regMap.get(theFunction.getArgAtLine(i,k)));
                     }
                     if (inFunction == false)
                     {
                        inFunction= true;
                        runPriv(functions.get(j), theCanvas, params);
                     }
                  }
                  
               }
            }
            
         }    
      }
   }

   
   //these are for the time command in the bytecode.
   double startTime;
   public void setStartTime()
   {
      startTime = System.currentTimeMillis();
      
   }
   
   //this method returns the current time as a float.
   public double getTime()
   {
      //System.out.println("test");
      return System.currentTimeMillis() - startTime;
   }
}
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
   
   
   ArrayList<String> globals = new ArrayList<String>();
   
   
   
   ArrayList<ByteLine> functions = new ArrayList<ByteLine>();
   ByteLine commands;
   ArrayList<String> runCommands;
   ArrayList<Register> registers = new ArrayList<Register>();
   
   
   //this method should read in the program file from the file. You may assume the file is in a good format
   public ProjectProgram(String filename)
   {
      try
      {
         File file = new File(filename);
         scan = new Scanner(file);
      
         while (scan.hasNext())
         {
            if (scan.hasNext("function"))
            {
                  //scan.nextLine();
                  ByteLine commands = new ByteLine();
                  while (!scan.hasNext("endfunction"))
                  {
                     //System.out.println(scan.nextLine());
                     commands.addLine(scan.nextLine());//zzzz
                  }
                  //System.out.println(commands.size());
                  //commands.print();
                  functions.add(commands);
                  scan.next();
            
            }
            else if (scan.hasNext("globalfloat"))
            {
               String tempGlobal = scan.nextLine();
               //commands.addLine(tempGlobal);
               //scan.next();
               //globals.add(scan.next());
               int sign = tempGlobal.indexOf('$');
               String sub = tempGlobal.substring(sign);
               System.out.println(sub);
               Register reg = new Register(sub, 0, false);
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
         functions.get(0).print();
         //System.out.println(globals.get(0));
      }
   }
   
   
   
   //this method will only be called once, whenever the program is going to start, right before the first frame.
   public void beginStart()
   {
      for(int i=0;i<globals.size();i++)
      {
         //this creates the globals with the names of globals.get(i) as floats. In my register class, the first arg is the name, the second arg is the value, and the third arg is isBool
         globalMap.put(globals.get(i),new Register(globals.get(i),0,false));
      }
      setStartTime(); //this line of code has to be here.
   }

   //this map stores the global registers
   HashMap<String,Register> globalMap = new HashMap<String,Register>();
   
   //this is part 2
   //this method should run the program that you have stored somewhere else. Each time run is called, it starts with a blank canvas and starts running from the top of the main
   public void run(ProjectCanvas theCanvas)
   {
      
      //commands.run();
      //runs the program here.
      
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
      regMap = new HashMap<String,Register>();
      int i = 0;
      HashMap<String,Integer> labels = new HashMap<String,Integer>();
      
      
      for (i = 0; i < theFunction.size(); i++)
      {
         String firstArg = theFunction.getArgAtLine(i,0);
         
         if (firstArg.equals("print"))
         {
            //System.out.println("test");
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
            registers.add(reg);
         }
         
         if (firstArg.equals("time"))
         {
            //Register reg = new Register(theFunction.getArgAtLine(i,1),(float) getTime(),false);
            //System.out.println(reg.getValue());
            //regMap.put(reg.getName(), reg);
            //registers.add(reg);
            regMap.get(theFunction.getArgAtLine(i,1)).setValue((float) getTime());
         }
         
         if (firstArg.equals("bool"))
         {
            Register reg = new Register(theFunction.getArgAtLine(i,1),0,true);
            regMap.put(reg.getName(), reg);
            registers.add(reg);
         }
         
         if (firstArg.equals("=") && theFunction.getArgAtLine(i,2).startsWith("$"))
         {
            regMap.get(theFunction.getArgAtLine(i,1)).setValue(regMap.get(theFunction.getArgAtLine(i,2)).getValue());
            //System.out.println(regMap.get("$p").getValue());
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
                  System.out.println("testtt");
                  float rc = regMap.get(theFunction.getArgAtLine(i,3)).getValue();
                  float gc = regMap.get(theFunction.getArgAtLine(i,4)).getValue();
                  float bc = regMap.get(theFunction.getArgAtLine(i,5)).getValue();
                  float xc = regMap.get(theFunction.getArgAtLine(i,6)).getValue();
                  float yc = regMap.get(theFunction.getArgAtLine(i,7)).getValue();
                  float xsc = regMap.get(theFunction.getArgAtLine(i,8)).getValue();
                  float ysc = regMap.get(theFunction.getArgAtLine(i,9)).getValue();
                  System.out.println(rc + " " + gc + " " + bc + " " + xc + " " + yc + " " + xsc + " " + ysc);
                  theCanvas.drawRect(rc,gc,bc,xc,yc,xsc,ysc);
            }
            else 
            {
               for (int j = 0; j < functions.size(); j++)
               {
                  if (functions.get(j).getArgAtLine(0,1).equals(theFunction.getArgAtLine(i,1)))
                  {
                     //for ( ) zzzzz
                  
                     runPriv(theFunction, theCanvas, params);
                  }
                  
               }
            }
            
         }
         
         
      }
      
      //System.out.println(regMap.get("$x").getName());
      //System.out.println(regMap.get("$x").getValue());
      //System.out.println(regMap.get("$p").getValue());
      
      
      
   
      /*
	  I'll give you +1 on the assignment if you are the first to find an error in the function code.
	  
            case FUNCTION:
               //note that we create a new regmap for each function.
               regMap = new HashMap<String,ProjectRegister>();
               
               //we then put the global regs into it.
               for(int j=0;j<globals.size();j++)
               {
                  regMap.put(globals.get(j),globalMap.get(globals.get(j)));
               }
               
               //if the function has params, then you get all the registers from the params and stick them into the map too
               if(params != null)
               {
                  for(int j=0;j<params.size();j++)
                  {
                     //theFunction.get(i) is the ith command in the function, .getParamArg(j) gets the jth parameter for the function., 
                     regMap.put(theFunction.get(i).getParamArg(j),params.get(j));
                  }
               }
               
               break;
            case CALLFUNCTION:
               //this draws the square
               //theFunction.get(i) is the ith command in the function, .getArg(0) is the function name
               if(theFunction.get(i).getArg(0).equals("drawsquare"))
               {
                  //pulls each of the 7 arguments from the function call to pass them into canvas's draw
                  float rc = regMap.get(theFunction.get(i).getParamArg(0)).getValue();
                  float gc = regMap.get(theFunction.get(i).getParamArg(1)).getValue();
                  float bc = regMap.get(theFunction.get(i).getParamArg(2)).getValue();
                  float xc = regMap.get(theFunction.get(i).getParamArg(3)).getValue();
                  float yc = regMap.get(theFunction.get(i).getParamArg(4)).getValue();
                  float xsc = regMap.get(theFunction.get(i).getParamArg(5)).getValue();
                  float ysc = regMap.get(theFunction.get(i).getParamArg(6)).getValue();
                  
                  theCanvas.drawRect(rc,gc,bc,xc,yc,xsc,ysc);
                  break;
               }
               else
               {
                  
                  //gets the amount of paramters for the function you are about to call
                  //recall thefunction.get(i) is the functioncall's command
                  int amount = theFunction.get(i).getNumParamsArgs();
                  
                  //create an arraylist to be used to hold the param registers
                  ArrayList<ProjectRegister> registers = new ArrayList<ProjectRegister>();
                  
                  //find all the registers you want to use as params and add them
                  for(int j=0;j<amount;j++)
                  {
                     registers.add(regMap.get(theFunction.get(i).getParamArg(j)));
                  }
                  
                  //this block of code finds the function you want to call within the list of functions
                  for(int k=0;k<functions.size();k++)
                  {
                     //theFunction.get(i).getArg(0) is the name of the function you want to call
                     //functions.get(k) is the kth function
                     //functions.get(k).get(0) is the command "function" for the kth function
                     //functions.get(k).get(0).getArg(0) is the name of the kth function
                     if(functions.get(k).get(0).getArg(0).equals(theFunction.get(i).getArg(0)))
                     {
                        //calls run on itself. Oh, I bet this works with recursive function calls :).
                        runPriv(functions.get(k),theCanvas,registers);
                     }
                  }     
               }
               break;
			*/
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
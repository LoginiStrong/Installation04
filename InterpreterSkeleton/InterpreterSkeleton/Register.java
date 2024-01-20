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


//Class for keeping track of registers and their values with basic accessors and mutators
public class Register
{

   private boolean isBool = false;
   private String name;
   private float value;
   

   public Register(String name, float value, boolean isBool)
   {
      this.value = value;
      this.isBool = isBool;
      this.name = name;
   }

   public boolean getBool()
   {
      return isBool;
   }

   public String getName()
   {
      return name;
   }
   
   public float getValue()
   {
      return value;
   }
   
   public void setValue(float newValue)
   {
      value = newValue;
   }

}
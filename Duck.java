//Duck.java
public class Duck
{
   private int height = 5;
   private double position_x;
  
   //private is good for a variable!
   private double swimmingSpeed;
   
   public Duck(int height_in, double position_x_in, double swimmingSpeed_in)
   {
      height = height_in;
      position_x = position_x_in;
      swimmingSpeed = swimmingSpeed_in;
   }
   
   
   public double foo(double multiplier)
   {
      double fooResult =  height * multiplier; 
      return fooResult;
   }

   public void setPosition(double newPosition)
   {
      position_x = newPosition;
   }
   
   public double getPosition()
   {
      return position_x;
   }
   
   public void swim()
   {
      position_x+=swimmingSpeed;
   }
   


}


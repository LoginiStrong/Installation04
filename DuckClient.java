public class DuckClient
{
   public static void main(String[] args)
   {
      int height = 5;
      double position = 3.2;
      double swimmingSpeed = 1.4; 
   
      Duck myDuck = new Duck(height, position, swimmingSpeed);
      
      myDuck.swim();
      double returnedValue = myDuck.foo(5);
      double duckPosition = myDuck.getPosition();  
      
      System.out.println(duckPosition);
      
      myDuck.setPosition(duckPosition + 2);
      
      System.out.println(myDuck.getPosition());
  
   }

}
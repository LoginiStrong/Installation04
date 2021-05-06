public class Moon
{
   private String name;
   private boolean isGas;
   private double diameter;

   public Moon(String name, boolean isGas, double diameter)
   {
      this.name = name;
      this.isGas = isGas;
      this.diameter = diameter;
   }
   
   public String getName()
   {
      return name;
   }
   public boolean getIfGas()
   {
      return isGas;
   }
   public double getDiameter()
   {
      return diameter;
   }
}
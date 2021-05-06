public class PlanetClient
{
   public static void main(String[] args)
   {
      Planet earth = new Planet("Earth",false,5.5,499);
      Planet psyclo = new Planet("Psychlo",true,100,0);
      Moon phobia = new Planet("Phobia",false,5,0);
      
      Planet mars = new Planet("Mars",true,100,10000);
      
      if(earth.isPopulationEndangered())
      {
         System.out.println("\"Humans,\" said Terl, \"are an endangered species\".");
      }
      if(mars.isPopulationEndangered())
      {
         System.out.println("\"Martians,\" said Terl, \"are an endangered species\".");
      }

      System.out.println("Population of Psychlo is:" + psyclo.getPopulation());
      
      System.out.println(earth);
      System.out.println(psyclo);
      System.out.println(phobia);
      
      Planet earth2 = new Planet("Earth2",false,5.5,499);
      System.out.println(earth.equals(earth2));
      
      Planet psyclo2 = new Planet("Psychlo",true,100,1);
      System.out.println(psyclo.equals(psyclo2));
      
      Planet earth3 = new Planet("Earth",false,5.5,499);
      System.out.println(earth.equals(earth3));
      
      earth.setPopulation(1000);

      System.out.println(earth);
      
   }
}
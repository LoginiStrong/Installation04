import java.util.*;
public class Marble
{
   private float width=0;
   public Marble(float w)
   {
      setWidth(w);
   }
   public void setWidth(float w)
   {
      width = w;
      if(width < 0)
      {
         width = 0;
      }
   }
   public void setWidth(float w, float w2)
   {
      setWidth(w*w2);
   }
   public float getWidth()
   {
      return width;
   }
}

public static void main(String[] args)
{
   Marble blueMarble = new Marble(15);
   System.out.println(blueMarble.getWidth());
   blueMarble.setWidth(10,5);
   System.out.println(blueMarble.getWidth());
   blueMarble.setWidth(5);
   System.out.println(blueMarble.getWidth());
}
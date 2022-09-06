public class Customer
{

private String name;
private int items;

   public Customer (String name, int items)
   {
      this.name = name;
      this.items = items;
   }
   
   public String toString()
   {
      return "Name: "+name+" / Items: "+items;
   }
}
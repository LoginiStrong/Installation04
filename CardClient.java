public class CardClient
{
   public static void main(String [] args)   
   {
      Stack deck = new Stack();
      deck.push(1);
      deck.push(2);
      deck.push(3);
      deck.push(4);
      deck.push(5);
      deck.push(6);
      deck.peek();
      System.out.println(deck);
   }
}
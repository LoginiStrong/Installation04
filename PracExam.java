import java.util.*;
import java.io.*;
import java.text.*;

public class PracExam
{
   public static void main(String[] args)
   {
      Book myBook = new Book(100,"Best of both Worlds");
      Book myOtherBook = new Book(999,"Time's Arrow");
      
      System.out.println("First Book: ");
      System.out.println(myBook);
      System.out.println("Second Book: ");
      System.out.println(myOtherBook);
      
      System.out.println("On book \""+myBook.getTitle()+ "\", how many more pages to 1000 if I added 256?: "+myBook.morePages(256));
      
      TextBook csBook = new TextBook(880, "CLRS", "Algorithms");
      System.out.println(csBook);
      System.out.println("On book \""+csBook.getTitle()+ "\", how many more pages to 1000 if I added 256?: "+csBook.morePages(256));
      
      Book myOtherBookCopyTwo = new Book(881,"Time's Arrow");
      TextBook csBooTwo = new TextBook(882, "Java Book", "CCS1054");
      
      System.out.println(csBook.hasSamePages(myOtherBookCopyTwo));
      System.out.println(csBooTwo.hasSamePages(csBook));
   }
}
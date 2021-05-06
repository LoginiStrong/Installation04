import java.util.*;
import java.io.*;
import java.text.*;

public class Book
{
private int pages;
private String title;

   public Book (int pages, String title)
   {
      this.pages = pages;
      this.title = title;
   }
   
   public int getPgs ()
   {
      return pages;
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public String toString ()
   {
      return title + "with" + pages + "pages";
   }
   
   public int morePages(int addNum)
   {
      pages += addNum;
      return 1000-pages;
   }
   
   public boolean hasSamePages (Object o)
   {
      if (! (o instanceof Book))
      {
         return false;
      }
      else
      {
       Book b = (Book) o;
         if (pages == b.getPgs())
         {
            return true;
         }
      }
      return false;
   }
            
   
}
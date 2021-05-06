public class TextBook extends Book
{
   private int pages;
   private String name;
   private String newClass;
   
   public TextBook (int pages, String name, String bookClass)
   {
      super(pages, name);
      this.newClass = newClass;
   }
   
   
   
}
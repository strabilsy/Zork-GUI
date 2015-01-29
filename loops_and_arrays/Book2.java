package loops_and_arrays;

/**
 * This class is used to model a generic book
 * 
 * @author Rose Williams
 *
 */
public class Book2
{
   //  Instance Variables ----------------------------------------------------//
   /**
    * Title of this book
    */
   private String title;
   
   /**
    * Number of pages in this book
    */
   private int pageCount;
   
   /**
    * Current page being read of this book
    */
   private int bookmark;
   
   /**
    * Whether or not this book is required
    */
   private boolean required;

   //  Constructors ----------------------------------------------------------//
   
   /**
    * Default Constructor
    * Creates unread required lined notebook having 250 pages
    */  
   public Book2()
   {
     this("Lined Notebook", 250, true, 0);
   }
   
   /**
    * Creates unread required book having given title and pageCount
    * 
    * @param title - Title of this book
    * @param pageCount - Number of pages in this book
    */
   public Book2(String title, int pageCount)
   {
      this(title, pageCount, true, 0);
   }
   
   
  /**
   * Explicit parameter constructor
   * 
   * @param title - Title of this book
   * @param pageCount - Number of pages in this book
   * @param bookmark - Current page being read in this book
   * @param required - Whether or not this book is required
   */
   public Book2(String title, int pageCount, boolean required, int bookmark)
   {
      this.title = title;
      this.pageCount = pageCount;
      this.required = required;
      this.bookmark = bookmark;
   }

   //  Predicates ------------------------------------------------------------//
   
   /**
    * Determines if reading of this book is complete
    * @return
    */
   public boolean hasBeenRead()
   {
      return bookmark == pageCount;
   }

   /**
    * Determines if this book is required reading
    * 
    * @return true when required, false otherwise
    */
   public boolean isRequired()
   {
      return required;
   }

   //  Accessors -------------------------------------------------------------//
   /**
    * Returns this book's title
    * 
    * @return title of this book
    */
   public String getTitle()
   {
      return title;
   }

   /**
    * Returns this book's number of pages
    * 
    * @return number of pages in this book
    */
   public int getPageCount()
   {
      return pageCount;
   }

   /**
    * Returns the current page being read in this book
    * @return current page being read
    */
   public int getBookmark()
   {
      return bookmark;
   }

   /**
    * Returns percentage of pages read in this book
    * @return percentage of pagews read in this book
    */
   public double computeCompleted()
   {
     return bookmark / (double)pageCount;
   }

   //  Mutators  -------------------------------------------------------------//
   
   /**
    * Updates this book's current bookmark to new page number
    * @param newPageNumber - Current page being read
    */
   public void setBookmark(int newPageNumber)
   {
      bookmark = newPageNumber;
   }

   //  Overridden Methods from Object ----------------------------------------//
   /**
    * Returns a formatted String version that describes the current state of 
    *   this object
    * @return formatted String describing current state of this object
    */
   public String toString()
   {
      return String.format ("%s, " + 
          "%d total pages, is " + 
          "%srequired, " +
          "currently up to page %d, " +
          "and is %.1f%% completed",
          title, 
          pageCount,
          (isRequired() ? "" : "not "),
          bookmark,
          (computeCompleted() * 100));
   }
   
   
   /** 
    * Tests the basic methods of the Book2 class
    * @param args - unused
    */
   public static void main(String[] args)
   {
     // Create a Book2 object using default constructor
     Book2 book1 = new Book2();
     System.out.println(book1);
     System.out.println();
     
     // Create a Book2 object using 2-parameter constructor
     // Show % completed, then update bookmard and show again
     Book2 book2 = new Book2("Java, Java!", 1100);
     System.out.println(book2);
     System.out.println(book2.computeCompleted());
     book2.setBookmark(500);
     System.out.println(book2.getTitle());
     System.out.println(book2.getBookmark());
     System.out.println(book2.getPageCount());
     System.out.println(book2.computeCompleted());
     System.out.println(book2.hasBeenRead());
     System.out.println(book2.isRequired());
     System.out.println(book2);
     System.out.println();
     
     // Create a Book2 object using explicit value constructor
     // Book is initialized to "hasBeenRead()" state at creation
     // Show % completed
     Book2 book3 = new Book2("How to Apply for a Job at Aperture Science", 5, false, 5);  
     System.out.println(book3);
     System.out.println(book3.getTitle());
     System.out.println(book3.getBookmark());
     System.out.println(book3.getPageCount());
     System.out.println(book3.computeCompleted());
     System.out.println(book3.hasBeenRead());
     System.out.println(book3.isRequired());
     System.out.println(book3);
   }
}
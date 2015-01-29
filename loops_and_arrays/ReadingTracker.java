package loops_and_arrays;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.Scanner;
public class ReadingTracker
{
  /**
   * @author Victor Oza
   * lab Section B55
   * @param none
   * Reads file books.txt
   * @return book
   * @throws FileNotFoundException
   */
  private Book2[] bookFileReader() 
      throws FileNotFoundException
      {
  File file = new File("books.txt");
  Scanner input = new Scanner(file);
  int count = 0;
  while (input.hasNextLine() && input.nextLine().length() > 0)
  {
    count++;
  }
  input.close();
  Book2[] books = new Book2[count];
  input = new Scanner(file);
  for(int i = 0; i < books.length; i++)
  {
    String line = input.nextLine();
    String[ ] parts = line.split("\t");
    String title = parts[0];
    int numPgs = Integer.parseInt(parts[1]);
    boolean req = Boolean.parseBoolean(parts[2]);
    int bookmark = Integer.parseInt(parts[3]);
    books[i] = new Book2(title,numPgs,req,bookmark);
  }
  input.close();
  return books;
      }
  /**
   * Writes over books.txt with new bookmark positions
   * @param books
   * @throws FileNotFoundException
   */
  private void writeBookFile(Book2[ ] books) 
      throws FileNotFoundException 
    { 
      File outfile = new File("books.txt"); 
      PrintWriter output = new PrintWriter(outfile); 
      for(Book2 book : books) 
      {
        output.println(book.getTitle() + "\t" + 
                       book.getPageCount() + "\t" + 
                       book.isRequired() + "\t" +  
                       book.getBookmark()); 
      } 
      output.close(); 
    } 
  /**
   * Updates the book page
   * @throws FileNotFoundException
   */
  public void updateReadings() throws FileNotFoundException
  {
    Book2[ ] books = bookFileReader(); 
    for(Book2 book : books)
    {
      checkCurrentPage(book); 
    } 
    writeBookFile(books); 
  } 
  /**
   * Sets the bookmarks
   * @param book
   */
  private void checkCurrentPage(Book2 book)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("For the book " + book.getTitle());
    boolean inputOK = false;
    while(!inputOK)
    {
      System.out.println("What page have you reached?");
      String line = keyboard.nextLine();
      Scanner lineAnalyzer = new Scanner(line);
      if (lineAnalyzer.hasNextInt())
      {
        int newPage = lineAnalyzer.nextInt();
        if(newPage < 1 || newPage > book.getPageCount())
        {
         System.out.println("There is no such page");
        }
        else if (newPage < book.getBookmark())
        {
          System.out.println("The bookmark is being moved");
          book.setBookmark(newPage);
          inputOK = true;
        }
        else
        {
          book.setBookmark(newPage);
          inputOK = true;
        }
      }
        else
        {
          System.out.println("User didn't enter a number");
        }
      }
    }
  }
package testers;

import players.*;
import repository.*;
import utility.*;

public class HumanNamesTester
{
  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    SingleRandom.getInstance().setSeed(13);
    HumanNames namesSingleton = HumanNames.getInstance();
    System.out.println(namesSingleton.toString());
    
    int MaxNum = namesSingleton.getMaxNamesToStart();
    System.out.println("\nMax Number of Names to Start:  " + MaxNum);
    System.out.println("There are more names:  " + namesSingleton.hasNames());
    for (int i=0; i<MaxNum; i++)  
      System.out.println("\n" + new Human().toString());
    
    System.out.println("\nThere are more names:  " + namesSingleton.hasNames());
    
    namesSingleton.resetNames();
    System.out.println("\nAfter reset, there are more names: " + 
      namesSingleton.hasNames());
    System.out.println("Note identity of first, middle, and last names in " +
    	"order to verify last two tests");
    String nameFirst = namesSingleton.getName(0);
    String nameMid = 
      namesSingleton.getName(namesSingleton.getCurrentNumberOfNames()/2);
    String nameLast = 
      namesSingleton.getName(namesSingleton.getCurrentNumberOfNames()-1);
    System.out.println("Current size is:  " + 
      namesSingleton.getCurrentNumberOfNames());
    System.out.println("\nFirst Name is: " + nameFirst + 
      ", at index:  " + namesSingleton.findName(nameFirst) + 
      ", has name:  " + namesSingleton.hasName(nameFirst));
    System.out.println("Middle Name is: " + nameMid + 
        ", at index:  " + namesSingleton.findName(nameMid) + 
        ", has name:  " + namesSingleton.hasName(nameMid));
    System.out.println("Last Name is: " + nameLast + 
        ", at index:  " + namesSingleton.findName(nameLast) + 
        ", has name:  " + namesSingleton.hasName(nameLast));
    
    namesSingleton.addName("Jack");
    namesSingleton.addName("Jill");
   
    int newSize = namesSingleton.getCurrentNumberOfNames();
    System.out.println(
      "\nAfter adding two names, current number of names is:  " + newSize);
    System.out.println(namesSingleton.toString());
    for (int i=0; i<newSize; i++)  
      System.out.println("\n" + new Human().toString());
    
    System.out.println("\nThere are more names:  " + namesSingleton.hasNames());
    
    namesSingleton.resetNames();
    System.out.println(
      "\nAfter reset, there are more names: " + namesSingleton.hasNames());
    System.out.println(namesSingleton.toString());
    
    namesSingleton.eraseNames();
    System.out.println(
      "\nAfter erasing, there are more names: " + namesSingleton.hasNames());
    
    namesSingleton.resetNames();
    System.out.println(
      "\nAfter reset, there are more names: " + namesSingleton.hasNames());
    
    namesSingleton.replaceName(0, "Jack");
    namesSingleton.replaceName(nameMid, "Jill");
    namesSingleton.replaceName(nameLast, "The End");
    //Show that the old names that were replaced are gone
    System.out.println("\nAfter Replacing:\nIs first name in list?  " + 
      namesSingleton.hasName(nameFirst));
    System.out.println("Is middle name in list?  " + 
      namesSingleton.hasName(nameMid));    
    System.out.println("Is last name in list?  " + 
      namesSingleton.hasName(nameLast)); 
    System.out.println("Show that old names have been replaced with new names");
    System.out.println("Is Jack in list?  " + namesSingleton.hasName("Jack"));
    System.out.println("Is Jill in list?  " + namesSingleton.hasName("Jill"));
    System.out.println("Is The End in list?  " + 
      namesSingleton.hasName("The End"));
    System.out.println(namesSingleton.toString());
    
    namesSingleton.eraseNames();
    System.out.println("\nAfter erasing, there are more names: " + 
      namesSingleton.hasNames());
    System.out.println();
    System.out.println("*****  New Part:  *****");  
    System.out.println("Show that names are automatically reset when no " +
    		"more in list\n");
    for (int i=0; i<2 * MaxNum; i++)  
      System.out.println("\n" + new Human()); 
  }
}
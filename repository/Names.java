package repository;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import utility.SingleRandom;
import java.util.List;
import utility.SingleRandom;

/**
 * 
 * @author Victor Oza Lab section B55 Assignment 3
 * 
 *         This class implements a repository of names for the Gruman class
 */
public class Names
// implements Serializable
{
	private final String[] NAMES;
	private final int MAX_NAMES_TO_START;
	// private final static long serialVersionUID;
	// static
	// {
	// serialVersionUID =
	// ObjectStreamClass.lookup(Names.class).getSerialVersionUID();
	// }
	private ArrayList<String> names;

	/**
	 * default constructor
	 */
	public Names(String[] array)
	{
		names = new ArrayList<String>();
		names.addAll(Arrays.asList(array));
		NAMES = array;
		MAX_NAMES_TO_START = array.length;
	}

	/**
	 * Used to return length of array
	 * 
	 * @return GRUMAN_NAMES.length gives length of array
	 */
	public int getMaxNamesToStart()
	{
		return MAX_NAMES_TO_START;
	}

	/**
	 * size of arraylist
	 * 
	 * @return arraylist size
	 */
	public int getCurrentNumberOfNames()
	{
		return names.size();
	}

	/**
	 * gets the name
	 * 
	 * @param index
	 *            value of the index
	 * @return string value in arraylist at given index
	 */
	public String getName(int index)
	{
		return names.get(index);
	}

	/**
	 * finds name
	 * 
	 * @param nameToFind
	 *            string to find
	 * @return gives index of string
	 */
	public int findName(String nameToFind)
	{
		return names.indexOf(nameToFind);
	}

	/**
	 * checks if string is present
	 * 
	 * @param nameToFind
	 *            string to find
	 * @return true is string present
	 */
	public boolean hasName(String nameToFind)
	{
		return names.contains(nameToFind);
	}

	/**
	 * check if arraylist is empty
	 * 
	 * @return true is there are names
	 */
	public boolean hasNames()
	{
		return !names.isEmpty();
	}

	/**
	 * take a name, and if empty reset the names
	 * 
	 * @return a name in the arraylist which is removed
	 */
	public String takeNames()
	{
		if (names.isEmpty())
		{
			resetNames();
		}
		return names.remove(SingleRandom.getInstance().nextInt(names.size()));
	}

	/**
	 * adds a name
	 * 
	 * @param nameToAdd
	 *            name is added to arraylist
	 */
	public void addName(String nameToAdd)
	{
		names.add(nameToAdd);
	}

	/**
	 * replace name in list
	 * 
	 * @param nameToRemove
	 *            string to replace
	 * @param nameToReplace
	 *            string that will be inserted
	 */
	public void replaceName(String nameToRemove, String nameToReplace)
	{
		names.set(findName(nameToRemove), nameToReplace);
	}

	/**
	 * replace by index
	 * 
	 * @param index
	 *            index at which to replace name
	 * @param nameToReplace
	 *            name that will be switched
	 */
	public void replaceName(int index, String nameToReplace)
	{
		names.set(index, nameToReplace);
	}

	/**
	 * clears the arraylist
	 */
	public void eraseNames()
	{
		names.clear();
	}

	/**
	 * reset the names in arraylist to the original array
	 */
	public void resetNames()
	{
		names.clear();
		names.addAll(Arrays.asList(NAMES));
	}

	/**
	 * to string method
	 * 
	 * @return string representation
	 */
	public String toString()
	{
		return getClass().getName().toString();
	}

}

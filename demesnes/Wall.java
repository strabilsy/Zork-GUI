package demesnes;

/**
 * Wall enum
 * @author Victor Oza
 * Lab section B55
 */
public enum Wall
{
	BLANK
	{
		@Override
		public boolean hasDoor()
		{
			return false;
		}
	},	
	DOOR
	{
		@Override
		public boolean hasDoor()
		{
			return true;
		}
	};
	/**
	 * abstract for hasDoor()
	 * @return boolean
	 */
	public abstract boolean hasDoor();
	
	/**
	 * toString override
	 * return toString representation
	 */
	public String toString()
  {
	  String name = name();
	  return name.toLowerCase();  
  }
}



public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private static int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
        }
		numberOfEntries = 0;
		T[] temp = (T[]) new Object[desiredCapacity];
		bag = temp;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
		if(numberOfEntries > 0)
			return false;
		else
			return true;
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
		try
		{
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal.
     * was successful, or null.
     */
    public T remove() {
		try{
        T tempElement = bag[numberOfEntries - 1];
		--numberOfEntries;
		bag[numberOfEntries] = null;
		return tempElement;
		}
		catch(Exception e)
		{
			return null;
		}
		
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
		try{
			for(int i = 0; i < numberOfEntries; ++i)
			{
				if(anEntry.equals(bag[i]))
				{
					--numberOfEntries;
					bag[i] = null;
				}
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
		while(!isEmpty()){
			bag[numberOfEntries-1] = null;
			--numberOfEntries;
		}
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
		for(int i = 0; i < numberOfEntries; ++i)
			if(anEntry.equals(bag[i]))
				frequency++;
		return frequency;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        for(int i = 0; i < numberOfEntries; ++i)
				if(anEntry.equals(bag[i]))
					return true;
			return false;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        T[] temp = (T[]) new Object[numberOfEntries];
		for(int i = 0; i < numberOfEntries; ++i)
			temp[i] = bag[i];
		return temp;
    }
}

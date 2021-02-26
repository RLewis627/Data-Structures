public class HashSetQP<T> implements HashSetInterface<T>
{
	private int arrayCounter;
	private T[] internalArray = (T[]) new Object[157];
		
	public int size(){return arrayCounter;}
		
    public boolean isEmpty(){return arrayCounter == 0;}
		
    public boolean contains(T item){return get(item) != null;}
		
    public T[] toArray()
	{
		T[] tempArray = (T[]) new Object[157];
		for(int i = 0; i < arrayCounter; i++)
		{
			if(internalArray[i] != null)
				tempArray[i] = internalArray[i];
		}
		return tempArray;
	}
		
    public boolean add(T item)
	{
		int objHash = hash(item);
		int index = objHash;
		int h = 1;
		do
		{
			if(internalArray[index] == null)
			{
				internalArray[index] = item;
				arrayCounter++;
				return true;
			}
			if(internalArray[index].equals(item))
				return true;
			index = (index + h * h++) % 157;
		}while(index != objHash && h <= 31);
		return false;
	}
		
    public T remove(T item)
	{
		if(!contains(item))
			return null;
		int index = hash(item);
		int h = 1;
		while(!item.equals(internalArray[index]) && h <= 31)
		{
			index = (index + h * h++) % 157;
		}
		T temp = internalArray[index];
		internalArray[index] = null;
		arrayCounter--;
		return temp;
	}
		
    public void clear()
	{
		internalArray = (T[]) new Object[157];
		arrayCounter = 0;
	}
	/*This point onwards is helper methods */
	public T get(T item)
	{
		int index = hash(item);
		int h = 1;
		while(internalArray[index] != null)
		{
			if(internalArray[index].equals(item))
				return item;
			index = (index + h * h++) % 157;
		}
		return null;
	}
	
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		return false;
	}
		
	public int hashCode(int I){return I;}
	
	public int hashCode(char C){return (int)C;}
		
	public int hashCode(long L){return (int)(L>>>32)+((int)L);}
		
	public int hashCode(double D)
	{
		long L = Double.doubleToLongBits(D);
		return hashCode(L);
	}
		
	public int hashCode(String S)
	{
		int hash = 0;
		for(int i = 0; i < S.length(); i++)
			hash = 31 * hash + S.charAt(i);
		return hash;
	}
		
	public int hashCode(T t) 
	{
    	final int prime = 31;
    	int result = 1;
		result = prime * result + (t != null ? t.hashCode() : 0);
   	 	return result;
	}
		
	public int hash(T item){return hashCode(item) % 157;}
}
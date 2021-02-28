import java.util.Arrays;

public class ArrayMaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
	private int resizeCount = 2;
	private int arraySize = 157;
	private T[] internalArray = (T[]) new Comparable[arraySize];
	private int arrayCounter = 1;
	
	public void add(T newEntry)
	{
		if(arrayCounter == arraySize)
		{
			this.internalArray = Arrays.copyOf(this.internalArray,arrayCounter*2);
		}
		internalArray[arrayCounter] = newEntry;
		arrayCounter++;
		maxUpHeap(arrayCounter-1);
	}

   public T removeMax()
   {
	   if(arrayCounter == 0)
		   return null;
	   T temp = internalArray[0];
	   internalArray[0] = internalArray[arrayCounter-1];
	   internalArray[arrayCounter-1] = null;
	   arrayCounter--;
	   maxHeapify(0);
	   return temp;
   }
   
   public T getMax()
   {
	   if(arrayCounter ==0)
		   return null;
	   return (T) internalArray[0];
   }
   
   public boolean isEmpty()
   {
	   boolean flag = false;
	   if(arrayCounter == 0)
		   flag = true;
	   return flag;
   }

   public int getSize()
   {
	   return arrayCounter;
   }

   public void clear()
   {
	   internalArray = (T[]) new Comparable[arraySize];
	   arrayCounter = 0;
   }
   
   private void maxHeapify(int i)
   {
	   int child;
	   T temp = internalArray[i];
	   while(kthChild(i, 1) < arrayCounter)
	   {
		   child = maxChild(i);
		   if(temp.compareTo(internalArray[child]) < 0)
		   {
			   internalArray[i] = internalArray[child];
		   }
		   i = child;
	   }
	   internalArray[i] = temp;
   }
   
   public void maxUpHeap(int i)
   {
	   int p = (i-1)/2;
	   T child = internalArray[i];
	   T parent = internalArray[p];
	   
	   while(i > 0 && child.compareTo(parent) < 0)
	   {
			internalArray[i] = parent;
			i = p;
	   }
	   internalArray[i] = child;
   }
   
    private int kthChild(int i, int k)
	{
		return 2*i + k;
	}
	
	private int maxChild(int i)
	{
		int leftChild = kthChild(i,1);
		int rightChild = kthChild(i,2);
		return (internalArray[leftChild]).compareTo(internalArray[rightChild]);
	}
	
   public void printHeap()
   {
	   System.out.print("\nHeap = ");
        for (int i = 0; i < arrayCounter; i++)
            System.out.print(internalArray[i] +" ");
        System.out.println();
   }
}
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T >
{
	private MaxHeapInterface internalHeap = new ArrayMaxHeap();
	
	public void add(T newEntry)
	{
		internalHeap.add(newEntry);
	}
	
   public T remove()
   {
	  return (T) internalHeap.removeMax();
   }
   
   public T peek()
   {
	  return (T) internalHeap.getMax();
   }
   
   public boolean isEmpty()
   {
	   return internalHeap.isEmpty();
   }
   
   public int getSize()
   {
	   return internalHeap.getSize();
   }
   public void clear()
   {
	   internalHeap.clear();
   }
}
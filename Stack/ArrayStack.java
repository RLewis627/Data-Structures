public class ArrayStack<T> implements StackInterface<T>{
	private static int nextElement;
	private T[] Stack;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayStack(int desiredCapacity)
	{
			if(desiredCapacity > MAX_CAPACITY)
			{
				throw new IllegalStateException("Your array size is too big!");
			}
		T[] temp = (T[]) new Object[desiredCapacity];
		Stack = temp;
	}
	
   public void push(T newEntry)
	 {
		 Stack[nextElement] = newEntry;
		 nextElement++;
	 }
  
   public T pop()
	 {
		 try{
		 if(isEmpty())
		 {
				throw new EmptyStackException();
		 }
			else
			{
				T returnElement = Stack[--nextElement];
				Stack[nextElement] = null;
				return returnElement;
			}
		 }catch(EmptyStackException e){
			 System.out.println("You can't pop anything off an empty stack!");
			 return null;
		 }
	 }
  
   public T peek()
	 {
		 try{
		 if(isEmpty())
		 {
				throw new EmptyStackException();
		 }
			else
		 {
			 return Stack[nextElement-1];
		 }
		 }catch(EmptyStackException e){
			 System.out.println("You can't peek on an empty stack!");
			 return null;
		 }
	 }
  
   public boolean isEmpty()
	 {
		 return (nextElement==0);
	 }
  
   public void clear()
	 {
		 while(!isEmpty())
		 {
				pop();
		 }
	}
}
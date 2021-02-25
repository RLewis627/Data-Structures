 public class LinkedStack<T> implements StackInterface<T>
{
    private static final int MAX_CAPACITY = 10000;
		private Node head;
		private int counter;
	
    public LinkedStack() 
		{
      head = null;
			counter = 0;
    }
	
    public void push(T newEntry) 
		{
		if(counter < MAX_CAPACITY)
		 {
			 head = new Node(newEntry, head);
			 counter++;
		 }
    }

    public T pop() 
		{
      try
			{
				if(isEmpty())
					throw new EmptyStackException();
				else
				{
					Node temp = head;
					head = head.next;
					temp.next = null;
					counter--;
					return temp.item;
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
				return (T) head;
				}
			}catch(EmptyStackException e){
		 		System.out.println("You can't peek on an empty stack!");
		 		return null;
			}
    }
	 
    public boolean isEmpty() 
		{
      return (head==null);
    }
	 
	 public void clear()
	{
		while(!isEmpty())
			pop();
	}
	 
	 private class Node
	{
		private T item;
		private Node next;

		private Node(T item)
		{
			this(item, null);
		}
	
	private Node(T item, Node next)
	{
		this.item = item;
		this.next = next;
	}
}
}

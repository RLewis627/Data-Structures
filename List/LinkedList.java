public class LinkedList<T> implements ListInterface<T>
{
	private Node head;
	private int counter = 0;
	
	public void add(T newEntry)
	{
		Node temp = head;
		if(isEmpty())
		{
			head = new Node(newEntry, null);
			counter++;
		}
		while(temp != null && temp.next != null) 
		{
           temp = temp.next;
		}
		if(temp != null)
		{
			temp.next = new Node(newEntry, null);
			counter++;
		}
	}
	
	public void add(int newPosition, T newEntry)
	{
		Node item = new Node(newEntry, null);
		Node temp = head;
		if(newPosition < 1 || newPosition > getLength() + 1)
		{
			throw new IndexOutOfBoundsException("Index is out of bounds!");
		}
		if (newPosition == 1)
		{
			head = new Node(newEntry, temp);
			counter++;
		}
		else
		{
			for (int i = 1; temp != null && i < newPosition-1; i++) 
			{
				temp = temp.next;
			}
			item.next = temp.next;
			temp.next = item;
			counter++;
		}
	}
	
	public T remove(int givenPosition)
	{
		if(givenPosition < 1 || givenPosition > getLength())
		{
			throw new IndexOutOfBoundsException("Index is out of bounds!");
		}
		if (givenPosition == 1) 
        { 
			T thisNode = (T) head.data;
            head = head.next;
			counter--;
            return thisNode; 
        }
		else
		{
			Node temp = head;
			for (int i = 1; temp!=null && i < givenPosition-1; i++) 
				temp = temp.next;
			T thisNode = (T) temp.next.data;
			temp.next = temp.next.next;
			counter--;
			return thisNode;
		}
	}
	
	public void clear()
	{
		head = null;
		counter = 0;
	}
	
	public T replace(int givenPosition, T newEntry)
	{
		if(givenPosition < 1 || givenPosition > getLength())
		{
			throw new IndexOutOfBoundsException("Index is out of bounds!");
		}
		if (givenPosition == 1) 
        { 
			T thisNode = (T) head.data;
            head.data = newEntry;
            return thisNode; 
        }
		else
		{
		Node temp = head;
		for (int i = 1; temp!=null && i < givenPosition-1; i++) 
			temp = temp.next;
		T thisNode = (T) temp.next.data;
		temp.next.data = newEntry;
		return thisNode;
		}
	}
	
	public T getEntry(int givenPosition)
	{
		if(givenPosition < 1 || givenPosition > getLength())
		{
			throw new IndexOutOfBoundsException("Index is out of bounds!");
		}
		if (givenPosition == 1) 
        { 
            return (T) head.data; 
        }
		else
		{
		Node temp = head;
		for (int i = 1; temp!=null && i < givenPosition; i++) 
			temp = temp.next;
		return (T) temp.data;
		}
	}
	
	public boolean contains(T anEntry)
	{
		Node temp = head;
		for(int i = 1; temp != null && i < counter; i++)
		{
			if(temp.data == anEntry)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public int getLength()
	{
		if(isEmpty())
			return 0;
		return counter;
	}
	
	public boolean isEmpty()
	{
		if(counter == 0 || head == null)
			return true;
		return false;
	}
	
	private static class Node<T>
	{
     private T data;
     private Node<T> next;

     public Node(T data, Node<T> next)
     {
		this.data = data;
        this.next = next;
     }
	}
}
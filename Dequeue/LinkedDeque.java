public class LinkedDeque<T> implements DequeInterface<T>
{
	private Node head;
	private Node tail;
	private int counter = 0;
	
	public void addToFront(T newEntry)
	{
		Node temp = new Node(newEntry);
		temp.next = head;
		if(head != null)
			head.prev = temp;
		if(head == null)
			tail = temp;
		head = temp;
		counter++;
	}
	
	public void addToBack(T newEntry)
	{
		Node temp = new Node(newEntry);
		temp.prev = tail;
		if(tail != null)
			tail.next = temp;
		if(tail == null)
			head = temp;
		tail = temp;
		counter++;
	}
	
	public T removeFront()
	{
		if(isEmpty()){throw new EmptyStackException();}
		Node temp= head.next;
        if(temp != null) 
		{
			T thisNode = (T) temp.prev.data;
			temp.prev = null;
			head = temp;
			counter--;
			return thisNode;
		}
        else
		{
			T thisNode = (T) tail.data;
			tail = null;
			head = temp;
			counter--;
			return thisNode;
		}
	}
	
	public T removeBack()
	{
		if(isEmpty()){throw new EmptyStackException();}
		Node temp= tail.prev;
        if(temp != null) 
		{
			T thisNode = (T) temp.next.data;
			temp.next = null;
			tail = temp;
			counter--;
			return thisNode;
		}
        else
		{
			T thisNode = (T) head.data;
			head = null;
			tail = temp;
			counter--;
			return thisNode;
		}
	}
	
	public T getFront()
	{
		if(isEmpty()){throw new EmptyStackException();}
		return (T) head.data;
	}

	public T getBack()
	{
		if(isEmpty()){throw new  EmptyStackException();}
		return (T) tail.data;
	}
	
	public boolean isEmpty()
	{
		if(counter == 0 || head == null)
			return true;
		return false;
	}

	public void clear()
	{
		head = null;
		tail = null;
		counter = 0;
	}

	private static class Node<T>
	{
     private T data;
     private Node<T> next;
	 private Node<T> prev;

     public Node(T data)
     {
		this.data = data;
        this.next = next;
     }
	}
}
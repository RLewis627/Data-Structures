import java.util.*;
import java.lang.*;

public class PriorityQueueInterfaceTest<T extends Comparable<? super T>> //Test implementation of PriorityQueueInterface
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PriorityQueueInterface myQueue = new HeapPriorityQueue();
		char ch;
        do    
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. add ");
            System.out.println("2. remove");
            System.out.println("3. peek");            
            System.out.println("4. isEmpty");
            System.out.println("5. getSize");
			System.out.println("6. clear");
 
            int choice = sc.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    System.out.println("Enter String element to insert");
                    myQueue.add( sc.next() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;                          
            case 2 : 
                System.out.println("Highest Priority Element Removed : "+ myQueue.remove());               
                break;                                
            case 3 : 
                System.out.println("Highest Priority Element: "+ myQueue.peek()); 
                break;                                   
            case 4 : 
				if(myQueue.isEmpty())
					System.out.println("Queue is Empty");
				else
					System.out.println("Queue is Filled");
                break; 
            case 5 : 
                System.out.println("Queue's size is: "+myQueue.getSize());
                break;
			case 6 : 
                myQueue.clear();
                System.out.println("Queue Cleared\n");
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
		sc.close();
	}
}

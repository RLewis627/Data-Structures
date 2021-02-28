import java.util.*;
import java.lang.*;

public class MaxHeapInterfaceTest<T extends Comparable<? super T>> //Test implementation of MaxHeapInterface
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		MaxHeapInterface myHeap = new ArrayMaxHeap();
		char ch;
        do    
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. add ");
            System.out.println("2. removeMax");
            System.out.println("3. getMax");            
            System.out.println("4. isEmpty");
            System.out.println("5. getSize");
			System.out.println("6. clear");
 
            int choice = sc.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    System.out.println("Enter integer element to insert");
                    myHeap.add( sc.nextInt() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;                          
            case 2 : 
                System.out.println("Max Element Removed : "+ myHeap.removeMax());               
                break;                                
            case 3 : 
                System.out.println("Current Max Element: "+ myHeap.getMax()); 
                break;                                   
            case 4 : 
				if(myHeap.isEmpty())
					System.out.println("Heap is Empty");
				else
					System.out.println("Heap is Filled");
                break; 
            case 5 : 
                System.out.println("Heap's size is: "+myHeap.getSize());
                break;
			case 6 : 
                myHeap.clear();
                System.out.println("Heap Cleared\n");
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display heap **/
            myHeap.printHeap();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
		sc.close();
	}
}
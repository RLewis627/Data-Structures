import java.util.*;

public class DequeDriver
{
	static Scanner sc = new Scanner(System.in);
	static LinkedDeque list = new LinkedDeque();
	
	public static void main(String[] args)
	{	
		do
		{
			int choice = menu();
			if(choice == 1)
			{
				System.out.printf("Enter an item: ");
				int item = sc.nextInt();
				list.addToFront(item);
			}
			if(choice == 2)
			{
				System.out.printf("Enter an item: ");
				int item = sc.nextInt();
				list.addToBack(item);
			}
			if(choice == 3)
			{
				int returnItem = (int) list.removeFront();
				System.out.println("You removed "+returnItem+" from the front");
			}
			if(choice == 4)
			{
				int returnItem = (int) list.removeBack();
				System.out.println("You removed "+returnItem+" from the back");
			}
			if(choice == 5)
			{
				int returnItem = (int) list.getFront();
				System.out.println("The front of the list is: "+returnItem);
			}
			if(choice == 6)
			{
				int returnItem = (int) list.getBack();
				System.out.println("The back of the list is: "+returnItem);
			}
			if(choice == 7)
			{
				if(list.isEmpty())
					System.out.println("The list is empty");
				else
					System.out.println("The list is filled");
			}
			if(choice == 8)
			{
				list.clear();
			}
		}while(menu() != 0);
		
	}
	
	public static int menu()
	{
		list.printList();
		System.out.println();
		System.out.println("1 - Add to front");
		System.out.println("2 - Add to back");
		System.out.println("3 - Remove from front");
		System.out.println("4 - Remove from back");
		System.out.println("5 - Get front");
		System.out.println("6 - Get back");
		System.out.println("7 - IsEmpty");
		System.out.println("8 - Clear");
		System.out.println();
		int choice = sc.nextInt();
		return choice;
	}
}
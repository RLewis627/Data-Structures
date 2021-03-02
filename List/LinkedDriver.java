import java.util.*;

public class LinkedDriver
{
	static Scanner sc = new Scanner(System.in);
	static LinkedList list = new LinkedList();
	
	public static void main(String[] args)
	{	
		do
		{
			int choice = menu();
			if(choice == 1)
			{
				System.out.printf("Enter an item: ");
				int item = sc.nextInt();
				list.add(item);
			}
			if(choice == 2)
			{
				System.out.printf("Enter an item: ");
				int item = sc.nextInt();
				System.out.printf("Enter a position: ");
				int pos = sc.nextInt();
				list.add(pos, item);
			}
			if(choice == 3)
			{
				System.out.printf("Enter a position: ");
				int pos = sc.nextInt();
				int item = (int) list.remove(pos);
				System.out.println("You removed "+item+" from the list");
			}
			if(choice == 4)
			{
				list.clear();
				System.out.printf("List has been cleared");
			}
			if(choice == 5)
			{
				System.out.printf("Enter an item: ");
				int item = sc.nextInt();
				System.out.printf("Enter a position: ");
				int pos = sc.nextInt();
				int replacedItem = (int) list.replace(pos, item);
				System.out.println("You removed "+replacedItem+" from the list");
			}
			if(choice == 6)
			{
				System.out.printf("Enter a position: ");
				int pos = sc.nextInt();
				int item = (int) list.getEntry(pos);
				System.out.printf("The item at position "+pos+" is "+item);
			}
			if(choice == 7)
			{
				System.out.printf("Enter an item: ");
				int item = sc.nextInt();
				if(list.contains(item))
					System.out.println("The list has that item");
				else
					System.out.println("The list doesn't have that item");
			}
			if(choice == 8)
			{
				System.out.println("The list's lize is: "+list.getLength());
			}
			if(choice == 9)
			{
				if(list.isEmpty())
					System.out.println("The list is empty");
				else
					System.out.println("The list is filled");
			}
		}while(menu() != 0);
		
	}
	
	public static int menu()
	{
		list.printList();
		System.out.println();
		System.out.println("1 - Add");
		System.out.println("2 - Add at a certain position");
		System.out.println("3 - Remove");
		System.out.println("4 - Clear");
		System.out.println("5 - Replace");
		System.out.println("6 - Get Entry");
		System.out.println("7 - Contains");
		System.out.println("8 - Length");
		System.out.println("9 - isEmpty");
		System.out.println();
		int choice = sc.nextInt();
		return choice;
	}
}
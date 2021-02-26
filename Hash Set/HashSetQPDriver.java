import java.util.Scanner;

public class HashSetQPDriver
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		HashSetQP myHash = new HashSetQP();
		do    
        {
            System.out.println("1. size ");
            System.out.println("2. is empty");
            System.out.println("3. contains");            
            System.out.println("4. add");
            System.out.println("5. remove");
			System.out.println("6. clear");
			System.out.println("7. toArray");
			System.out.println();
            int choice = scan.nextInt();            
            switch (choice)
            {
				case 1 : 
					System.out.println("The hash's size is: "+myHash.size());
					break;                          
				case 2 :                 
					if(myHash.isEmpty())
						System.out.println("The hash is empty");
					else
						System.out.println("The hash is not empty");
					break;                        
				case 3 : 
					System.out.printf("Enter value: ");
					char value1 = scan.next().charAt(0);
					if(myHash.contains(value1))
						System.out.println("It contains that value");
					else
						System.out.println("It doens't contain that value");
					break;                                   
				case 4 : 
					System.out.printf("Enter value: ");
					char value2 = scan.next().charAt(0);
					if(myHash.add(value2))
						System.out.println("Addition successful");
					else
						System.out.println("Addition not successful");
					break;
				case 5 : 
					System.out.println("Enter value:");
					char value3 = scan.next().charAt(0);
					if(myHash.remove(value3) == null)
						System.out.println("Removal not successful");
					else
					{
						System.out.println("Removal successful.");
					}
					break;
				case 6 :
					myHash.clear();
					break;
				default : 
					System.out.println("Wrong Entry \n ");
					break;   
            }  
        }while (scan.nextInt() != 0);
	}
}
import java.util.List;
import java.util.Scanner;

import controller.CastHelper;
import model.Cast;

/**
 * @author  Andrew Steele aeste - aesteele
 * CIS175 - Fall 2021
 * Jan 27, 2023
 */
public class RunProgram {

	static Scanner in = new Scanner(System.in);
	static CastHelper ch = new CastHelper();
	/*
	 * @ void prompt user for input for each variable in the object
	 * create a new object 
	 * call the add cast function
	 */
	private static void addNewCast()
	{
		//variables
		System.out.println("Enter the characters name: ");
		String character = in.nextLine();
		System.out.println("Enter the characters rank: ");
		String rank = in.nextLine();
		System.out.println("Enter the actors name: ");
		String actor = in.nextLine();
		
		Cast input = new Cast(character, rank, actor);
		ch.addCast(input);
	}
	/*
	 * @ void prompt user to  enter the character name or the actor name then if found
	 * ask the user which attribute they would like to edit, set the new value to the object 
	 * call the update function to update the database
	 */
	private static void editCurrentCast()
	{
		boolean loopContinue = true;
		System.out.println("------ Edit Character ------");
		System.out.println("1) -- Search by actors name");
		System.out.println("2) -- Search by character name");
		int choice = in.nextInt();
		in.nextLine();
		List<Cast> foundList;
		Cast found;
		while (loopContinue == true)
		{
			switch(choice)
			{
			case 1: System.out.println("Enter the actors name: ");
			String actorName = in.nextLine();
			foundList = ch.searchByActorName(actorName);
			if(!foundList.isEmpty())
			{
				found = foundList.get(0);
				System.out.println("Which attribute would you like to change:");
				System.out.println("1) -- Characters name");
				System.out.println("2) -- Characters rank");
				System.out.println("3) -- Actors name");
				System.out.println("Make your choice: ");
				int editChoice = in.nextInt();
				in.nextLine();
				if(editChoice == 1)
				{
					System.out.println("Enter the new characters name: ");
					String newName = in.nextLine();
					found.setCharacter(newName);
				}
				else if(editChoice == 2)
				{
					System.out.println("Enter the new characters rank: ");
					String newRank = in.nextLine();
					found.setRank(newRank);
				}
				else if(editChoice == 3)
				{
					System.out.println("Enter the new actors name: ");
					String newActor = in.nextLine();
					found.setActor(newActor);
				}
				else
				{
					System.out.println("Not a valid selection!");
				}
				ch.update(found);
			}
			else
			{
				System.out.println("Character not found!");
			}
			loopContinue = false;
					
				break;
			case 2: System.out.println("Enter the characters name: ");
					String name = in.nextLine();
					foundList = ch.searchByName(name);
					if(!foundList.isEmpty())
					{
						found = foundList.get(0);
						System.out.println("Which attribute would you like to change:");
						System.out.println("1) -- Characters name");
						System.out.println("2) -- Characters rank");
						System.out.println("3) -- Actors name");
						System.out.println("Make your choice: ");
						int editChoice = in.nextInt();
						in.nextLine();
						if(editChoice == 1)
						{
							System.out.println("Enter the new characters name: ");
							String newName = in.nextLine();
							found.setCharacter(newName);
						}
						else if(editChoice == 2)
						{
							System.out.println("Enter the new characters rank: ");
							String newRank = in.nextLine();
							found.setRank(newRank);
						}
						else if(editChoice == 3)
						{
							System.out.println("Enter the new actors name: ");
							String newActor = in.nextLine();
							found.setActor(newActor);
						}
						else
						{
							System.out.println("Not a valid selection!");
						}
						ch.update(found);
					}
					else
					{
						System.out.println("Character not found!");
					}
					loopContinue = false;
					
				break;
				default: System.out.println("Not a valid choice!");
			}
		}
		
		System.out.println("Enter the ID number for character you would like to edit: ");
		
	}
	/*
	 * @ void create a new List of Cast from the returned value of the outputFullList method
	 * based on the size of the full list call the outputDetails method to output the details
	 * of each object in the list
	 */
	private static void viewFullList()
	{
		List<Cast> fullList = ch.outputFullList();
		System.out.println(fullList.size());
		for(int i = 0; i < fullList.size(); i++)
		{
			System.out.println(fullList.get(i).outputDetails());
		}
	}
	/*
	 * @void call the viewFullList method to output the contents of the database to show all of the objects
	 * that can be deleted. Ask the user for the ID of the object they would like to delete and call the delete method
	 */
	private static void deleteCharacter()
	{
		viewFullList();
		System.out.println("Enter the Id of the character you would like to delete");
		int deleteId = in.nextInt();
		in.nextLine();
		ch.delete(deleteId);	
	}
	/*
	 *  @ void display the menu options to user on a loop until the user chooses to exit the loop
	 *  prompts the user for available actions and based in user input either calls the appropriate
	 *  method of exits the program
	 */
	public static void mainMenu()
	{
		boolean loopContinue = true;
		System.out.println("--------- Welcome To The Star Trek Character List ---------");
		while(loopContinue)
		{
			System.out.println("1) -- Add a new Star Trek character --");
			System.out.println("2) -- Edit an existing character");
			System.out.println("3) -- View all current characters");
			System.out.println("4) -- Delete a character");
			System.out.println("5) -- Exit the program");
			System.out.println("Make your choice: ");
			
			int choice = in.nextInt();
			in.nextLine();
			
			switch(choice)
			{
			case 1: addNewCast();
				break;
			case 2: editCurrentCast(); 
				break;
			case 3: viewFullList();
				break;
			case 4: deleteCharacter();
				break;
			case 5: System.out.println("Come back soon!"); loopContinue = false;
				break;
				default:
			}
		}
	}
	
	public static void main(String[] args)
	{
		mainMenu();
	}
	
}

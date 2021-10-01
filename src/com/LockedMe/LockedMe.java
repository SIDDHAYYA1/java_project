package com.LockedMe;
import java.util.*;
import java.io.*;

public class LockedMe {
	public static void main(String[] args) {
		File file = new File("main");
		// If main folder doesn't exist, create the main folder
		if (!file.exists()) {
			file.mkdirs();
		}
	
		System.out.println("*****************************************************\n"
				+ "      Welcome to LockedMe.com. \n" + "      This application is developed by Ajinkya Kadam.\n"
				+ "*****************************************************\n");
		System.out.println("This application is developed for file handling.You can use this application to :\n"
		+ "1.Retrieve all file names in the \"main\" folder\n"
		+ "2.Search, add, or delete files in \"main\" folder.\n"
		+ "\n**Please be careful to ensure the correct filename is provided for deleting files.**\n");
		userInput();
}
	
public static void userInput() {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Retrieve all files inside \"main\" folder\n" + "2) Display menu for File operations\n"
				+ "3) Exit program\n");
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileOperations.displayAllFiles("main");
					break;
				case 2:
					menuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					run = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				System.out.println("Please enter valid input!!!!");
				userInput();
			} 
		} while (run == true);
	
	}
	
	
	
	public static void menuOptions() {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Add a file to \"main\" folder\n" + "2) Delete a file from \"main\" folder\n"
				+ "3) Search for a file from \"main\" folder\n" + "4) Show Previous Menu\n" + "5) Exit program\n");
				File file = new File("main");

				// If file doesn't exist, create the main folder
				if (!file.exists()) {
					file.mkdirs();
				}
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
	
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					FileOperations.createFile(fileToAdd, sc);
					
					break;
				case 2:
					
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					FileOperations.createMainFolder("main");
					List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						
						for (String path : filesToDelete) {
							FileOperations.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					
					FileOperations.createMainFolder("main");
					FileOperations.displayFileLocations(fileName, "main");
					
					break;
				case 4:
					
					return;
				case 5:
					
					System.out.println("Program exited successfully!!!!!!");
					run = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid input:");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				System.out.println("Please enter valid input!!!");
				menuOptions();
			}
		} while (run == true);
	}

}

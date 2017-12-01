package ie.lyit.testers;

import ie.lyit.hotel.*;
import ie.lyit.serialize.CustomerSerializer;
import java.util.*;


public class CustomerSerializerTester 
{
	
		public static void main(String[] args) 
		{
			
			Scanner keyboardIn = new Scanner(System.in);
			CustomerSerializer customerSerializer = new CustomerSerializer();
			
			int option;
			
			//READING CONTENTS FROM FILE BEFORE 
			customerSerializer.readRecordsFromFile();
			
			//CREATING MENU FOR THE USER TO SELECT OPTION THEY WANT 
			do {
				
				System.out.print("\n");
				System.out.println("OPTION 1: Add Customer");
				System.out.println("OPTION 2: View Customer");
				System.out.println("OPTION 3: Edit Customer");
				System.out.println("OPTION 4: Delete Customer");
				System.out.println("OPTION 5: List Customer");
				System.out.println("OPTION 6: Exit Menu");
				
				System.out.println("\nPlease Select A Valid Option: ");
				option = keyboardIn.nextInt();
				
				if(option == 1)
				{
					customerSerializer.add();
					
					System.out.println("\nCUSTOMER ADDED");
				}
								
				else if(option == 2)
				{
					customerSerializer.view();

				}
				
				else if(option == 3)
				{
					customerSerializer.edit();
					System.out.println("\nCustomer Edited");
				}
				
				else if(option == 4)
				{
					customerSerializer.delete();
					System.out.println("\nCustomer Deleted");

				}
				
				else if(option == 5)
				{
					System.out.println("\nList Customers");

					customerSerializer.list();
					
				}
				
				else if(option == 6)
				{
					System.out.println("EXIT MENU - GOODBYE");
				}
				
				System.out.print("\n");

			
		}while(option != 6);
			
			//WRITE THE CHANGES TO THE FILE 
			customerSerializer.writeRecordsToFile();

      }

	}


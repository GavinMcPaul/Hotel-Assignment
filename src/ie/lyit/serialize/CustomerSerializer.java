package ie.lyit.serialize;

import java.util.*;
import ie.lyit.hotel.Customer;
import java.io.*;

public class CustomerSerializer implements Serializable, DAOCustomer{
	
	private ArrayList<Customer> customers;
	
	private final String FILENAME = "customers.ser";
	
	int newNumber =1;
	
	//DEFAULT CONSTRUCTOR
	public CustomerSerializer()
	{
		customers = new ArrayList<Customer>(); //creating arraylist of customers
	}
	

	public void add()
	{
		//CREATING A CUSTOMER OBJECT 
		Customer customer = new Customer();
		//READ ITS DETAILS 
		customer.read();
		
		customer.setNumber(customers.size() + 1); //setting customer number before customer is added
		// AND ADD IT TO THE CUSTOMER ARRAY
		customers.add(customer);
		//System.out.println("/nCUSTOMER ADDED");
	}
	
	public void list()
	{
		//DIAPLAYING ALL THE CUTOMERS IN THE ARRAYLIST 
		for(Customer tmpCustomer:customers)
		{
			//System.out.println("/n CUSTOMERS LISTED");
			System.out.println(tmpCustomer);
		}	
	
	 }
	
	public Customer view() {
		
		Scanner keyboard = new Scanner(System.in);
		
		//READ THE NUMBER OF THE CUTOMER TO BE VIEWED FROM THE USER 
		System.out.println("\nENTER NUMBER OF CUSTOMER :");
	
		int customerToView=keyboard.nextInt();
		
		// for every customer object in customer
	    for(Customer tmpCustomer:customers)
	    {
		   if(tmpCustomer.getNumber() == customerToView)
		   {
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    return null;		
	}
	public void delete()
	{
		//CALL VIEW() TO FIND, DISPLAY & RETURN The customer TO DLEETE 
		Customer tempCustomer = view();
		//IF THE CUSTOMER WAS NOT FOUND 
		if(tempCustomer != null)
		{
			customers.remove(tempCustomer);
		}
		
			for(Customer tmpCustomer: customers)
			{
				tmpCustomer.setNumber(newNumber);
				newNumber++;
			}
		
		//System.out.println("/n CUSTOMER DELETED");

	}
	
	public void edit(){	
		// Call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
	    if(tempCustomer != null)
	    {
		   // get it's index
		   int index=customers.indexOf(tempCustomer);
		   // read in a new customer and...
		   tempCustomer.read();
		   // reset the object in customers
		   customers.set(index, tempCustomer);
	    }
	}
	
	public void writeRecordsToFile()
	{
		ObjectOutputStream os = null;
		
		try {
			
				FileOutputStream filestream = new FileOutputStream(FILENAME);
				
				os = new ObjectOutputStream(filestream);
				
				os.writeObject(customers);
				
		}
		
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file to store customers.");
		}
	
	
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
		
		finally {
			
			try {
				os.close();
			}
			
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}

	// This method will deserialize the customers ArrayList when called, 
	// i.e. it will restore the ArrayList from the file customers.ser
	public void readRecordsFromFile(){
		ObjectInputStream is=null;
		
		try {
			//Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			is = new ObjectInputStream(fileStream);
				
			customers = (ArrayList<Customer>)is.readObject();	
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customers.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try 
			{
				is.close();
			}
			
			catch(IOException ioE)
			{
				System.out.println(ioE.getMessage());
			}
		}
	}
}

package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface DAOCustomer
{
	
	public void add();
	public void delete();
	public void list();
	public Customer view();
	public void writeRecordsToFile();
	public void readRecordsFromFile();	

}

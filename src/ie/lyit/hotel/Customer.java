package ie.lyit.hotel;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Customer extends Person implements Serializable{
	
	private String emailAddress;    
	private int number;			    

	private static int nextNumber=1;
	
	// Default Constructor
	// Called when object is created like this ==> 
	// Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}
	
	// Initialization Constructor
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return "Customer Number " + number + " " +  super.toString() + "," + emailAddress;
		
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress=emailAddress;
	}
	
	public String getEmailAddress()
	{
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber()
	{
		return number;
	}
	
	public void setNumber(int number)
	{
		this.number=number;
	}

	//CREATING A GUI TO BE DISPLAYED WHEN THE ADD METHID IS CALLED 
	public void read() {
		{
		
	     JTextField txtCustomerNo = new JTextField();
	     txtCustomerNo.setText("" + this.getNumber());
	     
	      JTextField txtName = new JTextField();
	      txtName.requestFocus();
	      JTextField txtTitle = new JTextField();
	      JTextField txtSurname = new JTextField();
	      JTextField txtEmailAddress = new JTextField();
		  JTextField txtAddress= new JTextField();
		  JTextField txtPhoneNo= new JTextField();



	      Object[] message = {
		      "Customer Number:", txtCustomerNo,
		      "Title", txtTitle,
	          "First Name", txtName,
	          "Surname", txtSurname,
	          "Customer Phone Number:", txtPhoneNo,
	          "Address:", txtAddress,
	          "Email Address:", txtEmailAddress,
	          
	      };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	          this.name.setTitle(txtTitle.getText());
	          this.name.setFirstName(txtName.getText());
	          this.name.setSurname(txtSurname.getText());
	          this.number = Integer.parseInt(txtCustomerNo.getText());
	          this.phoneNumber = txtPhoneNo.getText();
	          this.address = txtAddress.getText();
	          this.emailAddress = txtEmailAddress.getText();
	      } 
	      	
			}
		}
	}

	        
		
       
	

